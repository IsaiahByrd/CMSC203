/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents the junit test cases for the Plot class
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

class PlotTestStudent {

    @Test
    void testPlot() {
        Plot plot = new Plot();
       
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
    }

    @Test
    void testPlotIntIntIntInt() {
        Plot plot = new Plot(2, 3, 4, 5);
        
        assertEquals(2, plot.getX());
        assertEquals(3, plot.getY());
        assertEquals(4, plot.getWidth());
        assertEquals(5, plot.getDepth());
    }

    @Test
    void testPlotPlot() {
        Plot originalPlot = new Plot(2, 3, 4, 5);
        Plot plot = new Plot(originalPlot);
        
        assertEquals(2, plot.getX());
        assertEquals(3, plot.getY());
        assertEquals(4, plot.getWidth());
        assertEquals(5, plot.getDepth());
    }

    @Test
    void testOverlaps() {
        Plot plot1 = new Plot(2, 3, 4, 5);
        Plot plot2 = new Plot(4, 6, 3, 2);
        Plot plot3 = new Plot(7, 8, 1, 1);

        assertTrue(plot1.overlaps(plot2));
        assertFalse(plot1.overlaps(plot3));
    }

    @Test
    void testEncompasses() {
        Plot plot1 = new Plot(2, 3, 4, 5);
        Plot plot2 = new Plot(3, 4, 2, 3);
        Plot plot3 = new Plot(5, 6, 3, 3);

        assertTrue(plot1.encompasses(plot2));
        assertFalse(plot1.encompasses(plot3));
    }

    @Test
    void testToString() {
        Plot plot = new Plot(2, 3, 4, 5);
        String expectedString = "2,3,4,5";
        assertEquals(expectedString, plot.toString());
    }
}
