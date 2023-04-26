package JavaAdvanced.Classes.Exe.RawData;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Car>> cars = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            List<Tyre> tyreList = new ArrayList<>();
            for (int tyreItems = 5; tyreItems <= 12; tyreItems += 2) {
                Tyre currentTyre = new Tyre(Double.parseDouble(data[tyreItems]), Integer.parseInt(data[tyreItems + 1]));
                tyreList.add(currentTyre);
            }
            Car currentCar = new Car(model, engine, cargo, tyreList);
            cars.putIfAbsent(cargoType, new ArrayList<>());
            cars.get(cargoType).add(currentCar);
        }
        String command = scanner.nextLine();
        cars.get(command).forEach(car -> car.extract(command));
    }
}
