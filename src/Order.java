import java.util.ArrayList;

public class Order {
    private int orderId;
    private Pizza order;

    public Order(int orderId, Pizza order) {
        this.orderId = orderId;
        this.order = order;
    }

    @Override
    public String toString() {
        return "Order Number = " + orderId +
                ". Pizza = " + order.getName();
    }

    public String getOrder() {
        return order.getName() + ";" + order.getPrice();
    }

    public int getOrderId() {
        return orderId;
    }
}
