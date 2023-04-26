package JavaAdvanced.MultidimensionalArrays.Exe;

import java.util.*;

public class Crossfire_07 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        int count = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = count;
                count++;
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            replaceElementsByExplosion(matrix, input);
            matrix = getMatrixAfterExplosion(matrix);
            input = scanner.nextLine();
        }
        print(matrix);
    }

    private static int[][] getMatrixAfterExplosion(int[][] matrix) {
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();

        for (int r = 0; r < matrix.length; r++) {
            List<Integer> list = new ArrayList<>();

            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] != -1) {
                    list.add(matrix[r][c]);
                }
            }
            if (!list.isEmpty()) {
                map.put(r, list);
            }
        }
        matrix = new int[map.size()][];
        int startIndex = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            matrix[startIndex] = entry.getValue().stream().mapToInt(Integer::intValue).toArray();
            startIndex++;
        }
        return matrix;
    }

    private static void print(int[][] matrix) {

        for (int[] x : matrix) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    private static boolean AreIndexesValid(int row, int col, int[][] matrix) {
        return (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length);
    }

    private static void replaceElementsByExplosion(int[][] matrix, String input) {
        int rowIndex = Integer.parseInt(input.split("\\s+")[0]);
        int colIndex = Integer.parseInt(input.split("\\s+")[1]);
        int radius = Integer.parseInt(input.split("\\s+")[2]);

        for (int row = rowIndex - radius; row <= rowIndex + radius; row++) {
            if (AreIndexesValid(row, colIndex, matrix)) {
                matrix[row][colIndex] = -1;
            }
        }
        for (int col = colIndex - radius; col <= colIndex + radius; col++) {
            if (AreIndexesValid(rowIndex, col, matrix)) {
                matrix[rowIndex][col] = -1;
            }
        }
    }
}