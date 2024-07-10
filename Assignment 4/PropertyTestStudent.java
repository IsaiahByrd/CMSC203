/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Junit test cases for all constructors and methods in Property class
 * Due: 07/08/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Isaiah Byrd
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

    @Test
    void testProperty() {
        Property property = new Property();
        
        assertEquals("", property.getPropertyName());
        assertEquals("", property.getCity());
        assertEquals("", property.getOwner());
        
        
    }

    @Test
    void testPropertyStringStringDoubleString() {
        String propertyName = "RandomProperty";
        String city = "RandomCity";
        double rentAmount = Math.random() * 3000; // Random rent amount between 0 and 3000
        String owner = "RandomOwner";
        Property property = new Property(propertyName, city, rentAmount, owner);
        
        assertEquals(propertyName, property.getPropertyName());
        assertEquals(city, property.getCity());
        assertEquals(rentAmount, property.getRentAmount());
        assertEquals(owner, property.getOwner());
    }

    @Test
    void testPropertyStringStringDoubleStringIntIntIntInt() {
        String propertyName = "RandomProperty";
        String city = "RandomCity";
        double rentAmount = Math.random() * 3000; 
        String owner = "RandomOwner";
        int x = (int) (Math.random() * 10); // Random x coordinate between 0 and 10
        int y = (int) (Math.random() * 10); // Random y coordinate between 0 and 10
        int width = (int) (Math.random() * 10); // Random width between 0 and 10
        int depth = (int) (Math.random() * 10); // Random depth between 0 and 10

        Property property = new Property(propertyName, city, rentAmount, owner, x, y, width, depth);
        
        assertEquals(propertyName, property.getPropertyName());
        assertEquals(city, property.getCity());
        assertEquals(rentAmount, property.getRentAmount());
        assertEquals(owner, property.getOwner());
        assertEquals(x, property.getPlot().getX());
        assertEquals(y, property.getPlot().getY());
        assertEquals(width, property.getPlot().getWidth());
        assertEquals(depth, property.getPlot().getDepth());
    }

    @Test
    void testPropertyProperty() {
        Property originalProperty = new Property("OrigProperty", "OrigCity", 500.0, "OrigOwner");
        Property copiedProperty = new Property(originalProperty);
     
        assertEquals(originalProperty.getPropertyName(), copiedProperty.getPropertyName());
        assertEquals(originalProperty.getCity(), copiedProperty.getCity());
        assertEquals(originalProperty.getRentAmount(), copiedProperty.getRentAmount());
        assertEquals(originalProperty.getOwner(), copiedProperty.getOwner());
        assertEquals(originalProperty.getPlot().getX(), copiedProperty.getPlot().getX());
        assertEquals(originalProperty.getPlot().getY(), copiedProperty.getPlot().getY());
        assertEquals(originalProperty.getPlot().getWidth(), copiedProperty.getPlot().getWidth());
        assertEquals(originalProperty.getPlot().getDepth(), copiedProperty.getPlot().getDepth());
    }

    @Test
    void testToString() {
    	Property propertyOne = new Property("Monopoly Property", "Gaithersburg", 1600.0, "Capital One");
    	
    	assertEquals("Monopoly Property,Gaithersburg,Capital One,1600.0",propertyOne.toString());
    	
 
      
    }
}
