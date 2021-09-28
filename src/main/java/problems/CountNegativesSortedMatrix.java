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
        return 0;
    }

    public static int findRowWithNegatives(int[][] grid) {
        if (grid.length == 1) {
            return countRowNegatives(grid[0]) == -1 ? -1 : 0;
        }
        int mid = grid.length / 2;
        int numOfNegatives = countRowNegatives(grid[mid]);
        if (numOfNegatives == 0) { // the first row with a negative must be further down
            return mid + findRowWithNegatives(Arrays.copyOfRange(grid, mid + 1, grid.length));
        } else { // we've already found
            int attempt = findRowWithNegatives(Arrays.copyOfRange(grid, 0, mid + 1));
            return attempt == -1 ? mid : attempt;
        }
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
}

