package JavaAdvanced.FunctionalProgramming.Exe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty_10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayList::new));

        String command = scanner.nextLine();

        while (!command.equals("Party!")){
            Predicate<String> predicate;
            String condition = command.split("\\s+")[2];

            if (command.contains("StartsWith")){
                predicate = s -> s.startsWith(condition);
            }else if (command.contains("EndsWith")){
                predicate = s -> s.endsWith(condition);
            }else{
                predicate = s -> s.length() == Integer.parseInt(condition);
            }
            if (command.contains("Remove")){
                ArrayList<String> toRemove = new ArrayList<>();
                for (String guest : guests) {
                    if (predicate.test(guest)){
                        toRemove.add(guest);
                    }
                }
                guests.removeAll(toRemove);
            }else{
                ArrayList<String> toAdd = new ArrayList<>();
                for (String guest : guests) {
                    if (predicate.test(guest)){
                        toAdd.add(guest);
                    }
                }
                guests.addAll(toAdd);
            }

            command = scanner.nextLine();
        }
        if (guests.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else{
            System.out.println(guests.stream().sorted().collect(Collectors.toCollection(ArrayList::new)).toString().replaceAll("([\\[\\]])", "") + " are going to the party!");
        }
    }
}
