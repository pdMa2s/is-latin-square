package pdma2s.islatinsquare.validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(args = {"random", "3"})
public class CrossValidatorTests {

    @Autowired
    private CrossValidator crossValidator;

    @Test
    public void testSizeOneMatrix() {
        assertTrue(crossValidator.isLatinSquare(new int[][]{
                {1}
        }));
        assertFalse(crossValidator.isLatinSquare(new int[][]{
                {2}
        }));
    }

    @Test
    public void testNotSquareMatrix() {
        assertFalse(crossValidator.isLatinSquare(new int[][]{
                {1, 2}
        }));

        assertFalse(crossValidator.isLatinSquare(new int[][]{
                {1, 2},
                {1, 2, 3}
        }));

        assertFalse(crossValidator.isLatinSquare(new int[][]{
                {1, 2, 3},
                {3, 1},
                {2, 3, 1}
        }));
    }


    @Test
    public void testSquares() {

        assertTrue(crossValidator.isLatinSquare(new int[][]{
                {1, 2},
                {2, 1}
        }));

        assertTrue(crossValidator.isLatinSquare(new int[][]{
                {1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}
        }));

        assertFalse(crossValidator.isLatinSquare(new int[][]{
                {1, 2, 3},
                {0, 1, 2},
                {2, 3, 1}
        }));

        assertFalse(crossValidator.isLatinSquare(new int[][]{
                {1, 1, 3},
                {3, 1, 2},
                {2, 3, 1}
        }));
    }

}
