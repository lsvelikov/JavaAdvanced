package JavaAdvanced.Queue.Stacks.Lab;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato_07 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int numberOfTurns = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> kids = new PriorityQueue<>();

        for (String s : input) {
            kids.offer(s);
        }
        int count = 0;
        while (kids.size() > 1){
            for (int i = 1; i < numberOfTurns; i++) {
                String currentKid = kids.poll();
                kids.offer(currentKid);
            }
            count++;
            if (isPrime(count)){
                System.out.println("Prime " + kids.peek());
            } else {
                System.out.println("Removed " + kids.poll());
            }
        }
        System.out.println("Last is " + kids.poll());

    }
    public static boolean isPrime(int n){
        if (n <= 1){
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}