package pdma2s.islatinsquare.validator.utils;

public class ValidatorUtils {
    public static boolean isSquare(int[][] matrix) {
        int dimension = matrix.length;
        if (dimension == 0)
            return false;

        for (int[] row : matrix) {
            if (row.length != dimension)
                return false;
        }
        return true;
    }

    public static boolean isInRange(int n, int x){
        return x >= 1 && x <= n;
    }

}
