public class Barista {
    private int coffeePrice;
    private int beanCount;
    private int cashBox;

    public Barista() {
        coffeePrice = 3000;
        beanCount = 2;
        cashBox = 0;
    }

    public Barista(int coffeePrice, int beanCount) {
        this.coffeePrice = coffeePrice;
        this.beanCount = beanCount;
        cashBox = 0;
    }


    public int getCoffeePrice() {
        return coffeePrice;
    }

    public boolean checkCoffee() {
        if( beanCount > 0)
            return true;
        else
            return false;
    }

    public String makeCoffee(String menuName) {
        beanCount--;
        System.out.println("[바리스타] 제조가 완료되었습니다 현재 원두는" + beanCount + "개 입니다.");
        return "아메리카노";
    }

    public String takeOrder(String menuName, int payment) {
        System.out.println("[바리스타] 주문을 확인했습니다.");

        if( checkCoffee() == false){
            System.out.println("[바리스타] 원두가 없어서 주문이 불가능 합니다.");
            //todo: 받은 돈 돌려주기 개발 필요
            return "0";
        }

        cashBox = cashBox + payment;
        System.out.println("[바리스타] 잔고는" + cashBox + "원 입니다.");

        String madeCoffee = makeCoffee(menuName);
        return madeCoffee;
    }
}



