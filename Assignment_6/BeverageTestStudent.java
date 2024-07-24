import static org.junit.Assert.*;
import org.junit.Test;

public class BeverageTestStudent {

    @Test
    public void testCalcPrice() {
        Beverage beverage = new ConcreteBeverage("Test Beverage", Type.SMOOTHIE, Size.SMALL);

        // Test the calcPrice method with specific inputs
        double expectedPrice = 0.0;
        assertEquals(expectedPrice, beverage.calcPrice(), 0.01);
    }

    @Test
    public void testEquals() {
        Beverage beverage1 = new ConcreteBeverage("Test Beverage", Type.COFFEE, Size.SMALL);
        Beverage beverage2 = new ConcreteBeverage("Test Beverage", Type.COFFEE, Size.SMALL);
        Beverage beverage3 = new ConcreteBeverage("Different Beverage", Type.ALCOHOL, Size.LARGE);

        // Test equals method with equal and unequal beverages
        assertTrue(beverage1.equals(beverage2));
        assertFalse(beverage1.equals(beverage3));
    }


    private static class ConcreteBeverage extends Beverage {
        public ConcreteBeverage(String bevName, Type type, Size size) {
            super(bevName, type, size);
        }

        @Override
        public double calcPrice() {
            return addSizePrice();
        }
    }
}
