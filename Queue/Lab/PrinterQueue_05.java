package JavaAdvanced.Queue.Stacks.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> files = new ArrayDeque<>();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (files.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + files.pollFirst());
                }
            } else {
                files.offer(input);
            }

            input = scanner.nextLine();
        }
        for (String file : files) {
            System.out.println(file);
        }
    }
}
