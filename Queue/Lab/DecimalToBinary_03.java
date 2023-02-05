package JavaAdvanced.Queue.Stacks.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary_03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

        if (decimal == 0){
            System.out.println("0");
        }
        while (decimal != 0){
            binaryNumber.push(decimal % 2);
            decimal /= 2;
        }
        ArrayDeque<Integer> newBinary = new ArrayDeque<>(binaryNumber);
        for (int i = 0; i < newBinary.size(); i++) {
            System.out.print(binaryNumber.pop() + "");
        }
    }
}
