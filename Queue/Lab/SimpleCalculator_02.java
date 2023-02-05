package JavaAdvanced.Queue.Stacks.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator_02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String>tokens = new ArrayDeque<>();
        Collections.addAll(tokens, input);

        while (tokens.size() > 1){
            int first = Integer.parseInt(tokens.pop());
            String operator = tokens.pop();
            int second = Integer.parseInt(tokens.pop());
            int result = 0;
            if (operator.equals("+")){
                result = first + second;
            }else if (operator.equals("-")){
                result = first - second;
            }
            tokens.push(String.valueOf(result));
        }
        System.out.println(tokens.peek());
    }
}
