package JavaAdvanced.Generics.Exe.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box(){
        this.elements = new ArrayList<>();
    }
    public void add(T element){
        elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T element : elements) {
            builder.append(element.getClass().getName() + ": " + element).append("\n");
        }
        return builder.toString();
    }
}
