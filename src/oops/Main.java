package oops;

public class Main {
	public static void main(String[] args) {
		Son son = new Son();
		son.dadProperty();
		
		
		
		Mobile mobile = new Mobile();

        mobile.setBrand("Samsung");
        mobile.setModel("Galaxy S25");
        mobile.setPrice(80000);

        System.out.println(mobile.getBrand());
        System.out.println(mobile.getModel());
        System.out.println(mobile.getPrice());
    }
}



