package pdma2s.islatinsquare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pdma2s.islatinsquare.reader.MatrixReader;
import pdma2s.islatinsquare.reader.MatrixReaderFactory;
import pdma2s.islatinsquare.validator.LatinSquareValidator;

@SpringBootApplication
public class IsLatinSquareApplication implements CommandLineRunner {

//	@Autowired
//	@Qualifier("static")
	private MatrixReader matrixReader;

//	@Value("${square.size}")
	private int size;

	@Autowired
	private LatinSquareValidator latinSquareValidator;

	public static void main(String[] args) {
		SpringApplication.run(IsLatinSquareApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length != 2 || !validateArguments(args[0], Integer.parseInt(args[1]))){
			printUsageGuide();
			System.exit(0);
		}

		String readerInput = args[0];
		size = Integer.parseInt(args[1]);

		matrixReader = MatrixReaderFactory.build(readerInput);

		int[][] matrix = matrixReader.read(size);
		printMatrix(matrix);
		if (latinSquareValidator.isLatinSquare(matrix))
			System.out.println("This is a Latin!!!");
		else
			System.out.println("Not a Latin");
	}

	public static void printMatrix(int[][] matrix) {
		StringBuilder sb = new StringBuilder();
		for (int[] row : matrix) {
			for (int element : row) {
				sb.append(element).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static boolean validateArguments(String reader, int size) {
		boolean isValid = true;

		if (!reader.equals("random") && !reader.equals("static") && !reader.equals("input")) {
			System.out.println("Invalid reader argument. The reader must be either \"random\", \"static\", or \"input\".");
			isValid = false;
		}

		if (size < 1) {
			System.out.println("Invalid size argument. The size must be an integer greater than or equal to 1.");
			isValid = false;
		}

		return isValid;
	}

	public static void printUsageGuide() {
		System.out.println("Usage: java IsLatinSquare <reader> <size>");
		System.out.println();
		System.out.println("Arguments:");
		System.out.println("  <reader>  Reader type, can be one of the following:");
		System.out.println("              - random: generates a random square matrix");
		System.out.println("              - static: uses a pre-defined square matrix");
		System.out.println("              - input: reads the square matrix from standard input");
		System.out.println("  <size>    Integer value specifying the size of the square matrix (must be >= 1)");
		System.out.println();
		System.out.println("Examples:");
		System.out.println("  java IsLatinSquare random 5");
		System.out.println("  java IsLatinSquare static 3");
		System.out.println("  java IsLatinSquare input 4 < input_matrix.txt");
	}

}
