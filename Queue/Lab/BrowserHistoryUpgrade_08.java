package JavaAdvanced.Queue.Stacks.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> backwardHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();


        while (!input.equals("Home")){
            if (input.equals("back")){
                if (backwardHistory.size() > 1){
                    forwardHistory.addFirst(backwardHistory.pop());
                    System.out.println(backwardHistory.peek());
                }else {
                    System.out.println("no previous URLs");
                }

            }else if (input.equals("forward")){
                if (forwardHistory.isEmpty()){
                    System.out.println("no next URLs");
                }else{
                    System.out.println(forwardHistory.peek());
                    backwardHistory.push(forwardHistory.poll());
                }
            } else {
                backwardHistory.push(input);
                forwardHistory.clear();
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}
