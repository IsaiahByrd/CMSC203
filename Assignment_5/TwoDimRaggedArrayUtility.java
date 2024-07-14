import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

    public TwoDimRaggedArrayUtility() {
        // Constructor
    }

    /*
     * Reads a two-dimensional ragged array of doubles from a file.
	Returns the read array.
	Throws FileNotFoundException if the file is not found.
     */
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        int numRows = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            numRows++;
        }

        scanner.close();
        scanner = new Scanner(file);

      

        double[][] data = new double[numRows][];
        for (int i = 0; i < numRows; i++) {
            String[] values = scanner.nextLine().split(" ");
            data[i] = new double[values.length];
            for (int j = 0; j < values.length; j++) {
            	
                data[i][j] = Double.parseDouble(values[j]);
            }
        }

        scanner.close();
        return data;
    }

    /*
     * Writes a two-dimensional ragged array of doubles to a file.
		Throws FileNotFoundException if the output file is not valid.
     */
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            for (double[] row : data) {
                for (double value : row) {
                    writer.print(value + " ");
                }
                writer.println();
            }
        }
    }

    //Returns the total sum of all elements in the two-dimensional array.
    public static double getTotal(double[][] data) {
        double total = 0;

        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }

        return total;
    }

    //Returns the average of all elements in the two-dimensional array.
    public static double getAverage(double[][] data) {
        int count = 0;
        double total = 0;

        for (double[] row : data) {
            for (double value : row) {
                total += value;
                count++;
            }
        }

        if (count == 0) {
            return 0; // Avoid division by zero
        }

        return total / count;
    }

    //Returns the total sum of elements in a specific row of the two-dimensional array.
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;

        if (row >= 0 && row < data.length) {
            for (double value : data[row]) {
                total += value;
            }
        }

        return total;
    }

    //Returns the total sum of elements in a specific column of the two-dimensional array.
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;

        for (int row = 0; row < data.length; row++) {
            if (col >= 0 && col < data[row].length) {
                total += data[row][col];
            }
        }

        return total;
    }

    //Returns the highest element in a specific row of the two-dimensional array.
    public static double getHighestInRow(double[][] data, int row) {
        double highest = Double.MIN_VALUE;

        if (row >= 0 && row < data.length) {
            for (double value : data[row]) {
                highest = Math.max(highest, value);
            }
        }

        return highest;
    }

    //Returns the index of the highest element in a specific row of the two-dimensional array.
    public static int getHighestInRowIndex(double[][] data, int row) {
        int highestIndex = -1;

        if (row >= 0 && row < data.length) {
            double highest = Double.MIN_VALUE;
            for (int i = 0; i < data[row].length; i++) {
                if (data[row][i] > highest) {
                    highest = data[row][i];
                    highestIndex = i;
                }
            }
        }

        return highestIndex;
    }

    //Returns the lowest element in a specific row of the two-dimensional array.
    public static double getLowestInRow(double[][] data, int row) {
        double lowest = Double.MAX_VALUE;

        if (row >= 0 && row < data.length) {
            for (double value : data[row]) {
                lowest = Math.min(lowest, value);
            }
        }

        return lowest;
    }

    //Returns the index of the lowest element in a specific row of the two-dimensional array.
    public static int getLowestInRowIndex(double[][] data, int row) {
        int lowestIndex = -1;

        if (row >= 0 && row < data.length) {
            double lowest = Double.MAX_VALUE;
            for (int i = 0; i < data[row].length; i++) {
                if (data[row][i] < lowest) {
                    lowest = data[row][i];
                    lowestIndex = i;
                }
            }
        }

        return lowestIndex;
    }

    //Returns the highest element in a specific column of the two-dimensional array.
    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.MIN_VALUE;

        for (double[] row : data) {
            if (col >= 0 && col < row.length) {
                highest = Math.max(highest, row[col]);
            }
        }

        return highest;
    }

    //Returns the index of the highest element in a specific column of the two-dimensional array.
    public static int getHighestInColumnIndex(double[][] data, int col) {
        int highestIndex = -1;

        for (int i = 0; i < data.length; i++) {
            if (col >= 0 && col < data[i].length) {
                if (highestIndex == -1 || data[i][col] > data[highestIndex][col]) {
                    highestIndex = i;
                }
            }
        }

        return highestIndex;
    }

    //Returns the lowest element in a specific column of the two-dimensional array.
    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.MAX_VALUE;

        for (double[] row : data) {
            if (col >= 0 && col < row.length) {
                lowest = Math.min(lowest, row[col]);
            }
        }

        return lowest;
    }

    //Returns the index of the lowest element in a specific column of the two-dimensional array.
    public static int getLowestInColumnIndex(double[][] data, int col) {
        int lowestIndex = -1;

        for (int i = 0; i < data.length; i++) {
            if (col >= 0 && col < data[i].length) {
                if (lowestIndex == -1 || data[i][col] < data[lowestIndex][col]) {
                    lowestIndex = i;
                }
            }
        }

        return lowestIndex;
    }

    //Returns the highest element in the entire two-dimensional array.
    public static double getHighestInArray(double[][] data) {
        double highest = Double.MIN_VALUE;

        for (double[] row : data) {
            for (double value : row) {
                highest = Math.max(highest, value);
            }
        }

        return highest;
    }

    //Returns the lowest element in the entire two-dimensional array.
    public static double getLowestInArray(double[][] data) {
        double lowest = Double.MAX_VALUE;

        for (double[] row : data) {
            for (double value : row) {
                lowest = Math.min(lowest, value);
            }
        }

        return lowest;
    }
}
