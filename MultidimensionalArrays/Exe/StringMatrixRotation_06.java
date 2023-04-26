package JavaAdvanced.MultidimensionalArrays.Exe;

import java.util.ArrayDeque;
import java.util.Scanner;

public class StringMatrixRotation_06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        int degrees = Integer.parseInt(input.substring(7, input.length() - 1));
        String command = scanner.nextLine();

        int count = 0;
        int maxLength = 0;

        ArrayDeque<String> queue = new ArrayDeque<>();
        while (!command.equals("END")) {
            int length = command.length();
            if (length > maxLength) {
                maxLength = length;
            }

            queue.offer(command);
            count++;
            command = scanner.nextLine();
        }
        if (count < 1 || count > 1000){
            return;
        }
        char[][] matrix = new char[count][maxLength];

        int[] degreesArray = new int[]{0, 90, 180, 270};
        if (degrees % 90 == 0) {
            int circles = degrees / 90;
            while (circles > 4) {
                int rest = circles % degreesArray.length;
                circles /= degreesArray.length;
                degrees = degreesArray[rest];
            }
            switch (degrees) {
                case 90:
                    fillMatrix90(matrix, count, maxLength, queue);
                    break;
                case 180:
                    fillMatrix180(matrix, count, maxLength, queue);
                    break;
                case 270:
                    filMatrix270(matrix, count, maxLength, queue);
                    break;
                case 0:
                    fillMatrix0(matrix, count, maxLength, queue);
                    break;
            }
        }
    }

    public static void fillMatrix90(char[][] matrix, int count, int maxLength, ArrayDeque<String> queue) {
        for (int col = count - 1; col >= 0; col--) {
            if (!queue.isEmpty()) {
                String data = queue.poll();
                for (int row = 0; row < maxLength; row++) {
                    if (row >= data.length()) {
                        matrix[col][row] = ' ';
                    } else {
                        matrix[col][row] = data.charAt(row);
                    }
                }
            }
        }
        for (int col = 0; col < maxLength; col++) {
            for (int row = 0; row < count; row++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void fillMatrix0(char[][] matrix, int count, int maxLength, ArrayDeque<String> queue) {
        for (int row = 0; row < count; row++) {
            if (!queue.isEmpty()) {
                String data = queue.poll();
                for (int col = 0; col < maxLength; col++) {
                    if (col > data.length() - 1) {
                        matrix[row][col] = ' ';
                    } else {
                        matrix[row][col] = data.charAt(col);
                    }
                }
            }
        }
        for (char[] x : matrix) {
            for (char y : x) {
                System.out.print(y);
            }
            System.out.println();
        }
    }

    public static void fillMatrix180(char[][] matrix, int count, int maxLength, ArrayDeque<String> queue) {
        for (int row = count - 1; row >= 0; row--) {
            if (!queue.isEmpty()) {
                String data = queue.poll();
                for (int col = maxLength - 1; col >= 0; col--) {
                    if (col > data.length() - 1) {
                        matrix[row][col] = ' ';
                    } else {
                        matrix[row][col] = data.charAt(col);
                    }
                }
            }
        }
        for (int row = 0; row < count; row++) {
            for (int col = maxLength - 1; col >= 0; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void filMatrix270(char[][] matrix, int count, int maxLength, ArrayDeque<String> queue) {
        for (int col = 0; col < count; col++) {
            if (!queue.isEmpty()) {
                String data = queue.poll();
                int counter = 0;
                for (int row = maxLength - 1; row >= 0; row--) {
                    if (row < maxLength - data.length()) {
                        matrix[col][row] = ' ';
                    } else {
                        matrix[col][row] = data.charAt(counter);
                        counter++;
                    }
                }
            }
        }
        for (int col = 0; col < maxLength; col++) {
            for (int row = 0; row < count; row++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
