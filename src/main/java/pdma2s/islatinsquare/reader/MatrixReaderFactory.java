package pdma2s.islatinsquare.reader;

public class MatrixReaderFactory {
    public static MatrixReader build(String type) {
        switch (type) {
            case "static":
                return new StaticReader();
            case "random":
                return new RandomReader();
            case "input":
                return new StdInReader();
            default:
                throw new IllegalArgumentException("Invalid matrix reader type: " + type);
        }
    }
}
