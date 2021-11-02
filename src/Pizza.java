import java.util.Arrays;

public class Pizza {
    private String name;
    private int id;
    private String[] toppings;

    public Pizza(String name, int id, String[] toppings) {
        this.name = name;
        this.id = id;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", toppings=" + Arrays.toString(toppings) +
                '}';
    }
}
