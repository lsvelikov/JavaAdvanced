package JavaAdvanced.SetsAndMaps.Exe;

import java.util.*;

public class HandsOfCards_07 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> valueMap = new LinkedHashMap<>();
        while (!input.equals("JOKER")) {
            String[] data = input.split(": ");
            String name = data[0];
            String[] cards = data[1].split(", ");
            Set<String> cardSet = new LinkedHashSet<>();
            cardSet.addAll(Arrays.asList(cards));

            if (!valueMap.containsKey(name)){
                valueMap.put(name, cardSet);
            }else {
                Set<String> currentCards = valueMap.get(name);
                currentCards.addAll(cardSet);
                valueMap.put(name, currentCards);
            }

            input = scanner.nextLine();
        }
        valueMap.entrySet().forEach(entry -> {
            String name = entry.getKey();
            Set<String>cards = entry.getValue();
            int points = getPoints(cards);
            System.out.printf("%s: %d%n", name, points);
        });
    }
    public static int getPoints(Set<String>cards){
        Map<Character, Integer> values = getSymbolsValues();
        int sumPoints = 0;

        for (String card : cards) {
            int points = 0;

            if (card.startsWith("10")){
                char type = card.charAt(2);
                points = 10 * values.get(type);
            }else{
                char power = card.charAt(0);
                char type = card.charAt(1);
                points = values.get(power) * values.get(type);
            }
            sumPoints += points;
        }
        return sumPoints;
    }

    public static Map<Character, Integer> getSymbolsValues() {
        Map<Character, Integer> characterValues = new HashMap<>();
        characterValues.put('2', 2);
        characterValues.put('3', 3);
        characterValues.put('4', 4);
        characterValues.put('5', 5);
        characterValues.put('6', 6);
        characterValues.put('7', 7);
        characterValues.put('8', 8);
        characterValues.put('9', 9);
        characterValues.put('J', 11);
        characterValues.put('Q', 12);
        characterValues.put('K', 13);
        characterValues.put('A', 14);
        characterValues.put('S', 4);
        characterValues.put('H', 3);
        characterValues.put('D', 2);
        characterValues.put('C', 1);
        return characterValues;
    }
}
