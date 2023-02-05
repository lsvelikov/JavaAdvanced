package JavaAdvanced.Queue.Stacks.Exe;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations_02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            stack.push(scanner.nextInt());
        }
        for (int i = 1; i <= s; i++) {
            stack.pop();
        }
        if (stack.contains(x)){
            System.out.println("true");
        }else if (stack.isEmpty()){
            System.out.println("0");
        }else {
            System.out.println(Collections.min(stack));
        }
    }
}
