import static org.junit.Assert.*;

import org.junit.Test;

public class HolidayBonusTestStudent {

    @Test
    public void testCalculateHolidayBonus() {
        double[][] dataSet1 = { { 10, 20, 30 }, { 40, 50 }, { 60, 70, 80 } };

        try {
            double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
            assertEquals(8000.0, result[0], .001); // Highest sales bonus for store 1
            assertEquals(6000.0, result[1], .001); // Lowest sales bonus for store 2
            assertEquals(8000.0, result[2], .001); // Other stores bonus for store 3
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double[][] dataSet2 = { { 15, 25, 35 }, { 45, 55, 65 }, { 75, 85 } };

        assertEquals(22000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2), .001);
    }

    @Test
    public void testCalculateHolidayBonusWithEmptyData() {
        double[][] emptyData = {};

        try {
            double[] result = HolidayBonus.calculateHolidayBonus(emptyData);
            assertEquals(0, result.length); // No bonuses for an empty dataset
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testCalculateTotalHolidayBonusWithEmptyData() {
        double[][] emptyData = {};

        assertEquals(0.0, HolidayBonus.calculateTotalHolidayBonus(emptyData), .001);
    }
}
