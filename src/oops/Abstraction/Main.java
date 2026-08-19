package oops.Abstraction;

public class Main {

    public static void main(String[] args) {

        Payment payment1 = new UPI();

        payment1.pay(500);
        payment1.paymentSuccess();

        Payment payment2 = new CreditCard();

        payment2.pay(1000);
        payment2.paymentSuccess();
    }
}