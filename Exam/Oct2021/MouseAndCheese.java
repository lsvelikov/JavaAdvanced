package JavaAdvanced.Exam.Oct2021;

import java.util.Scanner;

public class MouseAndCheese {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];

        for (int row = 0; row < matrix.length; row++) {
            String[] data = scanner.nextLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = data[col];
            }
        }
        int mouseRow = -1;
        int mouseCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("M")){
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }
        String command = scanner.nextLine();

        int cheeseCount = 0;
        boolean isMouseOut = false;
        while (!command.equals("end")){

            matrix[mouseRow][mouseCol] = "-";
            switch (command){
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;
                    break;
            }
            if (!isOut(mouseRow, mouseCol, matrix)){

                if (matrix[mouseRow][mouseCol].equals("B")){
                    matrix[mouseRow][mouseCol] = "-";
                    if (command.equals("up")){
                        mouseRow--;
                    }else if (command.equals("down")){
                        mouseRow++;
                    }else if (command.equals("left")){
                        mouseCol--;
                    }else if (command.equals("right")){
                        mouseCol++;
                    }
                }
                if (matrix[mouseRow][mouseCol].equals("c")){
                    matrix[mouseRow][mouseCol] = "M";
                    cheeseCount++;
                }
            }else{
                isMouseOut = true;
                break;
            }

            matrix[mouseRow][mouseCol] = "M";
            command = scanner.nextLine();
        }
        if (isMouseOut){
            System.out.println("Where is the mouse?");
        }
        System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseCount);
        printMatrix(matrix);
    }
    public static boolean isOut(int row, int col, String[][]matrix){
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
    public static void printMatrix(String[][]matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
