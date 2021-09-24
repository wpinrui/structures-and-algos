package problems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static problems.CountNegativesSortedMatrix.countNegatives;
import org.junit.jupiter.api.Test;

public class CountNegativesSortedMatrixTest {
    @Test
    public void example1() {
        assertEquals(8, countNegatives(new int[][]{
                new int[]{4, 3, 2, -1},
                new int[]{3, 2, 1, -1},
                new int[]{1, 1, -1, -2},
                new int[]{-1, -1, -2, -3}
        }));
    }

    @Test
    public void example2() {
        assertEquals(0, countNegatives(new int[][]{
                new int[]{3, 2},
                new int[]{1, 0},
        }));
    }

    @Test
    public void example3() {
        assertEquals(3, countNegatives(new int[][]{
                new int[]{1, -1},
                new int[]{-1, -1},
        }));
    }

    @Test
    public void example4() {
        assertEquals(1, countNegatives(new int[][]{
                new int[]{-1},
        }));
    }
}
