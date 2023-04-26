package JavaAdvanced.Exam.Feb2020;

import java.util.*;
import java.util.stream.Collectors;

public class LootBox {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> firstLootBox = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Deque<Integer> firstDeque = new ArrayDeque<>();
        for (int i = 0; i < firstLootBox.size(); i++) {
            firstDeque.offer(firstLootBox.get(i));
        }
        List<Integer> secondLootBox = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Deque<Integer> secondDeque = new ArrayDeque<>();
        for (int i = 0; i < secondLootBox.size(); i++) {
            secondDeque.push(secondLootBox.get(i));
        }

        int sumClaimedItems = 0;
        while (!firstDeque.isEmpty() && !secondDeque.isEmpty()){
            int numberFirstDeque = firstDeque.peek();
            int numberSecondDeque = secondDeque.peek();
            if ((numberFirstDeque + numberSecondDeque) % 2 == 0){
                firstDeque.pop();
                secondDeque.poll();
                sumClaimedItems += numberFirstDeque + numberSecondDeque;
            }else{
                firstDeque.add(secondDeque.poll());
            }
            if (firstDeque.isEmpty()){
                System.out.println("First lootbox is empty");
            }else if (secondDeque.isEmpty()){
                System.out.println("Second lootbox is empty");
            }
        }
        if (sumClaimedItems >= 100){
            System.out.println("Your loot was epic! Value: " + sumClaimedItems);
        }else{
            System.out.println("Your loot was poor... Value: " + sumClaimedItems);
        }
    }
}
