/**
 * Binary search takes in a sorted array and searches for a given key. Its runtime is O(log n) as it can halve
 * the problem size every iteration.
 */
public class BinarySearch {
    private final int[] sortedArr;
    private final int start;
    private final int end;

    /**
     * Constructor for a BinarySearch object. The argument must be a sorted array.
     *
     * @param sortedArr Array of integers in ascending order
     */
    public BinarySearch(int[] sortedArr) {
        this.sortedArr = sortedArr;
        start = 0;
        end = sortedArr.length - 1;
    }

    /**
     * Searches the array for the key using the Binary Search algorithm.
     *
     * @param key The element to look for
     * @return The index of the key if it is found, or -1
     */
    public int search(int key) {
        return searchHelper(key, start, end);
    }

    /**
     * Helper function for the binary search operation.
     *
     * @param key The element to look for
     * @param start The first array index to search
     * @param end The last array index to search
     * @return The index of the key if it is found, or -1
     */
    private int searchHelper(int key, int start, int end) {
        if (start >= end) {
            return key == sortedArr[start] ? start : -1;
        }
        int mid = getMiddle(start, end);

        if (key < sortedArr[mid]) {
            return searchHelper(key, start, mid - 1);
        }
        if (key > sortedArr[mid]) {
            return searchHelper(key, mid + 1, end);
        }
        return mid;
    }

    /**
     * Returns the floor of the midpoint of 2 numbers.
     * @param start One of the numbers
     * @param end The other numbers
     * @return The floor of the midpoint
     */
    private int getMiddle(int start, int end) {
        return (start + end) / 2;
    }
}
