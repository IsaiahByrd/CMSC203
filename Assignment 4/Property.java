/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents a property in a management company
 * Due: 07/08/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Isaiah Byrd
*/
public class Property {

	//fields
	private String propertyName;
	private String city;
	private String owner;
	private double rentAmount;
	private Plot plot;
	
	//constructors
	public Property() {
		
		propertyName = "";
		city = "";
		owner = "";
		
		plot = new Plot(); //create new plot object
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        
        this.plot = new Plot();
    }
	
	public Property(String propertyName, String city, double rentAmount, String owner,
            int x, int y, int width, int depth) {
		
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;

		this.plot = new Plot(x, y, width, depth);
	}
	
	public Property(Property otherProperty) {
        
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        
        
        this.plot = new Plot(otherProperty.plot);
    }
	
	//setters
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	//getters
	 public Plot getPlot() {
		 return plot;
	 }
	 
	 public String getPropertyName() {
		 return propertyName;
	 }
	 
	 public String getCity() {
		 return city;
	 }
	 
	 public double getRentAmount() {
		 return rentAmount;
	 }
	 
	 public String getOwner() {
		 return owner;
	 }
	 
	 //toString method
	 public String toString() {
	        return propertyName + "," + city + "," + owner + "," + rentAmount;
	    }
}
