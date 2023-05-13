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
@Qualifier("static")
public class StaticReader implements MatrixReader{

    private Logger logger = LoggerFactory.getLogger(StaticReader.class);

    @Override
    public int[][] read(int size) {
        switch (size) {
            case 1 -> {
                return new int[][] {
                    {2}
                };
            }

            case 2 -> {
                return new int[][]{
                    {1, 2},
                    {2, 1}
                };
            }
            case 4 -> {
                return new int[][]{
                    {1, 2, 3, 4},
                    {2, 3, 4, 1},
                    {3, 4, 1, 2},
                    {4, 1, 2, 3}
                };
            }
            default -> {
                this.logger.debug("Defaulting to size 3");
                return new int[][]{
                    {1, 2, 3},
                    {3, 1, 2},
                    {2, 3, 2}
                };
            }
        }

    }
}
