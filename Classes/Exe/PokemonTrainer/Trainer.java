package JavaAdvanced.Classes.Exe.PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = pokemons;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }
    public void commandExecuting(String command){
        if (isCommandExisting(command)){
            numberOfBadges++;
        }else{
            for (int i = 0; i < pokemons.size(); i++) {
                pokemons.get(i).setHealth(pokemons.get(i).getHealth() - 10);
                if (pokemons.get(i).getHealth() <= 0){
                    pokemons.remove(i);
                    i--;
                }
            }
        }
    }

    public boolean isCommandExisting(String command){
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(command)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d%n", this.name, this.numberOfBadges, pokemons.size());
    }
}
