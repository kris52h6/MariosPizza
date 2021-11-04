import java.util.ArrayList;

public class Order {
    private int orderId;
    private ArrayList<Pizza> pizzas = new ArrayList<>();

    public Order(int orderId) {
        this.orderId = orderId;
        this.pizzas = pizzas;
    }

    public Pizza addToOrder(Pizza pizza){
        pizzas.add(pizza);
        return pizza;
    }

    @Override
    public String toString() {
        String result = "";
        result += "Order number: " + orderId + "\n";
        result += "Pizzasn";

        if(pizzas.size() == 0) {
            result += "No pizza is added";
        } else {
            for (int i = 0; i < pizzas.size(); i++) {
                result += pizzas.get(i).getName() + "\n";
            }
        }

        return result;
    }

    public String getOrder() {
        return order.getName() + ";" + order.getPrice();
    }

    public int getOrderId() {
        return orderId;
    }
}
