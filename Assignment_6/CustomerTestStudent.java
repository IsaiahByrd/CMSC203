import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTestStudent {

    private Customer customer;

    @BeforeEach
    public void setUp() {
        // Initialize a Customer object before each test
        customer = new Customer("John Doe", 30);
    }

    @Test
    public void testCustomerConstructor() {
        Customer testCustomer = new Customer("Jane Smith", 25);
        assertEquals("Jane Smith", testCustomer.getName());
        assertEquals(25, testCustomer.getAge());
    }

    @Test
    public void testCustomerCopyConstructor() {
        Customer original = new Customer("Alice", 40);
        Customer copy = new Customer(original);
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getAge(), copy.getAge());
    }

    @Test
    public void testSetName() {
        customer.setName("Jane Doe");
        assertEquals("Jane Doe", customer.getName());
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", customer.getName());
    }

    @Test
    public void testSetAge() {
        customer.setAge(35);
        assertEquals(35, customer.getAge());
    }

    @Test
    public void testGetAge() {
        assertEquals(30, customer.getAge());
    }

    @Test
    public void testToString() {
        assertEquals("John Doe 30", customer.toString());
    }
}
