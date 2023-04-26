package JavaAdvanced.Exam.Oct2019;

import java.util.Scanner;

public class BookWorm {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        for (int row = 0; row < matrix.length; row++) {
            String data = scanner.nextLine();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = String.valueOf(data.charAt(col));
            }
            System.out.println();
        }
        int wormRow = -1;
        int wormCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("P")) {
                    wormRow = row;
                    wormCol = col;
                }
            }
        }
        String command = scanner.nextLine();
        String lastSymbol = "";
        while (!command.equals("end")) {
            int previousRow = wormRow;
            int previousCol = wormCol;
            matrix[wormRow][wormCol] = "-";

            switch (command) {
                case "up":
                    wormRow--;
                    break;
                case "down":
                    wormRow++;
                    break;
                case "left":
                    wormCol--;
                    break;
                case "right":
                    wormCol++;
                    break;

            }
            if (isValid(matrix, wormRow, wormCol) && !matrix[wormRow][wormCol].equals("-")) {
                lastSymbol = String.valueOf(matrix[wormRow][wormCol]);
                input += lastSymbol;
            } else if (!isValid(matrix, wormRow, wormCol)) {
                input = input.substring(0, input.length() - 1);
                wormRow = previousRow;
                wormCol = previousCol;
            }

            matrix[wormRow][wormCol] = "P";
            command = scanner.nextLine();
        }
        System.out.println(input);
        print(matrix);
    }

    public static boolean isValid(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
    public static void print(String[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
