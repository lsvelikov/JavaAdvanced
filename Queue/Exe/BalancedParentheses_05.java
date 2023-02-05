package JavaAdvanced.Queue.Stacks.Exe;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_05 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> parentheses = new ArrayDeque<>();

        boolean areBalanced = false;
        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (currentSymbol == '{' || currentSymbol == '(' || currentSymbol == '['){
                parentheses.push(currentSymbol);
            } else if(currentSymbol == '}' || currentSymbol == ')' || currentSymbol == ']'){
                if (parentheses.isEmpty()){
                    areBalanced = false;
                    break;
                }
                char symbol = parentheses.pop();
                if (symbol == '{' && currentSymbol == '}'){
                    areBalanced = true;
                } else if(symbol == '[' && currentSymbol == ']'){
                    areBalanced = true;
                }else if (symbol == '(' && currentSymbol == ')'){
                    areBalanced = true;
                }else{
                    areBalanced = false;
                    break;
                }
            }
        }
        if (areBalanced){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
