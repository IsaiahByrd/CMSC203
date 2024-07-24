/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: Create a class to represent a general beverage.
 * Due: 08/05/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Isaiah Byrd
*/

public abstract class Beverage {

	private String bevName;
	private Type type;
	private Size size;
	private final double BASE_PRICE = 2;
	private final double SIZE_PRICE = .5;
	
	//constructors
	public Beverage(String bevName, Type type, Size size) {
		
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	//methods
	public void setName(String name) {
         this.bevName = name;
	}
	 
	public void setType(Type type) {
         this.type  = type;
	}
	
	public void setSize(Size size) {
         this.size = size;
	}
	
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	public Type getType() {
		return type;
	}
	
	public String getBevName() {
		return bevName;
	}
	
	public Size getSize() {
		return size;
	}
	
	public double addSizePrice() {
	    double sizePrice = 0.0;
	    switch (size) {
	        case SMALL:
	            sizePrice = 0.0;
	            break;
	        case MEDIUM:
	            sizePrice = SIZE_PRICE;
	            break;
	        case LARGE:
	            sizePrice = 2 * SIZE_PRICE;
	            break;
	    }
	    return sizePrice;
	}

	
	
	public boolean equals(Beverage anotherBev) {
		if ((bevName.equals(anotherBev.getBevName())) && (type == anotherBev.getType())
				&& (size == anotherBev.getSize())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public abstract double calcPrice();
	
	@Override
	public String toString() {
		return bevName + " " + size;
	}
	
	
}
