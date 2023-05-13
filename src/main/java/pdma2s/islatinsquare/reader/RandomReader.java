package pdma2s.islatinsquare.reader;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
@Qualifier("random")
public class RandomReader implements MatrixReader{

    private Logger logger = LoggerFactory.getLogger(RandomReader.class);

    @Override
    public int[][] read(int size) {
        Random dice = new Random();
        double roll = dice.nextDouble();
        if (roll < 0.33) {
            this.logger.debug("Generate latin square");
            return generateLatinSquare(size);
        }

        if (roll < 0.66){
            this.logger.debug("Generate random square");
            return generateRandomSquare(size);
        }
        else {
            this.logger.debug("Generate non latin square");
            return generateNonLatinSquare(size);
        }

    }


    public int[][] generateLatinSquare(int size) {
        int[][] square = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                square[i][j] = (i + j) % size + 1;
            }
        }

        return square;
    }

    public int[][] generateNonLatinSquare(int size) {
        int[][] square = new int[size][size];
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                values.add((i * size + j) % size + 1);
            }

            Collections.shuffle(values);

            for (int j = 0; j < size; j++) {
                square[i][j] = values.get(j);
            }

            values.clear();
        }

        return square;
    }

    public int[][] generateRandomSquare(int size) {
        int[][] square = new int[size][size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (rand.nextDouble() < .90)
                    square[i][j] = rand.nextInt(size) + 1;
                else
                    square[i][j] = rand.nextInt(rand.nextInt());
            }
        }

        return square;
    }

}
