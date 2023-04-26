package JavaAdvanced.Generics.Exe.GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = elements.get(firstIndex);
        elements.set(firstIndex, elements.get(secondIndex));
        elements.set(secondIndex, temp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : elements) {
            sb.append(String.format("%s: %s%n", value.getClass().getName(), value));
        }
        return sb.toString();
    }
}
