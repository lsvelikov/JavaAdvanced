package JavaAdvanced.Exam.Feb2020;

import java.util.Scanner;

public class ReVolt {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int commands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            String rowData = scanner.nextLine();
            matrix[row] = rowData.toCharArray();
        }
        int playerRow = -1;
        int playerCol = -1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 'f'){
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        boolean hasReachedFinal = false;
        for (int i = 1; i <= commands; i++) {
            String command = scanner.nextLine();
            switch (command){
                case "up":
                    matrix[playerRow][playerCol] = '-';
                    if (playerRow == 0){
                        playerRow = n - 1;
                    }else{
                        playerRow--;
                    }
                    if (matrix[playerRow][playerCol] == 'B'){
                        if(playerRow == 0){
                            playerRow = n - 1;
                        }else{
                            playerRow--;
                        }
                    }else if (matrix[playerRow][playerCol] == 'T'){
                        playerRow++;
                    }else if (matrix[playerRow][playerCol] == 'F'){
                        matrix[playerRow][playerCol] = 'f';
                        hasReachedFinal = true;
                    }
                    matrix[playerRow][playerCol] = 'f';
                    break;
                case "down":
                    matrix[playerRow][playerCol] = '-';
                    if (playerRow == n - 1){
                        playerRow = 0;
                    } else {
                        playerRow++;
                    }
                    if (matrix[playerRow][playerCol] == 'B'){
                        if (playerRow == n - 1){
                            playerRow = 0;
                        } else{
                            playerRow++;
                        }
                    }else if (matrix[playerRow][playerCol] == 'T'){
                        playerRow--;
                    }else if (matrix[playerRow][playerCol] == 'F'){
                        matrix[playerRow][playerCol] = 'f';
                        hasReachedFinal = true;
                    }
                    matrix[playerRow][playerCol] = 'f';
                    break;
                case "left":
                    matrix[playerRow][playerCol] = '-';
                    if (playerCol == 0 && playerRow == 0){
                        playerRow++;
                        playerCol = n - 1;
                    }else if (playerCol == 0 && playerRow == n - 1){
                        playerRow = 0;
                        playerCol = n - 1;
                    }else if(playerCol == 0){
                      playerRow++;
                      playerCol = n - 1;
                    } else{
                        playerCol--;
                    }
                    if (matrix[playerRow][playerCol] == 'B'){
                        if (playerRow == 0 && playerCol == 0){
                            playerRow++;
                            playerCol = n - 1;
                        }else if (playerRow == n - 1 && playerCol == 0){
                            playerRow = 0;
                            playerCol = n - 1;
                        }else if (playerCol == 0){
                          playerRow++;
                          playerCol = n - 1;
                        } else {
                            playerCol--;
                        }
                    }else if (matrix[playerRow][playerCol] == 'T'){
                        if (playerCol == n - 1){
                            playerRow--;
                            playerCol = 0;
                        }else {
                            playerCol++;
                        }
                    }else if(matrix[playerRow][playerCol] == 'F'){
                        matrix[playerRow][playerCol] = 'f';
                        hasReachedFinal = true;
                    }
                    matrix[playerRow][playerCol] = 'f';
                    break;
                case "right":
                    matrix[playerRow][playerCol] = '-';
                    if (playerCol == n - 1 && playerRow == n - 1){
                        playerRow = 0;
                        playerCol = 0;
                    } else if (playerCol == n - 1){
                        playerRow++;
                        playerCol = 0;
                    } else {
                        playerCol++;
                    }
                    if (matrix[playerRow][playerCol] == 'B'){
                        if (playerRow == n - 1 && playerCol == n - 1){
                            playerRow = 0;
                            playerCol = 0;
                        }else if (playerCol == n - 1){
                            playerRow++;
                            playerCol = 0;
                        }else {
                            playerCol++;
                        }
                    }else if (matrix[playerRow][playerCol] == 'T'){
                        if (playerCol == 0 && playerRow == 0){
                            playerRow = n - 1;
                            playerCol = n - 1;
                        }else if (playerCol == 0){
                            playerRow--;
                            playerCol = n - 1;
                        }else{
                            playerCol--;
                        }
                    }else if (matrix[playerRow][playerCol] == 'F'){
                        matrix[playerRow][playerCol] = 'f';
                        hasReachedFinal = true;
                    }
                    matrix[playerRow][playerCol] = 'f';
                    break;
            }
            if (hasReachedFinal){
                break;
            }
        }
        if (hasReachedFinal){
            System.out.println("Player won!");
        }else {
            System.out.println("Player lost!");
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
