import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Controller {
    private Menu menu;
    private ArrayList<Order> orderList = new ArrayList<>();

    public Controller() {
        this.menu = new Menu();
    }

    public Iterable<Pizza> getAllPizzas() {
        return menu.getAllPizzas();
    }

    public Iterable<Order> getOrderList() {
        return orderList;
    }


    // ----------- Add order
    public Pizza getPizzaById(int pizzaNumber) {
        for (Pizza pizza: menu.getAllPizzas()) {
            if (pizzaNumber == pizza.getId()) {
                System.out.println(pizza);
                return pizza;
            }
        }
        return null;
    }

    
    public Order createOrder(Pizza pizza) {
        int counter = orderList.size() + 1; // sets orderId to be the length of the orderList. +1 to skip 0
        return new Order(counter, pizza);
    }

    public boolean addOrder(int pizzaId) {
        Pizza pizza = getPizzaById(pizzaId);
        if (pizza != null) {
            Order order = createOrder(pizza);
            orderList.add(order);
            return true;
        }
        return false;
    }

    // ----------- Remove order
    public boolean finishOrder(int orderId) {
        Order order = checkOrder(orderId);
        if (order != null) {
            removeFromOrderList(order);
            addToOrderHistory(order);
            return true;
        }
        return false;
    }

    private void addToOrderHistory(Order order) {
        File file = new File("data/orders.txt");

        try {
            PrintStream ps = new PrintStream(new FileOutputStream(file, true));
            ps.println(order.getOrder() + "kr");
        } catch (FileNotFoundException e) {
        }
    }

    private void removeFromOrderList(Order order) {
        orderList.remove(order);
    }

    public Order checkOrder(int orderId) {
        for (Order order: orderList) {
            if (orderId == order.getOrderId()) {
                return order;
            }
        }
        return null;
    }


}