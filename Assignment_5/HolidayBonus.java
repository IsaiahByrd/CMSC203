public class HolidayBonus {

    // Constants for bonus amounts
    private static final double HIGHEST_SALES_BONUS = 5000.0;
    private static final double LOWEST_SALES_BONUS = 1000.0;
    private static final double OTHER_STORES_BONUS = 2000.0;

    public HolidayBonus() {
        // Constructor
    }

    public static double[] calculateHolidayBonus(double[][] data) {
        int stores = data.length;
        double[] bonuses = new double[stores];

        for (int i = 0; i < stores; i++) {
            int highestSalesIndex = TwoDimRaggedArrayUtility.getHighestInRowIndex(data, i);
            int lowestSalesIndex = TwoDimRaggedArrayUtility.getLowestInRowIndex(data, i);

            for (int j = 0; j < data[i].length; j++) {
                if (j == highestSalesIndex) {
                    bonuses[i] += HIGHEST_SALES_BONUS; // Bonus for highest sales
                } else if (j == lowestSalesIndex) {
                    bonuses[i] += LOWEST_SALES_BONUS;  // Bonus for lowest sales
                } else {
                    bonuses[i] += OTHER_STORES_BONUS;  // Bonus for other stores
                }
            }
        }

        return bonuses;
    }





    public static double calculateTotalHolidayBonus(double[][] data) {
        double totalBonus = 0;

        for (double[] row : data) {
            totalBonus += calculateRowTotalHolidayBonus(row);
        }

        return totalBonus;
    }

    private static double calculateRowTotalHolidayBonus(double[] row) {
        double rowTotalBonus = 0;

        int highestSalesIndex = TwoDimRaggedArrayUtility.getHighestInRowIndex(new double[][] { row }, 0);
        int lowestSalesIndex = TwoDimRaggedArrayUtility.getLowestInRowIndex(new double[][] { row }, 0);

        for (int j = 0; j < row.length; j++) {
            if (j == highestSalesIndex) {
                rowTotalBonus += HIGHEST_SALES_BONUS; // Bonus for highest sales
            } else if (j == lowestSalesIndex) {
                rowTotalBonus += LOWEST_SALES_BONUS;  // Bonus for lowest sales
            } else {
                rowTotalBonus += OTHER_STORES_BONUS;  // Bonus for other stores
            }
        }

        return rowTotalBonus;
    }
}
