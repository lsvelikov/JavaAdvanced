package JavaAdvanced.Queue.Stacks.Exe;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci_06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fibonacciNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> fibonacci = new ArrayDeque<>();
        System.out.println(fibonacci(fibonacci, fibonacciNumber));

    }
    public static long fibonacci(ArrayDeque<Long> fibonacci, int n){
        if (n < 2){
            return 1L;
        }else {
            fibonacci.offer(0L);
            fibonacci.offer(1L);
            for (int i = 0; i < n; i++) {
                long sum = fibonacci.poll() + fibonacci.peek();
                fibonacci.offer(sum);
            }
        }
        fibonacci.poll();
        return fibonacci.peek();
    }
}
