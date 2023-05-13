# is-latin-square
Check if a 2D matrix of numbers is a Latin Square


### Usage 
1. Download the latest jar file from https://github.com/pdMa2s/is-latin-square/releases/
2. Run:
```shell
java -jar islatinsquare-<version>.jar <reader> <size>
```
<version>: Fill with the version you downloaded

Arguments:
<reader>  Reader type, can be one of the following:
- random: generates a random square matrix
- static: uses a pre-defined square matrix
- input: reads the square matrix from standard input
<size>    Integer value specifying the size of the square matrix (must be >= 1)

Examples:
java IsLatinSquare random 5
java IsLatinSquare static 3
java IsLatinSquare input 4 < input_matrix.txt
