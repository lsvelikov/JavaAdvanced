package JavaAdvanced.Classes.Exe.PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<Pokemon>> trainerMap = new LinkedHashMap<>();
        while (!input.equals("Tournament")){
            String[] data = input.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainerMap.putIfAbsent(trainerName, new ArrayList<>());
            trainerMap.get(trainerName).add(pokemon);

            input = scanner.nextLine();
        }
        List<Trainer> trainers = trainerMap.entrySet().stream().map(t -> new Trainer(t.getKey(), t.getValue())).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("End")){
            for (Trainer trainer : trainers) {
                trainer.commandExecuting(command);
            }

            command = scanner.nextLine();
        }
        trainers.stream().sorted(Comparator.comparingInt(Trainer::getNumberOfBadges).reversed()).forEach(trainer -> System.out.print(trainer.toString()));
    }
}
