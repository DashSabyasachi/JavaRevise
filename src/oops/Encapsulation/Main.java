package oops.Encapsulation;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.setAccountNumber("123456789");

        account.deposit(10000);
        account.withdraw(3000);

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getBalance());
    }
}