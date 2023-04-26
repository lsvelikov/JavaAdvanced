package JavaAdvanced.MultidimensionalArrays.Exe;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        fillMatrix(scanner, matrix, size);
        int firstSum = getPrimaryDiagonalSum(matrix, size);
        int secondSum = getSecondaryDiagonalSum(matrix, size);

        System.out.println(Math.abs(firstSum - secondSum));

    }
    public static void fillMatrix(Scanner scanner, int[][] matrix, int size){
        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
    public static int getPrimaryDiagonalSum(int[][] matrix, int size){
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    public static int getSecondaryDiagonalSum(int[][] matrix, int size){
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += matrix[i][size - 1 - i];
        }
        return sum;
    }
}


