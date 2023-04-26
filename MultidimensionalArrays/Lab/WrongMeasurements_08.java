package JavaAdvanced.MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements_08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[number][];

        int cols = 0;
        for (int row = 0; row < number; row++) {
            int[] numbersArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            cols = numbersArray.length;
            matrix[row] = numbersArray;
        }
        int[][] newMatrix = new int[number][cols];
        for (int row = 0; row < number; row++) {
            for (int col = 0; col < cols; col++) {
                newMatrix[row][col] = matrix[row][col];
            }
        }
        String[] data = scanner.nextLine().split("\\s+");
        int indexRow = Integer.parseInt(data[0]);
        int indexCol = Integer.parseInt(data[1]);
        int wrongNumber = matrix[indexRow][indexCol];

        for (int row = 0; row < number; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == wrongNumber) {
                    int correctNumber = getSum(matrix, row, col, wrongNumber);
                    newMatrix[row][col] = correctNumber;
                }
            }
        }
        for (int row = 0; row < number; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(newMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    private static int getSum(int[][] matrix, int row, int column, int invalidNumber) {
        int sum = 0;

        if (isValidIndex(row - 1, matrix.length)) {
            if (matrix[row - 1][column] != invalidNumber) {
                sum += matrix[row - 1][column];
            }
        }
        if (isValidIndex(row + 1, matrix.length)) {
            if (matrix[row + 1][column] != invalidNumber) {
                sum += matrix[row + 1][column];
            }
        }
        if (isValidIndex(column - 1, matrix[row].length)) {
            if (matrix[row][column - 1] != invalidNumber) {
                sum += matrix[row][column - 1];
            }
        }
        if (isValidIndex(column + 1, matrix[row].length)) {
            if (matrix[row][column + 1] != invalidNumber) {
                sum += matrix[row][column + 1];
            }
        }
        return sum;
    }

    private static boolean isValidIndex(int index, int length) {
        return (index >= 0 && index < length);
    }
}