package JavaAdvanced.Generics.Exe.GenericSwapMethodString;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String data = scanner.nextLine();
            box.add(data);
        }
        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();
        box.swap(firstIndex, secondIndex);

        System.out.println(box);

    }
}
