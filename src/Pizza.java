import java.util.Arrays;

public class Pizza {
    private String name;
    private int id;
    private String[] toppings;
    private int price;

    public Pizza(String name, int id, String[] toppings, int price) {
        this.name = name;
        this.id = id;
        this.toppings = toppings;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + ". " + name + ": " + Arrays.toString(toppings) + "..." + price + ",-";
    }
}
