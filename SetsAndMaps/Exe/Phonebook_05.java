package JavaAdvanced.SetsAndMaps.Exe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phoneBook = new HashMap<>();
        while (!input.equals("search")){
            String[] data = input.split("-");
            String name = data[0];
            String number = data[1];

            phoneBook.put(name, number);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")){
            String name = input;

            if (phoneBook.containsKey(name)){
                System.out.println(name + " -> " + phoneBook.get(name));
            }else{
                System.out.println("Contact " + name + " does not exist.");
            }

            input = scanner.nextLine();
        }
    }
}
