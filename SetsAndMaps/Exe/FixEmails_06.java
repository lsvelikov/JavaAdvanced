package JavaAdvanced.SetsAndMaps.Exe;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> emails = new LinkedHashMap<>();
        while (!input.equals("stop")){
            String email = scanner.nextLine();

            if (!(email.endsWith("us") || email.endsWith("uk") || email.endsWith("com"))){
                emails.put(input, email);
            }
            input = scanner.nextLine();
        }
        emails.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
