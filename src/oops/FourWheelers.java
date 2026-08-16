package oops;


public class FourWheelers {
	
	String carNumber;
	String carName;
	int seatSize;
	
	public void name() {
		System.out.println("This car brand is " + carName);
	}
	
	public void carDetails() {
		System.out.println("This is a "+ seatSize +" Seater car.");
		System.out.println("This car number is "+ carNumber);
		System.out.println("The brand of the car is " + carName);
	}

}
