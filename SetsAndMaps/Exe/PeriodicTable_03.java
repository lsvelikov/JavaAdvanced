package JavaAdvanced.SetsAndMaps.Exe;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalElements = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            chemicalElements.addAll(Arrays.asList(data));
        }
        for (String element : chemicalElements) {
            System.out.print(element + " ");
        }
    }
}
