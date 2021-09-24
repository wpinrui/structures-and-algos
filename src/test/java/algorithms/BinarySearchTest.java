package algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import algorithms.BinarySearch;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    // return -1 if key is not found in array
    public void search_keyNotInArray_Trivial() {
        BinarySearch bs = new BinarySearch(new int[]{1});
        assertEquals(-1, bs.search(2));
    }

    @Test
    // return index if key is found in array
    public void search_keyInArray_Trivial() {
        BinarySearch bs = new BinarySearch(new int[]{1});
        assertEquals(0, bs.search(1));
    }

    @Test
    public void search_keyNotInArray_NonTrivial() {
        BinarySearch bs = new BinarySearch(new int[]{3, 6, 8, 19, 20, 26, 28, 33});
        assertEquals(-1, bs.search(2));
    }

    @Test
    public void search_keyInArray_NonTrivial() {
        BinarySearch bs = new BinarySearch(new int[]{3, 6, 8, 19, 20, 26, 28, 33});
        assertEquals(3, bs.search(19));
    }
}
