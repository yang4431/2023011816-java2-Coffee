public class Main{
    public static void main(){
        Customer customer1 = new Customer("길동", 10000, false);
        Barista barista = new Barista(3000, 2);

        customer1.order(barista, "아메리카노");

        System.out.print(" --- ");

        Customer customer2 = new Customer("디보", 5000,false);
        customer2.order(barista, "아메리카노:");


    }
}