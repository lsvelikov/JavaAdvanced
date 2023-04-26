package JavaAdvanced.MultidimensionalArrays.Exe;

import java.util.Scanner;

public class TheHeiganDance_08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double damage = Double.parseDouble(scanner.nextLine());
        int playerHitPoints = 18500;
        double heiganHitPoints = 3000000;

        int playerRow = 7;
        int playerCol = 7;

        String lastSpell = "";

        while (true){
            if (playerHitPoints >= 0){
                heiganHitPoints -= damage;
            }
            if (lastSpell.equals("Cloud")){
                playerHitPoints -= 3500;
            }
            if (playerHitPoints < 0 || heiganHitPoints < 0){
                break;
            }

            String[] damageData = scanner.nextLine().split("\\s+");
            String spell = damageData[0];
            int damagedRow = Integer.parseInt(damageData[1]);
            int damagedCol = Integer.parseInt(damageData[2]);

            if (isInDamageArea(damagedRow, damagedCol, playerRow, playerCol)) {
                if (!isInDamageArea(damagedRow, damagedCol, playerRow - 1, playerCol) && isWall(playerRow - 1)) {
                    playerRow--;
                    lastSpell = "";
                } else if (!isInDamageArea(damagedRow, damagedCol, playerRow, playerCol + 1) && isWall(playerCol + 1)) {
                    playerCol++;
                    lastSpell = "";
                } else if (!isInDamageArea(damagedRow, damagedCol, playerRow + 1, playerCol) && isWall(playerRow + 1)) {
                    playerRow++;
                    lastSpell = "";
                } else if (!isInDamageArea(damagedRow, damagedCol, playerRow, playerCol - 1) && isWall(playerCol - 1)) {
                    playerCol--;
                    lastSpell = "";
                } else {
                    if (spell.equals("Cloud")) {
                        playerHitPoints -= 3500;
                        lastSpell = "Cloud";
                    } else if (spell.equals("Eruption")) {
                        playerHitPoints -= 6000;
                        lastSpell = "Eruption";
                    }
                }
            }
        }
        lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";
        String heiganState = heiganHitPoints <= 0 ? "Heigan: Defeated!" : String.format("Heigan: %.2f", heiganHitPoints);
        String playerState = playerHitPoints <= 0 ? String.format("Player: Killed by %s", lastSpell) : String.format("Player: %d", playerHitPoints);
        String playerEndCoordinates = String.format("Final position: %d, %d", playerRow, playerCol);

        System.out.println(heiganState);
        System.out.println(playerState);
        System.out.println(playerEndCoordinates);
    }
    private static boolean isWall(int moveCell) {
        return moveCell >= 0 && moveCell < 15;
    }

    private static boolean isInDamageArea(int damagedRow, int damagedCol, int moveRow, int moveCol) {
        return ((damagedRow - 1 <= moveRow && moveRow <= damagedRow + 1)
                && (damagedCol - 1 <= moveCol && moveCol <= damagedCol + 1));
    }
}
