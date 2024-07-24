import static org.junit.Assert.*;
import org.junit.Test;

public class SmoothieTestStudent {

    @Test
    public void testSmoothieConstructor() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.LARGE, 3, true);
        assertEquals("Berry Blast", smoothie.getBevName());
        assertEquals(Type.SMOOTHIE, smoothie.getType());
        assertEquals(Size.LARGE, smoothie.getSize());
        assertEquals(3, smoothie.getNumOfFruits());
        assertTrue(smoothie.getAddProtein());
    }

    @Test
    public void testCalcPrice() {
        Smoothie smoothie = new Smoothie("Tropical Delight", Size.MEDIUM, 2, false);
        assertEquals(3.5, smoothie.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        Smoothie smoothie = new Smoothie("Green Machine", Size.SMALL, 1, true);
        String expected = "Green Machine, SMALL 1 Fruits Protein powder, $4.0";
        assertEquals(expected, smoothie.toString());
    }

    @Test
    public void testEquals() {
        Smoothie smoothie1 = new Smoothie("Mango Tango", Size.LARGE, 4, true);
        Smoothie smoothie2 = new Smoothie("Mango Tango", Size.LARGE, 4, true);
        Smoothie smoothie3 = new Smoothie("Berry Burst", Size.MEDIUM, 3, false);

        assertTrue(smoothie1.equals(smoothie2));
        assertFalse(smoothie1.equals(smoothie3));
    }
}
