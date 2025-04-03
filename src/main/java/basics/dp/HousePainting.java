package basics.dp;

import basics.util.CodeUtil;

public class HousePainting {

    public static void main(String[] args) {
        // Sample input: 2 houses, 3 colors
        int[][] costs = {
                {1, 5, 3}
        };

        // Function call
        int minCost = minCostToPaintHouses(costs);
        System.out.println("Minimum Cost to Paint Houses: " + minCost); // Output: 5
    }

    /**
     * Function to compute minimum cost to paint all houses with k colors
     *
     * @param costs 2D array where costs[i][j] is the cost of painting house i with color j
     * @return minimum total cost
     *
     * 1 | 5 | 3 |
     * 5 | 10 | 5 |
     * 8 | 9 | 10 |
     *
     **/
    public static int minCostToPaintHouses(int[][] costs) {
        // Edge case: if costs is empty
        if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;

        int numOfHouses = costs.length;    // Number of houses
        int colorCount = costs[0].length; // Number of colors

        // Edge case: If only one color and more than one house, not possible
        if (colorCount == 1 && numOfHouses > 1) return -1;

        // DP table to store minimum costs
        int[][] matrix = new int[numOfHouses][colorCount];

        // Initialize first row of dp with first row of costs
        for (int color = 0; color < colorCount; color++) {
            matrix[0][color] = costs[0][color];
        }

        // Fill dp table
        for (int house = 1; house < numOfHouses; house++) { // For each house
            for (int color = 0; color < colorCount; color++) { // For each color
                matrix[house][color] = costs[house][color] + findMinFromPreviousRow(matrix[house - 1], color); // Add cost and minimum of previous row except same color
            }
        }

        CodeUtil.display2dMatrix(matrix);

        // Find minimum in last row (last house)
        int minCost = Integer.MAX_VALUE;
        for (int color = 0; color < colorCount; color++) {
            minCost = Math.min(minCost, matrix[numOfHouses - 1][color]);
        }

        return minCost;
    }

    /**
     * Helper function to find minimum value in previous row excluding current color
     *
     * @param prevRow      array of previous row costs
     * @param excludeColor index to exclude
     * @return minimum cost excluding excludeColor
     */
    private static int findMinFromPreviousRow(int[] prevRow, int excludeColor) {
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < prevRow.length; j++) {
            if (j != excludeColor) { // Exclude same color as current
                min = Math.min(min, prevRow[j]);
            }
        }
        return min;
    }
}

