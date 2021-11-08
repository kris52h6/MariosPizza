import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    public ArrayList<Pizza> menuList = new ArrayList<>();
    private final Scanner sc = new Scanner(new File("data/menu.txt"));


    public Menu() throws FileNotFoundException {
        getAllPizzas();
    }

    public void addToMenu(Pizza pizza) {
        menuList.add(pizza);
    }

    public Iterable<Pizza> getAllPizzas() {
        while (sc.hasNextLine()) {
            sc.useDelimiter(";");
            String pizzaName = sc.next();
            int pizzaId = Integer.parseInt(sc.next());
            String toppings = sc.next();
            int pizzaPrice = Integer.parseInt(sc.next());
            // pizzaToppings = new ArrayList<>(Arrays.asList(toppings.split(",")));
            String[] pizzaToppings = toppings.split(",");
            Pizza pizza = new Pizza(pizzaName, pizzaId, pizzaToppings, pizzaPrice);
            addToMenu(pizza);
            sc.nextLine();
        }
        return menuList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pizza pizza : menuList) {
            sb.append(pizza);
        }
        return sb.toString();
    }

}