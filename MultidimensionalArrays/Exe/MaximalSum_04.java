package JavaAdvanced.MultidimensionalArrays.Exe;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, matrix, rows);

        int maxSum = Integer.MIN_VALUE;
        int indexForRow = Integer.MIN_VALUE;
        int indexForCol = Integer.MIN_VALUE;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > maxSum) {
                    maxSum = sum;
                    indexForRow = row;
                    indexForCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        readMatrix(matrix, indexForRow , indexForCol);
    }

    public static void fillMatrix(Scanner scanner, int[][] matrix, int rows) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }


    public static void readMatrix(int[][] matrix, int startRow, int startCol) {
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
