package JavaAdvanced.MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix_05 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        int indexForRow = Integer.MIN_VALUE;
        int indexForCol = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sum > maxSum){
                    maxSum = sum;
                    indexForRow = row;
                    indexForCol = col;
                }
            }
        }
        System.out.print(matrix[indexForRow][indexForCol] + " " + matrix[indexForRow][indexForCol + 1]);
        System.out.println();
        System.out.print(matrix[indexForRow + 1][indexForCol] + " " + matrix[indexForRow + 1][indexForCol + 1]);
        System.out.println();
        System.out.println(maxSum);
    }
}
