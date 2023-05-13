package pdma2s.islatinsquare.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class StdInReader implements MatrixReader{
    private Logger logger = LoggerFactory.getLogger(RandomReader.class);

    @Override
    public int[][] read(int size) {
        int[][] matrix = new int[size][size];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
