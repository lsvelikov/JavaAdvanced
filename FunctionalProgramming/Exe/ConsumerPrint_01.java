package JavaAdvanced.FunctionalProgramming.Exe;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint_01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Consumer<String> names = n -> System.out.println(n);

        for (String name : input) {
            names.accept(name);
        }
    }
}
