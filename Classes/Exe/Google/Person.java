package JavaAdvanced.Classes.Exe.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Child> children;
    private List<Parent> parents;

    public Person(){
        this.pokemons = new ArrayList<>();
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public Person(Company company, Car car, List<Pokemon> pokemons, List<Child> children, List<Parent> parents) {
        this.company = company;
        this.car = car;
        this.pokemons = pokemons;
        this.children = children;
        this.parents = parents;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company:").append("\n");
        if (company != null){
            sb.append(company).append("\n");
        }
        sb.append("Car:").append("\n");
        if (car != null){
            sb.append(car).append("\n");
        }
        sb.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemons) {
            sb.append(pokemon).append("\n");
        }
        sb.append("Parents:").append("\n");
        for (Parent parent : parents) {
            sb.append(parent).append("\n");
        }
        sb.append("Children:").append("\n");
        for (Child child : children) {
            sb.append(child).append("\n");
        }
        return sb.toString();
    }
}
