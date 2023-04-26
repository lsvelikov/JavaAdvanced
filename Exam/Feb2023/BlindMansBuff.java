package JavaAdvanced.Exam.Feb2023;

import java.util.Scanner;

public class BlindMansBuff {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] text = scanner.nextLine().split("\\s+");
            matrix[row] = text;
        }
        int mainPlayerRow = -1;
        int mainPlayerCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")){
                    mainPlayerRow = row;
                    mainPlayerCol = col;
                }
            }
        }
        String command = scanner.nextLine();
        int touchCounter = 0;
        int movesCounter = 0;
        while (!command.equals("Finish")){

            matrix[mainPlayerRow][mainPlayerCol] = "-";
            switch (command){
                case "up":
                    mainPlayerRow--;
                    if (isValid(matrix, mainPlayerRow, mainPlayerCol) && matrix[mainPlayerRow][mainPlayerCol].equals("-")){
                        matrix[mainPlayerRow][mainPlayerCol] = "B";
                        movesCounter++;
                    }else if (isValid(matrix, mainPlayerRow, mainPlayerCol) && matrix[mainPlayerRow][mainPlayerCol].equals("P")){
                        matrix[mainPlayerRow][mainPlayerCol] = "B";
                        movesCounter++;
                        touchCounter++;
                    }else{
                        mainPlayerRow++;
                    }
                    break;
                case "down":
                    mainPlayerRow++;
                    if (isValid(matrix, mainPlayerRow, mainPlayerCol) && matrix[mainPlayerRow][mainPlayerCol].equals("-")){
                        matrix[mainPlayerRow][mainPlayerCol] = "B";
                        movesCounter++;
                    }else if (isValid(matrix, mainPlayerRow, mainPlayerCol) && matrix[mainPlayerRow][mainPlayerCol].equals("P")){
                        matrix[mainPlayerRow][mainPlayerCol] = "B";
                        movesCounter++;
                        touchCounter++;
                    }else{
                        mainPlayerRow--;
                    }
                    break;
                case "left":
                    mainPlayerCol--;
                    if (isValid(matrix, mainPlayerRow, mainPlayerCol) && matrix[mainPlayerRow][mainPlayerCol].equals("-")){
                        matrix[mainPlayerRow][mainPlayerCol] = "B";
                        movesCounter++;
                    }else if (isValid(matrix, mainPlayerRow, mainPlayerCol) && matrix[mainPlayerRow][mainPlayerCol].equals("P")){
                        matrix[mainPlayerRow][mainPlayerCol] = "B";
                        movesCounter++;
                        touchCounter++;
                    }else{
                        mainPlayerCol++;
                    }
                    break;
                case "right":
                    mainPlayerCol++;
                    if (isValid(matrix, mainPlayerRow, mainPlayerCol) && matrix[mainPlayerRow][mainPlayerCol].equals("-")){
                        matrix[mainPlayerRow][mainPlayerCol] = "B";
                        movesCounter++;
                    }else if (isValid(matrix, mainPlayerRow, mainPlayerCol) && matrix[mainPlayerRow][mainPlayerCol].equals("P")){
                        matrix[mainPlayerRow][mainPlayerCol] = "B";
                        movesCounter++;
                        touchCounter++;
                    }else{
                        mainPlayerCol--;
                    }
                    break;
            }
            if (touchCounter >= 3){
                break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touchCounter, movesCounter);
    }
    public static boolean isValid(String[][]matrix, int row, int col){
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
