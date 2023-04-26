package JavaAdvanced.Classes.Exe.RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tyre> tyres;

    public Car(String model, Engine engine, Cargo cargo, List<Tyre> tyres) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyres = tyres;
    }
    public void extract(String command){
        switch (command){
            case "fragile":
                for (Tyre tyre : tyres) {
                    if (tyre.getPressure() < 1){
                        System.out.println(model);
                        break;
                    }
                }
                break;
            case "flamable":
                if (engine.getPower() > 250){
                    System.out.println(model);
                }
                break;
        }
    }
}
