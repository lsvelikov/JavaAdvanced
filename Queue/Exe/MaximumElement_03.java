package JavaAdvanced.Queue.Stacks.Exe;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement_03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            int command = Integer.parseInt(input.split("\\s+")[0]);

            switch (command){
                case 1:
                    int numberToAdd = Integer.parseInt(input.split("\\s+")[1]);
                    numbers.push(numberToAdd);
                    break;
                case 2:
                    numbers.pop();
                    break;
                case 3:
                    System.out.println(Collections.max(numbers));
                    break;
            }
        }
    }
}
