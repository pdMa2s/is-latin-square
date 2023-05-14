package pdma2s.islatinsquare;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pdma2s.islatinsquare.validator.LatinSquareValidator;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(args = {"random", "3"})

class IsLatinSquareApplicationTests {

	@Autowired
	LatinSquareValidator latinSquareValidator;

	@Test
	void contextLoads() {
		assertNotNull(latinSquareValidator);
	}

}
