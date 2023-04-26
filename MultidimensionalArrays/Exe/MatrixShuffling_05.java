package JavaAdvanced.MultidimensionalArrays.Exe;

import java.util.Scanner;

public class MatrixShuffling_05 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
           String[] numbers = scanner.nextLine().split("\\s+");
           matrix[row] = numbers;
        }
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] data = input.split("\\s+");
            if (data.length != 5){
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }
            String keyWord = data[0];
            int indexRow1 = Integer.parseInt(data[1]);
            int indexCol1 = Integer.parseInt(data[2]);
            int indexRow2 = Integer.parseInt(data[3]);
            int indexCol2 = Integer.parseInt(data[4]);

            if (keyWord.equals("swap") && isValid(data, indexRow1, rows) && isValid(data, indexCol1, cols) && isValid(data, indexRow2, rows) && isValid(data, indexCol2, cols)){
                String currentIndex = matrix[indexRow1][indexCol1];
                String indexToSwap = matrix[indexRow2][indexCol2];

                matrix[indexRow1][indexCol1] = String.valueOf(indexToSwap);
                matrix[indexRow2][indexCol2] = String.valueOf(currentIndex);
                readMatrix(matrix, rows, cols);
            } else {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
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
    public static boolean isValid(String[] data, int index, int length){
        return data.length == 5 && index >= 0 && index < length;
    }
}
