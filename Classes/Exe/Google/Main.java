package JavaAdvanced.Classes.Exe.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Person> personMap = new HashMap<>();
        while (!input.equals("End")){
            String[] data = input.split("\\s+");
            String personName = data[0];
            if (!personMap.containsKey(personName)){
                personMap.put(personName, new Person());
            }
            String command = data[1];
            switch (command){
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName, department, salary);
                    personMap.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personMap.get(personName).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    personMap.get(personName).getParents().add(parent);
                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];
                    Child child = new Child(childName, childBirthday);
                    personMap.get(personName).getChildren().add(child);
                    break;
                case "car":
                    String carModel = data[2];
                    int carSpeed = Integer.parseInt(data[3]);
                    Car car = new Car(carModel, carSpeed);
                    personMap.get(personName).setCar(car);
                    break;
            }


            input = scanner.nextLine();
        }
        String searchedPerson = scanner.nextLine();
        System.out.println(searchedPerson);

        Person personalData = personMap.get(searchedPerson);
        System.out.println(personalData);
    }
}
