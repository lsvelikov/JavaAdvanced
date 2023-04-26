package JavaAdvanced.MultidimensionalArrays.Exe;

import java.util.Scanner;

public class FillTheMatrix_01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String matrixType = input[1];
        int[][] matrix = new int[size][size];

        if (matrixType.equals("A")){
            fillMatrixA(matrix);
        }else if (matrixType.equals("B")){
            fillMatrixB(matrix);
        }
        readMatrix(matrix);
    }
    public static void fillMatrixA(int[][] matrix){
        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
    }
    public static void fillMatrixB(int[][] matrix){
        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }
    public static void readMatrix(int[][] matrix){
        for (int[] x : matrix) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
