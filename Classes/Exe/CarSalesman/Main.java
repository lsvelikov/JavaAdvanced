package JavaAdvanced.Classes.Exe.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Engine> engines = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            int displacement = 0;
            String efficiency = null;

            if (input.length == 4) {
                displacement = Integer.parseInt(input[2]);
                efficiency = input[3];
            } else if (input.length == 3) {
                if (Character.isDigit(input[2].charAt(0))) {
                    displacement = Integer.parseInt(input[2]);
                } else {
                    efficiency = input[2];
                }
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= m; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            String engineModel = carData[1];
            int weight = 0;
            String color = null;

            if (carData.length == 4) {
                weight = Integer.parseInt(carData[2]);
                color = carData[3];
            } else if (carData.length == 3) {
                if (Character.isDigit(carData[2].charAt(0))) {
                    weight = Integer.parseInt(carData[2]);
                } else {
                    color = carData[2];
                }
            }
            Engine carEngine = null;
            for (Engine engine : engines) {
                if (engineModel.equals(engine.getModel())) {
                    carEngine = engine;
                    break;
                }
            }
            Car car = new Car(model, carEngine, weight, color);
            System.out.print(car.toString());
        }
    }
}
