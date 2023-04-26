package JavaAdvanced.Classes.Exe.OpinionPoll;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> persons = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);
            persons.put(name, age);
        }
        persons.entrySet().stream().filter(entry -> entry.getValue() > 30).forEach(p -> System.out.println(p.getKey() + " - " + p.getValue()));
    }
}
