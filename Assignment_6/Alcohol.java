/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: Create a class to represent a beverage alcohol.
 * Due: 08/05/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Isaiah Byrd
*/
public class Alcohol extends Beverage {

	//fields
	private boolean isWeekend;
	final private double WEEKEND_PRICE = .6;
	
	
	
	//constructors
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}

	//methods
	@Override
	public double calcPrice() {
		double price = super.getBasePrice();
        
        if (super.getSize() == Size.MEDIUM) {
                price += super.addSizePrice();
        }
        else if (super.getSize() == Size.LARGE) {
                price += 2 * super.addSizePrice();
        }
        
        if (isWeekend) {
                price += WEEKEND_PRICE;
        }
        
        return price; 
	}
	
	public boolean isWeekend() {
		return isWeekend;
	}
	
	@Override
	public String toString() {
        String s = getBevName() + ", " + getSize();
        
        if (isWeekend) {
                s += " Weekend";
        }         
        
        s += ", $" + calcPrice();
        return s;
	}
	
	 public boolean equals(Alcohol a) {
         if (super.equals(a) && isWeekend == a.isWeekend()) {
                 return true;
         }
         else {
                 return false;
         }
	 }

}
