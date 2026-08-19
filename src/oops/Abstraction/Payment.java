package oops.Abstraction;

public abstract class Payment {

    public abstract void pay(double amount);

    public void paymentSuccess() {
        System.out.println("Payment successful!");
    }
}