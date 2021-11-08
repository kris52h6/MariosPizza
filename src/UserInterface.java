import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    /*private Scanner scanner;*/
    private final Controller controller;
    Scanner scanner = new Scanner(System.in);


    public UserInterface(Controller controller){
        this.controller = controller;
    }

    public void start() throws FileNotFoundException {
        System.out.println("Welcome to Marios Pizzabar!");

        mainMenu();
    }

    public void mainMenu() throws FileNotFoundException {
        System.out.println("""
                \nCommands:
                    1. Menu
                    2. Orders
                    3. Add order
                    4. Finish order
                    9. Exit program
                """);


        boolean running = true;
        while (running) {
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1 -> {
                    System.out.println("Showing menu.");
                    showMenu();
                }
                case 2 -> {
                    showAllOrders();
                }
                case 3 -> {
                    System.out.print("Which pizza number to add?: ");
                    System.out.println("Enter 0 to stop adding pizzas.");
                        addOrder();
                }
                case 4 -> {
                    System.out.println("Finish order.");
                    System.out.println("Which order do you want to finish?: ");
                    finishOrder();
                }
                case 5 -> {
                    System.out.println("All orders:");
                    allFinishedOrders();

                }
                case 9 -> {
                    System.out.println("Exiting program...");
                    running = false;
                }
            }
        }
    }

    private void addOrder() {
        Order currentOrder = controller.createOrder();

        boolean addingPizzas = true;
        while (addingPizzas) {
            int pizzaId = scanner.nextInt();
            boolean add = controller.addToOrder(currentOrder, pizzaId);
            if (add) {
                System.out.println("Added pizza to order");
            }else if (pizzaId == 0) {
                System.out.println("Order finished.");
                addingPizzas = false;
            } else {
                System.out.println("Order failed.");
            }
        }
    }

    private void finishOrder() {
        int orderId = scanner.nextInt();
        boolean finish = controller.finishOrder(orderId);
        if (finish) {
            System.out.println("Order finished");
        } else {
            System.out.println("No such order ID.");
        }
    }

    public void showMenu(){
        for (Pizza pizza : controller.getAllPizzas()) {
            System.out.println(pizza);
        }
    }

    public void showAllOrders(){
        System.out.println("""
                All active orders
                ---------------""");
        for (Order order: controller.getOrderList()) {
            System.out.println(order);
        }

    }

    public void allFinishedOrders() throws FileNotFoundException {
        ArrayList allFinishedOrders = controller.getFinishedOrders();
        for (int i = 0; i < ((ArrayList<?>) allFinishedOrders).size(); i++) {
            System.out.println(allFinishedOrders.get(i));
        }
    }
}
