package pdma2s.islatinsquare.validator;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static pdma2s.islatinsquare.validator.utils.ValidatorUtils.isInRange;
import static pdma2s.islatinsquare.validator.utils.ValidatorUtils.isSquare;

@Component
public class RecursiveDividerValidator implements LatinSquareValidator{
    /**
     * Recursive implementation that subdivides the matrix into smaller squares and check if the elements are in range
     * and if there are no repetitions. Time complexity is O(n + n^2) -> O(n^2)
     *
     */

    @Override
    public boolean isLatinSquare(int[][] square) {
        if (!isSquare(square))
            return false;

        int n = square.length;
        return checkRepetition(square, n, 0, new HashSet<>(), new HashSet<>());
    }

    private boolean checkRepetition(int[][] square, int n, int diagonal, Set<Integer> rowElements, Set<Integer> columnElements) {
        if (diagonal == n)
            return true;

        for (int i = 0; i < n; i++) {
            int r = square[diagonal][i];
            int c = square[i][diagonal];
            if (!isInRange(n, r) || !isInRange(n, c) || rowElements.contains(r) || columnElements.contains(c))
                return false;
            rowElements.add(r);
            columnElements.add(c);
        }

        return checkRepetition(square, n, diagonal + 1, new HashSet<>(), new HashSet<>());
    }


}
