package JavaAdvanced.Exam.Dec2021;

import java.util.Scanner;

public class ThroneConquering {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int parisEnergy = Integer.parseInt(scanner.nextLine());
        int numberOfRows = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[numberOfRows][];
        for (int row = 0; row < numberOfRows; row++) {
            String dataRow = scanner.nextLine();
            matrix[row] = dataRow.toCharArray();
        }
        int parisRow = -1;
        int parisCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }
        boolean isSafe = false;
        while (parisEnergy > 0) {
            String[] commandData = scanner.nextLine().split("\\s+");
            String command = commandData[0];
            int spawnRow = Integer.parseInt(commandData[1]);
            int spawnCol = Integer.parseInt(commandData[2]);
            matrix[spawnRow][spawnCol] = 'S';
            matrix[parisRow][parisCol] = '-';

            switch (command) {
                case "up":
                    parisRow--;
                    parisEnergy--;
                    if (isValidMove(matrix, parisRow, parisCol)) {
                        if (matrix[parisRow][parisCol] == '-') {
                            matrix[parisRow][parisCol] = 'P';
                        } else if (matrix[parisRow][parisCol] == 'S') {
                            parisEnergy -= 2;
                            if (parisEnergy <= 0) {
                                matrix[parisRow][parisCol] = 'X';
                            } else {
                                matrix[parisRow][parisCol] = '-';
                            }
                        } else if (matrix[parisRow][parisCol] == 'H') {
                            matrix[parisRow][parisCol] = '-';
                            isSafe = true;
                        }
                    } else {
                        parisRow++;
                    }
                    break;
                case "down":
                    parisRow++;
                    parisEnergy--;
                    if (isValidMove(matrix, parisRow, parisCol)) {
                        if (matrix[parisRow][parisCol] == '-') {
                            matrix[parisRow][parisCol] = 'P';
                        } else if (matrix[parisRow][parisCol] == 'S') {
                            parisEnergy -= 2;
                            if (parisEnergy <= 0) {
                                matrix[parisRow][parisCol] = 'X';
                            } else {
                                matrix[parisRow][parisCol] = '-';
                            }
                        } else if (matrix[parisRow][parisCol] == 'H') {
                            matrix[parisRow][parisCol] = '-';
                            isSafe = true;
                        }
                    } else {
                        parisRow--;
                    }
                    break;
                case "left":
                    parisCol--;
                    parisEnergy--;
                    if (isValidMove(matrix, parisRow, parisCol)) {
                        if (matrix[parisRow][parisCol] == '-') {
                            matrix[parisRow][parisCol] = 'P';
                        } else if (matrix[parisRow][parisCol] == 'S') {
                            parisEnergy -= 2;
                            if (parisEnergy <= 0) {
                                matrix[parisRow][parisCol] = 'X';
                            } else {
                                matrix[parisRow][parisCol] = '-';
                            }
                        } else if (matrix[parisRow][parisCol] == 'H') {
                            matrix[parisRow][parisCol] = '-';
                            isSafe = true;
                        }
                    } else {
                        parisCol++;
                    }
                    break;
                case "right":
                    parisCol++;
                    parisEnergy--;
                    if (isValidMove(matrix, parisRow, parisCol)) {
                        if (matrix[parisRow][parisCol] == '-') {
                            matrix[parisRow][parisCol] = 'P';
                        } else if (matrix[parisRow][parisCol] == 'S') {
                            parisEnergy -= 2;
                            if (parisEnergy <= 0) {
                                matrix[parisRow][parisCol] = 'X';
                            } else {
                                matrix[parisRow][parisCol] = '-';
                            }
                        } else if (matrix[parisRow][parisCol] == 'H') {
                            matrix[parisRow][parisCol] = '-';
                            isSafe = true;
                        }
                    } else {
                        parisCol--;
                    }
                    break;
            }
            if (isSafe) {
                break;
            }
        }
        if (isSafe) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", parisEnergy);
        } else {
            matrix[parisRow][parisCol] = 'X';
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        }
        printMatrix(matrix);
    }

    public static boolean isValidMove(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
