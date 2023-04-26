package JavaAdvanced.MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[number][number];

        for (int row = 0; row < number; row++) {
            int[] numbersArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = numbersArr;
        }
        for (int row = 0; row < number; row++) {
            for (int col = 0; col < number; col++) {
                if (row == col){
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
        System.out.println();
        for (int row = number - 1; row >= 0 ; row--) {
            for (int col = 0; col < number; col++) {
                if (row == number - col - 1){
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
    }
}
