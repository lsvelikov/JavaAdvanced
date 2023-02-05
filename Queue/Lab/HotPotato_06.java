package JavaAdvanced.Queue.Stacks.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato_06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int numberOfTurns = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> kids = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            kids.offer(input[i]);
        }
        while (kids.size() > 1){
            for (int i = 1; i < numberOfTurns; i++) {
                String currentKid = kids.poll();
                kids.offer(currentKid);
            }
            System.out.println("Removed " + kids.poll());
        }
        System.out.println("Last is " + kids.peek());
    }
}
