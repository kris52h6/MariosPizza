import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {
    private Menu menu;
    private ArrayList<Order> orderList = new ArrayList<>();

    public Controller() throws FileNotFoundException {
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
            String orderResult = order.writeToFile();
            removeFromOrderList(order);
            addToOrderHistory(orderResult);
            return true;
        }
        return false;
    }

    private void addToOrderHistory(String order) {
        File file = new File("data/orders.txt");

        try {
            PrintStream ps = new PrintStream(new FileOutputStream(file, true));
           // ps.println(order.getOrder());
            ps.println(order);

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

    ArrayList getFinishedOrders() throws FileNotFoundException {
        ArrayList<String> finishedOrders = new ArrayList<>();
        Scanner sc = new Scanner(new File("data/orders.txt"));
        sc.useDelimiter(";");

        while(sc.hasNext()){
            String orderId = sc.next();
            String[] pizzaIdsString = sc.next().split(",");
            int[] pizzaIds = new int[pizzaIdsString.length];
            for (int i = 0; i < pizzaIdsString.length; i++) {
                pizzaIds[i] = Integer.parseInt(pizzaIdsString[i]);
            }
            String[] pizzaNames = new String[pizzaIds.length];
            int totalCost = 0;
            for (int i = 0; i < pizzaIds.length; i++) {
                pizzaNames[i] = menu.menuList.get(pizzaIds[i]).getName();
                totalCost += menu.menuList.get(pizzaIds[i]).getPrice();
            }
            String pizzas = "";
            for (int i = 0; i < pizzaNames.length; i++) {
                int count = i + 1;
                if (count == pizzaNames.length) {
                    pizzas += pizzaNames[i];
                } else {
                    pizzas += pizzaNames[i];
                    pizzas += ",";
                }
            }

            finishedOrders.add(orderId + ";" + pizzas + ";" + totalCost + ";");
        }


        return finishedOrders;
    }
}