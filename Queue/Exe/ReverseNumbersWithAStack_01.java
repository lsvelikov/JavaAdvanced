package JavaAdvanced.Queue.Stacks.Exe;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithAStack_01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> numbers = new ArrayDeque<>();

        for (String number : input) {
            numbers.push(number);
        }
        while (!numbers.isEmpty()){
            System.out.print(numbers.pop() + " ");
        }
    }
}
