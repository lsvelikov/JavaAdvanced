package JavaAdvanced.FunctionalProgramming.Exe;

import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor_02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        Consumer<String[]> printNames = array -> {
            for (String name : array) {
                System.out.println("Sir " + name);
            }
        };
        printNames.accept(names);
    }
}
