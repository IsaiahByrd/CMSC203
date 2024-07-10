/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents a management company for properties
 * Due: 07/08/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Isaiah Byrd
*/
public class ManagementCompany {
    private String name;
    private String taxID;
    private double managementFee;


    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;


    private Property[] properties;


    private Plot plot;

    
    private int numberOfProperties;

    // Default constructor
    public ManagementCompany() {
        
        name = "";
        taxID = "";
        
       
        plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);

 
        properties = new Property[MAX_PROPERTY];
        for (int i = 0; i < MAX_PROPERTY; i++) {
            properties[i] = null;
        }

        // Initialize the number of properties to 0
        numberOfProperties = 0;
    }
    
    public ManagementCompany(String name, String taxID, double mgmFee) {
        // Initialize properties with the given values
        this.name = name;
        this.taxID = taxID;
        this.managementFee = mgmFee;

     
        plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);


        properties = new Property[MAX_PROPERTY];
        for (int i = 0; i < MAX_PROPERTY; i++) {
            properties[i] = null;
        }

    
        numberOfProperties = 0;
    }
    
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        
        this(name, taxID, mgmFee);

        // Create a Plot object with the given values
        plot = new Plot(x, y, width, depth);
        
        // Initialize the properties array with maximum property capacity
        properties = new Property[MAX_PROPERTY];
        for (int i = 0; i < MAX_PROPERTY; i++) {
            properties[i] = null;
        }

        // Initialize the number of properties to 0
        numberOfProperties = 0;
    }
    
    // Copy constructor
    public ManagementCompany(ManagementCompany otherCompany) {
     
        this(otherCompany.name, otherCompany.taxID, otherCompany.managementFee);
        
        this.plot = new Plot(otherCompany.plot);
        
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (otherCompany.properties[i] != null) {
                this.properties[i] = new Property(otherCompany.properties[i]);
                this.numberOfProperties++;
            }
        }
    }
    
    // Methods
    public int addProperty(String name, String city, double rent, String owner) {
        
        if (numberOfProperties >= MAX_PROPERTY) {
            return -1; // Array is full
        }

        Property newProperty = new Property(name, city, rent, owner);

        if (newProperty == null) {
            return -2; 
        }

        if (!plot.encompasses(newProperty.getPlot())) {
            return -3; 
        }

        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] != null && properties[i].getPlot().overlaps(newProperty.getPlot())) {
                return -4; // Property plot overlaps with an existing property
            }
        }

        int index = -1;
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] == null) {
                index = i;
                break;
            }
        }

        properties[index] = newProperty;
        numberOfProperties++;

        return index;
    }
    
    public int addProperty(String name, String city, double rent, String owner,
            int x, int y, int width, int depth) {
    	
    	if (numberOfProperties >= MAX_PROPERTY) {
    		return -1; // Array is full
    	}

    	Property newProperty = new Property(name, city, rent, owner, x, y, width, depth);

    	if (newProperty == null) {
    		return -2; 
    	}

    	if (!plot.encompasses(newProperty.getPlot())) {
    		return -3; 
    	}

    	for (int i = 0; i < MAX_PROPERTY; i++) {
    		if (properties[i] != null && properties[i].getPlot().overlaps(newProperty.getPlot())) {
    			return -4; 
    		}
    	}

    
    	int index = -1;
    	for (int i = 0; i < MAX_PROPERTY; i++) {
    		if (properties[i] == null) {
    			index = i;
    			break;
    		}
    	}

    	
    	properties[index] = newProperty;
    	numberOfProperties++;

    	return index;
    }
    
    public int addProperty(Property property) {
        if (numberOfProperties >= MAX_PROPERTY) {
            return -1; 
        }

        if (property == null) {
            return -2; 
        }

        if (!plot.encompasses(property.getPlot())) {
            return -3; 
        }

        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] != null && properties[i].getPlot().overlaps(property.getPlot())) {
                return -4; 
            }
        }

        int index = -1;
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] == null) {
                index = i;
                break;
            }
        }

       
        properties[index] = property;
        numberOfProperties++;

       
        return index;
    }
    
    public void removeLastProperty() {
        int lastPropertyIndex = -1;
        
        for (int i = MAX_PROPERTY - 1; i >= 0; i--) {
            if (properties[i] != null) {
                lastPropertyIndex = i;
                break;
            }
        }

        
        if (lastPropertyIndex != -1) {
            properties[lastPropertyIndex] = null;
            numberOfProperties--;
        }
    }
    
    public boolean isPropertiesFull() {
        return numberOfProperties == MAX_PROPERTY; 
    }
    
    //Getters
    public int getPropertiesCount() {
        return numberOfProperties;
    }
    
    public double getTotalRent() {
        double totalRent = 0.0;
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] != null) {
                totalRent += properties[i].getRentAmount();
            }
        }
        return totalRent;
    }

    public Property getHighestRentProperty() {
        Property highestRentProperty = null;
        double maxRent = 0.0;

        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] != null && properties[i].getRentAmount() > maxRent) {
                maxRent = properties[i].getRentAmount();
                highestRentProperty = properties[i];
            }
        }

        return highestRentProperty;
    }
    
    public boolean isManagementFeeValid() {
        return managementFee >= 0 && managementFee <= 100;
    }
    
    public String getName() {
        return name;
    }
    
    public String getTaxID() {
    	return taxID;
    }
    
    public Property[] getProperties() {
        // Create a new array with the same length as properties
        Property[] copyProperties = new Property[properties.length];

        // Copy elements from properties to copyProperties
        for (int i = 0; i < properties.length; i++) {
            copyProperties[i] = properties[i];
        }

        // Return the copy of the properties array
        return copyProperties;
    }
    
    public double getMgmFeePer() {
        return managementFee;
    }
    
    public Plot getPlot() {
        return plot;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
        result.append("______________________________________________________\n");

        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] != null) {
                result.append(properties[i].getPropertyName()).append(",");
                result.append(properties[i].getCity()).append(",");
                result.append(properties[i].getOwner()).append(",");
                result.append(properties[i].getRentAmount()).append("\n");
                result.append("______________________________________________________\n");
            }
        }

        double totalManagementFee = managementFee * getTotalRent() / 100;
        result.append("\n");
        result.append(" total management Fee: ").append(totalManagementFee);

        return result.toString();
    }

}
