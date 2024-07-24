import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CoffeeTestStudent {

    private Coffee coffee;

    @Before
    public void setUp() {
        // Initialize a Coffee object with some default values
        coffee = new Coffee("Black Coffee", Size.MEDIUM, true, false);
    }

    @Test
    public void testGetExtraShot() {
        assertTrue(coffee.getExtraShot());
    }

    @Test
    public void testGetExtraSyrup() {
        assertFalse(coffee.getExtraSyrup());
    }

    @Test
    public void testCalcPrice() {
        // Assuming a base price of 2.0 for the Coffee
        // Medium size should add 1.0 to the base price
        // Extra shot should add 0.5
        assertEquals(3.0, coffee.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        String expected = "Black Coffee, MEDIUM Extra shot, $3.0";
        assertEquals(expected, coffee.toString());
    }

    @Test
    public void testEquals() {
        // Create a Coffee object with the same values
        Coffee anotherCoffee = new Coffee("Black Coffee", Size.MEDIUM, true, false);
        assertTrue(coffee.equals(anotherCoffee));
    }

    @Test
    public void testNotEquals() {
        // Create a Coffee object with different values
        Coffee anotherCoffee = new Coffee("Latte", Size.LARGE, false, true);
        assertFalse(coffee.equals(anotherCoffee));
    }
}
