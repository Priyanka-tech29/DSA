
//Problem 1: Maximum Cost in Traversing a 2-D Matrix (Same as Min Cost Path DP Problem)

/* We use dynamic programming to find the maximum cost in traversing a 2-D matrix from the top-left corner (0, 0) to the bottom-right corner (m-1, n-1).

The dp array is used to store the maximum cost at each cell. dp[i][j] represents the maximum cost to reach cell (i, j).

We iterate through the matrix row by row and calculate the maximum cost for each cell based on the maximum cost of the adjacent cells (above and to the left).

Finally, the maximum cost will be in dp[m][n], where m is the number of rows, and n is the number of columns.*/

package com.cts.dsa.paytm;

public class MaxCostPath {
	
    public static int maxCost(int[][] matrix, int m, int n) {
        // Create a DP table to store the maximum cost at each cell
        int[][] dp = new int[m + 1][n + 1];

        // Fill in the DP table from top-left to bottom-right
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Calculate the maximum cost for the current cell
                dp[i][j] = matrix[i - 1][j - 1] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // The maximum cost will be stored in the bottom-right cell
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
        int m = 3; // Number of rows
        int n = 3; // Number of columns

        int result = maxCost(matrix, m, n);
        System.out.println("Maximum cost: " + result);
    }
}

