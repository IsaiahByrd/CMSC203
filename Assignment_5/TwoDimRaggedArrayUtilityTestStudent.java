import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] testArray1 = {
            { 1.0, 2.0, 3.0 },
            { 4.0, 5.0 },
            { 6.0, 7.0, 8.0 }
    };

    private double[][] testArray2 = {
            { 10.5, 20.5, 30.5 },
            { 40.5, 50.5 },
            { 60.5, 70.5, 80.5 }
    };

    private File testFile1;
    private File testFile2;

    @Before
    public void setUp() throws Exception {
        // Create temporary files for testing
        testFile1 = createTestFile(testArray1);
        testFile2 = createTestFile(testArray2);
    }

    @After
    public void tearDown() throws Exception {
        // Delete temporary files after testing
        testFile1.delete();
        testFile2.delete();
    }

    // Test readFile method
    @Test
    public void testReadFile() {
        try {
            double[][] result1 = TwoDimRaggedArrayUtility.readFile(testFile1);
            double[][] result2 = TwoDimRaggedArrayUtility.readFile(testFile2);

            assertArrayEquals(testArray1, result1);
            assertArrayEquals(testArray2, result2);
        } catch (FileNotFoundException e) {
            fail("Should not throw FileNotFoundException");
        }
    }

    // Test writeToFile method
    @Test
    public void testWriteToFile() {
        try {
            // Create temporary files for testing
            File outputFile1 = File.createTempFile("testFile1", ".txt");
            File outputFile2 = File.createTempFile("testFile2", ".txt");

            TwoDimRaggedArrayUtility.writeToFile(testArray1, outputFile1);
            TwoDimRaggedArrayUtility.writeToFile(testArray2, outputFile2);

            // Read the written files to verify
            double[][] result1 = TwoDimRaggedArrayUtility.readFile(outputFile1);
            double[][] result2 = TwoDimRaggedArrayUtility.readFile(outputFile2);

            assertArrayEquals(testArray1, result1);
            assertArrayEquals(testArray2, result2);
        } catch (FileNotFoundException e) {
            fail("Should not throw FileNotFoundException");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    // Test getTotal method
    @Test
    public void testGetTotal() {
        double result1 = TwoDimRaggedArrayUtility.getTotal(testArray1);
        double result2 = TwoDimRaggedArrayUtility.getTotal(testArray2);

        assertEquals(36.0, result1, .001);
        assertEquals(364.0, result2, .001);
    }

    // Add more tests for other methods as needed

    // Helper method to create a temporary file with array data
    private File createTestFile(double[][] array) throws Exception {
        File tempFile = File.createTempFile("testFile", ".txt");
        try (PrintWriter writer = new PrintWriter(tempFile)) {
            for (double[] row : array) {
                for (double value : row) {
                    writer.print(value + " ");
                }
                writer.println();
            }
        }
        return tempFile;
    }
}
