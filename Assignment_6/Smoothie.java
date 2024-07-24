/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: Create a class to represent a beverage smoothie.
 * Due: 08/05/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Isaiah Byrd
*/
public class Smoothie extends Beverage {
	
	private int numOfFruits;
    private boolean addProtein;
    private final double FRUIT_COST = .5;
    private final double PROTEIN_COST = 1.5;
	
    
    //constructors
    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
    	super(bevName, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    //Methods
    public int getNumOfFruits() {
    	return numOfFruits;
    }
    
    public boolean getAddProtein() {
    	return addProtein;
    }
    
    public String toString() {
        String s = getBevName() + ", " + getSize() + " " + numOfFruits + " Fruits";
        if (addProtein) {
            s += " Protein powder";
        }
    
        s += ", $" +calcPrice();
    
        return s;
    }
    
    public double calcPrice() {
        double price = super.getBasePrice();
        
        if (super.getSize() == Size.MEDIUM) {
                price += super.addSizePrice();
        }
        else if (super.getSize() == Size.LARGE) {
                price += 2 * super.addSizePrice();
        }
        
        price += numOfFruits * FRUIT_COST;
        
        if (addProtein) {
                price += PROTEIN_COST;
        }
        
        return price;
    }
    
    public boolean equals(Smoothie s) {
        if (super.equals(s) && numOfFruits==s.getNumOfFruits() && addProtein==s.getAddProtein()) {
                return true;
        }
        else {
                return false;
        }
    }

    
}
