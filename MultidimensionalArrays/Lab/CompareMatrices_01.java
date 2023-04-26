package JavaAdvanced.MultidimensionalArrays.Lab;

import java.util.Scanner;

public class CompareMatrices_01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] firstData = scanner.nextLine().split("\\s+");
        int firstRows = Integer.parseInt(firstData[0]);
        int firstCols = Integer.parseInt(firstData[1]);

        int[][] firstMatrix = new int[firstRows][firstCols];

        for (int row = 0; row < firstRows; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int col = 0; col < firstCols; col++) {
                firstMatrix[row][col] = Integer.parseInt(data[col]);
            }
        }
        String[] secondData = scanner.nextLine().split("\\s+");
        int secondRows = Integer.parseInt(secondData[0]);
        int secondCols = Integer.parseInt(secondData[1]);

        if (firstRows != secondRows || firstCols != secondCols){
            System.out.println("not equal");
            return;
        }
        int[][] secondMatrix = new int[secondRows][secondCols];
        for (int row = 0; row < secondRows; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int col = 0; col < secondCols; col++) {
                secondMatrix[row][col] = Integer.parseInt(data[col]);
            }
        }
        for (int row = 0; row < firstRows; row++) {
            for (int col = 0; col < secondCols; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]){
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
    }
}
