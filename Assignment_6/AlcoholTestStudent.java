import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AlcoholTestStudent {

    @Test
    public void testCalcPrice() {
        // Test the calcPrice method with different scenarios

        // Example 1: Medium size, weekend
        Alcohol alcohol1 = new Alcohol("Beer", Size.MEDIUM, true);
        assertEquals(3.1, alcohol1.calcPrice(), 0.001);

        // Example 2: Large size, not weekend
        Alcohol alcohol2 = new Alcohol("Wine", Size.LARGE, false);
        assertEquals(4.0, alcohol2.calcPrice(), 0.001);
    }

    @Test
    public void testIsWeekend() {
        // Test the isWeekend method

        // Example 1: Weekend
        Alcohol alcohol1 = new Alcohol("Whiskey", Size.SMALL, true);
        assertTrue(alcohol1.isWeekend());

        // Example 2: Not weekend
        Alcohol alcohol2 = new Alcohol("Vodka", Size.LARGE, false);
        assertFalse(alcohol2.isWeekend());
    }

    @Test
    public void testToString() {
        // Test the toString method

        // Example 1: Small size, weekend
        Alcohol alcohol1 = new Alcohol("Tequila", Size.SMALL, true);
        assertEquals("Tequila, SMALL Weekend, $2.6", alcohol1.toString());

        // Example 2: Medium size, not weekend
        Alcohol alcohol2 = new Alcohol("Rum", Size.MEDIUM, false);
        assertEquals("Rum, MEDIUM, $2.5", alcohol2.toString());
    }

    @Test
    public void testEquals() {
        // Test the equals method

        // Example 1: Two equal instances
        Alcohol alcohol1 = new Alcohol("Gin", Size.LARGE, true);
        Alcohol alcohol2 = new Alcohol("Gin", Size.LARGE, true);
        assertTrue(alcohol1.equals(alcohol2));

        // Example 2: Instances with different properties
        Alcohol alcohol3 = new Alcohol("Whiskey", Size.SMALL, false);
        assertFalse(alcohol1.equals(alcohol3));
    }
}
