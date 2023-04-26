package JavaAdvanced.FunctionalProgramming.Exe;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames_06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> correctNames = name -> name.length() <= number;
        Arrays.stream(names).filter(correctNames).forEach(System.out::println);
    }
}
