package pdma2s.islatinsquare.validator;

import static pdma2s.islatinsquare.validator.utils.ValidatorUtils.isInRange;
import static pdma2s.islatinsquare.validator.utils.ValidatorUtils.isSquare;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CrossValidator implements LatinSquareValidator{
    /**
     *  This validator goes through the diagonal of the square matrix checking for duplicates in the elements of each
     *  overlapping column and row in a cross like manner. Time complexity is O(n + n^2) -> O(n^)
     *
     */

    @Override
    public boolean isLatinSquare(int[][] square) {
        if (!isSquare(square))
            return false;
        
        int n = square.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> rowElements = new HashSet<>(n);
            Set<Integer> columnElements = new HashSet<>(n);

            for (int j = 0; j < n; j++) {
                int r = square[i][j];
                int c = square[j][i];
                if (!isInRange(n, r) || !isInRange(n, c) || rowElements.contains(r) || columnElements.contains(c))
                    return false;

                rowElements.add(r);
                columnElements.add(c);
            }
        }
        return true;
    }
}