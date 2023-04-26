package JavaAdvanced.SetsAndMaps.Exe;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> username = new LinkedHashSet<>();
        for (int i = 1; i <= n; i++) {
            String user = scanner.nextLine();

            username.add(user);
        }
        for (String user : username) {
            System.out.println(user);
        }
    }
}
