package pdma2s.islatinsquare.validator.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pdma2s.islatinsquare.validator.utils.ValidatorUtils.isInRange;
import static pdma2s.islatinsquare.validator.utils.ValidatorUtils.isSquare;

public class ValidatorUtilsTests {

    @Test
    void testNotSquare() {
        assertFalse(isSquare(new int[][] {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2 }
        }));

        assertFalse(isSquare(new int[][] {
                {1, 2, 3},
                {1, 2, 3},
        }));

        assertFalse(isSquare(new int[][] {
                {1, 2},
                {1, 2, 3},
        }));

        assertFalse(isSquare(new int[][] {
                {},
        }));
    }


    @Test
    void testIsSquare() {
        assertTrue(isSquare(new int[][] {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        }));

        assertTrue(isSquare(new int[][] {
                {1, 2},
                {1, 2},
        }));

        assertTrue(isSquare(new int[][] {
                {1},
        }));
    }

    @Test
    void testInRange() {
        assertFalse(isInRange(3, 4));
        assertTrue(isInRange(2, 1));
    }

}
