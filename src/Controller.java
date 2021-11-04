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

    // checks if the pizza exists on the menu
    private Pizza checkPizzaId(int pizzaNumber) {
        for (Pizza pizza: menu.getAllPizzas()) {
            if (pizzaNumber == pizza.getId()) {
                return pizza;
            }
        }
        return null;
    }


    public boolean addToOrder(Order currentOrder, int pizzaId) {
        Pizza pizza = checkPizzaId(pizzaId);
        if (pizza != null) {
            currentOrder.addToOrder(pizza);
            return true;
        }
        finished(currentOrder);
        return false;
    }

    public Order createOrder() {
        int counter = orderList.size() + 1; // sets orderId to be the length of the orderList. +1 to skip 0
        return new Order(counter);
    }

    // Adds orders to full orderlist.
    private void finished(Order currentOrder) {
        orderList.add(currentOrder);
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
            ps.println(order.getOrder());
        } catch (FileNotFoundException e) {
        }
    }

    private void removeFromOrderList(Order order) {
        orderList.remove(order);
    }

    private Order checkOrder(int orderId) {
        for (Order order: orderList) {
            if (orderId == order.getOrderId()) {
                return order;
            }
        }
        return null;
    }


}