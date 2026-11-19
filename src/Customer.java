public class Customer {
    private String name;
    private int money;
    private boolean hasCoffee;

    public Customer()
    {
        money = 0;
        hasCoffee = false;
    }

    public Customer(String name, int money, boolean hasCoffee)
    {
        this.name = name;
        this.money = money;
        this.hasCoffee = hasCoffee;
    }

    public void print()
    {
        System.out.println(money);
        System.out.println(hasCoffee);
    }
    // 잔액이 부족하면 -9 반환, 정상적이면 0으로 반환
    public int pay(int coffeePrice)
    {
        if(money <= coffeePrice) {
            System.out.println(name + "잔액이 부족합니다.");
            return -9;
        }
        money = money - coffeePrice;
        return 0;
    }
    public void order(Barista barista, String menuName)
    {
        int price = barista.getCoffeePrice();
        System.out.println(name + " " + menuName + "를 한 잔 주세요");
        System.out.println("[바리스타] 커피 가격은 " + price + "입니다.");

        int paymentCheck = pay(price);
        if(paymentCheck == -9)
            return;
        else if(paymentCheck == 0) {
            System.out.println(name + price +"원을 지불했습니다.");
            if(barista.checkCoffee() == false) {
                System.out.println("[바리스타] 원두가 없어서 주문이 불가합니다.");
                money = money + price;
                System.out.println("[바리스타]가 " + price + "원을 환불했습니다.");
                System.out.println( name + "[손님] 환불받은 돈은 지갑에 넣었습니다.");
                System.out.println( name + "[손님] 현재 잔액은" + money + "원 입니다.");
                return;
            }
            String coffee = barista.takeOrder(menuName, price);
            takeCoffee(coffee);
        }
    }

    public void takeCoffee(String coffee)
    {
        hasCoffee = true;
        System.out.println( name + coffee + "을 받았습니다.");
    }


}
