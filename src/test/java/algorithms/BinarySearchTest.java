package algorithms;

import static algorithms.BinarySearch.search;
import static org.junit.jupiter.api.Assertions.assertEquals;
import algorithms.BinarySearch;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    // return -1 if key is not found in array
    public void search_keyNotInArray_Trivial() {
        assertEquals(-1, search(new int[]{1}, 2));
    }

    @Test
    // return index if key is found in array
    public void search_keyInArray_Trivial() {
        assertEquals(0, search(new int[]{1},1));
    }

    @Test
    public void search_keyNotInArray_NonTrivial() {
        assertEquals(-1, search(new int[]{3, 6, 8, 19, 20, 26, 28, 33}, 2));
    }

    @Test
    public void search_keyInArray_NonTrivial() {
        assertEquals(3, search(new int[]{3, 6, 8, 19, 20, 26, 28, 33}, 19));
    }
}
