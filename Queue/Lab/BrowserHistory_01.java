package JavaAdvanced.Queue.Stacks.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        String currentUrl = "";
        while (!input.equals("Home")){
            if (input.equals("back")){
                if (browserHistory.size() > 1){
                    browserHistory.pop();
                    currentUrl = browserHistory.peek();
                    System.out.println(currentUrl);
                }else {
                    System.out.println("no previous URLs");
                }

            }else {
                browserHistory.push(input);
                currentUrl = browserHistory.peek();
                System.out.println(currentUrl);
            }

            input = scanner.nextLine();
        }
    }
}
