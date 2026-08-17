package oops;

public class Gaadi {

    public static void main(String[] args) {

        FourWheelers car1;
        car1 = new FourWheelers();
         

        car1.carName = "Toyota.";
        car1.carNumber = "OD02AB1234.";
        car1.seatSize = 5;

        car1.carDetails();
        car1.name();
        
         
        FourWheelers car2 = new FourWheelers();
        car2.carName = "Skoda.";
        car2.seatSize = 4;
        car2.carNumber = "KA01A3412.";
        
        car2.name();
        car2.carDetails(); 
    }
}