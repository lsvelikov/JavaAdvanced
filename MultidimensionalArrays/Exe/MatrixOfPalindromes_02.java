package JavaAdvanced.MultidimensionalArrays.Exe;

import java.util.Scanner;

public class MatrixOfPalindromes_02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dataArray = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dataArray[0]);
        int cols = Integer.parseInt(dataArray[1]);

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, rows, cols);
        readMatrix(matrix, rows, cols);

    }
    public static void fillMatrix(String[][] matrix, int rows, int cols){
        char letter = 'a';
        for (int row = 0; row < rows; row++) {
            String letterToAdd = String.valueOf((char) (letter + row));
            for (int col = 0; col < cols; col++) {
                String middleSymbol = String.valueOf((char) (letter + col + row));
                String toAdd = letterToAdd + middleSymbol + letterToAdd;
                matrix[row][col] = toAdd;
            }
        }
    }
    public static void readMatrix(String[][] matrix, int rows, int cols){
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
