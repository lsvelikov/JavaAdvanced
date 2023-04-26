package JavaAdvanced.Exam.Oct2021;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> ingredients = new ArrayDeque<>();
        String[] ingredientsData = scanner.nextLine().split("\\s+");
        for (int i = 0; i < ingredientsData.length; i++) {
            ingredients.offer(Integer.parseInt(ingredientsData[i]));
        }

        Deque<Integer> freshness = new ArrayDeque<>();
        String[] data = scanner.nextLine().split("\\s+");
        for (int i = 0; i < data.length; i++) {
            freshness.push(Integer.parseInt(data[i]));
        }
        int pearSourCounter = 0;
        int harvestCounter = 0;
        int appleCounter = 0;
        int fashionCounter = 0;
        String currentCocktail = "";
        Map<String, Integer> cocktailMap = new TreeMap<>();
        boolean isPartyTime = false;
        while (!ingredients.isEmpty() && !freshness.isEmpty()){
            int currentIngredient = ingredients.poll();
            if (currentIngredient == 0){
                continue;
            }
            int currentFreshness = freshness.pop();
            int result = currentIngredient * currentFreshness;

            switch (result){
                case 150:
                    currentCocktail = "Pear Sour";
                    pearSourCounter++;
                    break;
                case 250:
                    currentCocktail = "The Harvest";
                    harvestCounter++;
                    break;
                case 300:
                    currentCocktail = "Apple Hinny";
                    appleCounter++;
                    break;
                case 400:
                    currentCocktail = "High Fashion";
                    fashionCounter++;
                    break;
                default:
                    currentIngredient += 5;
                    ingredients.offer(currentIngredient);
                    continue;
            }
            cocktailMap.putIfAbsent(currentCocktail, 0);
            cocktailMap.put(currentCocktail, cocktailMap.get(currentCocktail) + 1);
            if (pearSourCounter >= 1 && harvestCounter >= 1 && appleCounter >= 1 && fashionCounter >= 1){
                isPartyTime = true;
            }
        }
        if (isPartyTime){
            System.out.println("It's party time! The cocktails are ready!");
        }else{
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        int sumIngredientsLeft = 0;
        for (Integer ingredient : ingredients) {
            sumIngredientsLeft += ingredient;
        }
        if (sumIngredientsLeft != 0) {
            System.out.println("Ingredients left: " + sumIngredientsLeft);
        }
        cocktailMap.entrySet().forEach(e -> System.out.println("# " + e.getKey() + " --> " + e.getValue()));
    }
}
