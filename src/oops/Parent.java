package oops;

public class Parent {
	
	//Overridden method
	public void dadProperty() {
		System.out.println("I am the dad of a son.");
	}
	
}


class Son extends Parent{
	
	//Overriding method
	public void dadProperty() {
		System.out.println("I am dadProperty from Child");
	}
}
