/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Junit test cases for all constructors and methods in ManagementCompany class
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

class ManagementCompanyTestStudent {

    @Test
    void testManagementCompany() {
        ManagementCompany managementCompany = new ManagementCompany();
        assertEquals("", managementCompany.getName());
        assertEquals("", managementCompany.getTaxID());
        
    }

    @Test
    void testManagementCompanyStringStringDouble() {
        ManagementCompany managementCompany = new ManagementCompany("Company Name", "Tax ID", 10.0);

        assertEquals("Company Name", managementCompany.getName());
        assertEquals("Tax ID", managementCompany.getTaxID());
        assertEquals(10.0, managementCompany.getMgmFeePer());
    }

    @Test
    void testManagementCompanyStringStringDoubleIntIntIntInt() {
        ManagementCompany managementCompany = new ManagementCompany("Company Name", "Tax ID", 10.0, 1, 1, 5, 5);
  
        assertEquals("Company Name", managementCompany.getName());
        assertEquals("Tax ID", managementCompany.getTaxID());
        assertEquals(10.0, managementCompany.getMgmFeePer());
    }

    @Test
    void testAddPropertyStringStringDoubleString() {
        ManagementCompany managementCompany = new ManagementCompany();
        Property property = new Property("PropertyName", "City", 100.0, "Owner");
        assertEquals(0, managementCompany.addProperty(property));
    }

    @Test
    void testAddPropertyStringStringDoubleStringIntIntIntInt() {
        ManagementCompany managementCompany = new ManagementCompany();
        assertEquals(0, managementCompany.addProperty("PropertyName", "City", 100.0, "Owner", 1, 1, 5, 5));
    }

    @Test
    void testAddPropertyProperty() {
        ManagementCompany managementCompany = new ManagementCompany();
        Property property = new Property("PropertyName", "City", 100.0, "Owner");
        assertEquals(0, managementCompany.addProperty(property));
    }

    @Test
    void testRemoveLastProperty() {
        ManagementCompany managementCompany = new ManagementCompany();
        Property property1 = new Property("Property1", "Anapolis", 543.0, "Rodney");
        Property property2 = new Property("Property2", "Baltimore", 230.0, "Isaiah");
        managementCompany.addProperty(property1);
        managementCompany.addProperty(property2);
        int initialPropertyCount = managementCompany.getPropertiesCount();
        managementCompany.removeLastProperty();

        //check if the number of properties has decreased by 1 after removing the last property
        assertEquals(initialPropertyCount - 1, managementCompany.getPropertiesCount());

       
    }


    @Test
    void testIsPropertiesFull() {
        ManagementCompany managementCompany = new ManagementCompany();
        assertFalse(managementCompany.isPropertiesFull());
    }

    @Test
    void testIsManagementFeeValid() {
        ManagementCompany managementCompany = new ManagementCompany();
        assertTrue(managementCompany.isManagementFeeValid());
    }

    @Test
    void testToString() {
        ManagementCompany managementCompany = new ManagementCompany("Rodney Inc.", "1685498", 10.0);
        Property property = new Property("PropertyName", "City", 100.0, "Owner");
        managementCompany.addProperty(property);
        String expectedString = "List of the properties for Rodney Inc., taxID: 1685498\n" +
                "______________________________________________________\n" +
                "PropertyName,City,Owner,100.0\n" +
                "______________________________________________________\n\n" +
                " total management Fee: 10.0";
        assertEquals(expectedString, managementCompany.toString());
    }
}
