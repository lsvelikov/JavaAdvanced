package JavaAdvanced.Exam.Oct2022;

import java.util.Scanner;

public class RallyRacing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        String[][] matrix = new String[n][n];
        for (int row = 0; row < matrix.length; row++) {
            String[] dataRow = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = dataRow[col];
            }
            System.out.println();
        }
        int carRow = 0;
        int carCol = 0;

        String command = scanner.nextLine();

        int distance = 0;
        boolean hasReachedFinal = false;
        while (!command.equals("End")){

            matrix[carRow][carCol] = ".";
            switch (command){
                case "left":
                    carCol--;
                    break;
                case "right":
                    carCol++;
                    break;
                case "up":
                    carRow--;
                    break;
                case "down":
                    carRow++;
                    break;
            }
            if (matrix[carRow][carCol].equals("T")){
                matrix[carRow][carCol] = ".";
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        if (matrix[row][col].equals("T")){
                            carRow = row;
                            carCol = col;
                            matrix[carRow][carCol] = "C";
                            distance += 30;
                        }
                    }
                }

            }else if (matrix[carRow][carCol].equals("F")){
                matrix[carRow][carCol] = "C";
                distance += 10;
                hasReachedFinal = true;
                break;
            }else{
                distance += 10;
            }
            matrix[carRow][carCol] = "C";

            command = scanner.nextLine();
        }
        if (hasReachedFinal){
            System.out.printf("Racing car %s finished the stage!%n", racingNumber);
        }else{
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }
        System.out.printf("Distance covered %d km.%n", distance);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
