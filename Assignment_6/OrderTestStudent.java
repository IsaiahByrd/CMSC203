import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class OrderTestStudent {

    @Test
    public void testGenerateOrder() {
        Order order = new Order(12, Day.MONDAY, new Customer("John Doe", 22));
        int orderNo = order.generateOrder();

        // Ensure that the generated order number is within the expected range
        assertTrue(orderNo >= 10_000 && orderNo < 90_000);
    }

    @Test
    public void testGetOrderNo() {
    	Order order = new Order(12, Day.MONDAY, new Customer("John Doe", 22));

        // Ensure that the getOrderNo method returns a non-negative value
        assertTrue(order.getOrderNo() >= 0);
    }

    @Test
    public void testGetOrderTime() {
    	Order order = new Order(12, Day.MONDAY, new Customer("John Doe", 22));

        // Ensure that the getOrderTime method returns the expected order time
        assertEquals(12, order.getOrderTime());
    }

    @Test
    public void testGetOrderDay() {
    	Order order = new Order(12, Day.MONDAY, new Customer("John Doe", 22));

        // Ensure that the getOrderDay method returns the expected order day
        assertEquals(Day.MONDAY, order.getOrderDay());
    }

    // Add more test methods for other methods in the Order class...

    @Test
    public void testCalcOrderTotal() {
    	Order order = new Order(12, Day.MONDAY, new Customer("John Doe", 22));
        order.addNewBeverage("Coffee", Size.MEDIUM, false, false);
        order.addNewBeverage("Alcohol", Size.LARGE);
        order.addNewBeverage("Smoothie", Size.SMALL, 3, true);

        // Ensure that the calcOrderTotal method calculates the total correctly
        assertEquals(11.5, order.calcOrderTotal(), 0.001); // Provide a delta for double comparison
    }

    @Test
    public void testFindNumOfBeveType() {
    	Order order = new Order(12, Day.MONDAY, new Customer("John Doe", 22));
        order.addNewBeverage("Coffee", Size.MEDIUM, false, false);
        order.addNewBeverage("Alcohol", Size.LARGE);
        order.addNewBeverage("Smoothie", Size.SMALL, 3, true);

        // Ensure that the findNumOfBeveType method returns the correct count
        assertEquals(1, order.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, order.findNumOfBeveType(Type.ALCOHOL));
        assertEquals(1, order.findNumOfBeveType(Type.SMOOTHIE));
    }

    // Add more test methods as needed...

}
