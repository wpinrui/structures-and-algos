package problems;

import java.util.Arrays;

/**
 * Problem from LeetCode available here: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 */
public class CountNegativesSortedMatrix {
    /**
     * Given an m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
     * return the number of negative numbers in grid.
     *
     * @param grid Matrix sorted in non-increasing order both row-wise and column-wise
     * @return Number of negative numbers in the grid
     */
    public static int countNegatives(int[][] grid) {
        int mid = grid.length / 2;

    }

    public static int countNegativesHelper(int[][] grid, int rs, int re, int cs, int ce) {
        if (rs > re || ce < cs) {
            return 0;
        }
        if (grid.length == 1) {
            return countRowNegativesTrivial(Arrays.copyOfRange(grid[0], cs, ce));
        }
        int result = 0;
        // Binary search the middle row for a negative
        int[] rowCol = findMiddleNegative(grid, rs, re, cs, ce);
        // Increment the result based on the lower right rectangle
        result = result + (re - rowCol[0] + 1) * (ce - rowCol[1] + 1);
        // Recurse on the top right and lower left rectangles and return result
        return result
                + countNegativesHelper(grid, rs + rowCol[0] + 1, re, cs, ce + rowCol[1] + 1);
                + countNegativesHelper(grid, rs, rowCol[0] - 1, )
    }

    public static int countRowNegatives(int[] row) {
        if (row.length == 1) {
            return row[0] < 0 ? 0 : -1;
        }
        int mid = row[row.length / 2];
        if (mid > 0) { // recurse on the left
            return countRowNegatives(Arrays.copyOfRange(row, 0, mid));
        } else { // recurse on the right
            return mid + countRowNegatives(Arrays.copyOfRange(row, mid + 1, row.length));
        }
    }

    public static int countRowNegativesTrivial(int[] row) {
        int count = 0;
        for (int j : row) {
            if (j < 0) {
                count++;
            }
        }
        return count;
    }

    public static int[] findMiddleNegativeTrivial(int[][] grid) {

    }

    public static int[] findMiddleNegative(int[][] grid) {

    }
}

