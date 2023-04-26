package JavaAdvanced.Exam.Feb2023;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ApocalypsePreparation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] textiles = scanner.nextLine().split("\\s");
        ArrayDeque<Integer> textilesQueue = new ArrayDeque<>();
        for (int i = 0; i < textiles.length; i++) {
            textilesQueue.offer(Integer.parseInt(textiles[i]));
        }
        String[] medicaments = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> medicamentsStack = new ArrayDeque<>();
        for (int i = 0; i < medicaments.length; i++) {
            medicamentsStack.push(Integer.parseInt(medicaments[i]));
        }
        Map<String, Integer> medicamentsMap = new TreeMap<>();
        while (!textilesQueue.isEmpty() && !medicamentsStack.isEmpty()) {
            int currentTextiles = textilesQueue.peek();
            int currentMedicament = medicamentsStack.peek();
            int result = currentTextiles + currentMedicament;

            switch (result) {
                case 30:
                    medicamentsMap.putIfAbsent("Patch", 0);
                    medicamentsMap.put("Patch", medicamentsMap.get("Patch") + 1);
                    textilesQueue.poll();
                    medicamentsStack.pop();
                    break;
                case 40:
                    medicamentsMap.putIfAbsent("Bandage", 0);
                    medicamentsMap.put("Bandage", medicamentsMap.get("Bandage") + 1);
                    textilesQueue.poll();
                    medicamentsStack.pop();
                    break;
                case 100:
                    medicamentsMap.putIfAbsent("MedKit", 0);
                    medicamentsMap.put("MedKit", medicamentsMap.get("MedKit") + 1);
                    textilesQueue.poll();
                    medicamentsStack.pop();
                    break;
                default:
                    if (result > 100) {
                        int leftOver = result - 100;
                        medicamentsMap.putIfAbsent("MedKit", 0);
                        medicamentsMap.put("MedKit", medicamentsMap.get("MedKit") + 1);
                        textilesQueue.poll();
                        medicamentsStack.pop();
                        int nextTextiles = medicamentsStack.pop();
                        nextTextiles += leftOver;
                        medicamentsStack.push(nextTextiles);
                    } else {
                        textilesQueue.poll();
                        currentMedicament = medicamentsStack.pop();
                        medicamentsStack.push(currentMedicament += 10);
                    }
                    break;
            }
        }
        if (textilesQueue.isEmpty() && !medicamentsStack.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else if (medicamentsStack.isEmpty() && !textilesQueue.isEmpty()) {
            System.out.println("Medicaments are empty.");
        } else {
            System.out.println("Textiles and medicaments are both empty.");
        }
        if (!medicamentsMap.isEmpty()){
            medicamentsMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
        }
        if (!textilesQueue.isEmpty()) {
            System.out.print("Textiles left: ");
            for (int i = 0; i < textilesQueue.size() - 1; i++) {
                System.out.print(textilesQueue.poll() + ", ");
            }
            System.out.print(textilesQueue.poll());
        }else if (!medicamentsStack.isEmpty()){
            System.out.print("Medicaments left: ");
            for (int i = 0; i < medicamentsStack.size() - 1; i++) {
                System.out.print(medicamentsStack.pop() + ", ");
            }
            System.out.print(medicamentsStack.pop());
        }
    }
}

