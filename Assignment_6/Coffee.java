/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: Create a class to represent a beverage coffee.
 * Due: 08/05/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Isaiah Byrd
*/

public class Coffee extends Beverage {

	private boolean extraShot;
	private boolean extraSyrup;
	private final double SHOT_COST = .5;
	private final double SYRUP_COST = .5;
	
	//constructors
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		 super(bevName, Type.COFFEE, size);
		 this.extraShot = extraShot;
		 this.extraSyrup = extraSyrup;

	}
	
	//methods
	public boolean getExtraShot() {
		return extraShot;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	@Override
	public double calcPrice() {
        double price = super.getBasePrice();
         
        if (super.getSize() == Size.MEDIUM) {
                 price += super.addSizePrice();
        }
        else if (super.getSize() == Size.LARGE) {
                 price += 2 * super.addSizePrice();
        }
         
        if (extraShot) {
                 price += SHOT_COST;
        }
        if (extraSyrup) {
                 price += SYRUP_COST;
        }
         
        return price;
	}
	
	@Override
	public String toString() {
		String s = getBevName() +", " +getSize();
         
        if (extraShot) {
                s += " Extra shot";
        }
        if (extraSyrup) {
                s += " Extra syrup";
        }
         
        s += ", $" + calcPrice();
         
        return s;
	}
	
	
	public boolean equals(Coffee anotherCoffee) {
        if (super.equals(anotherCoffee) && extraShot==anotherCoffee.getExtraShot() && extraSyrup==anotherCoffee.getExtraSyrup()) {
                return true;
        }
        else {
            return false;
        }
	}
	
	

	
}
