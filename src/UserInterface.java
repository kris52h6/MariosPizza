import java.util.Scanner;

public class UserInterface {
    /*private Scanner scanner;*/
    private final Controller controller;

    public UserInterface(Controller controller){
        this.controller = controller;
    }

    public void start(){
        System.out.println("Welcome to Marios Pizzabar!");

        mainMenu();
    }

    public void mainMenu() {
        System.out.println("""
                \nCommands:
                    1. Menu
                    2. Orders
                    3. Add order
                    4. Finish order
                    9. Exit program
                """);

        Scanner scanner = new Scanner(System.in);

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
                    System.out.println("Add order.");
                    System.out.print("Which pizza number to add?: ");
                    System.out.println("Enter 0 to stop adding pizzas.");
                    boolean addingPizzas = true;
                    while (addingPizzas) {
                        int pizzaId = scanner.nextInt();
                        addOrder(pizzaId);

                    }

                }
                case 4 -> {
                    System.out.println("Finish order.");
                    System.out.println("Which order do you want to finish?: ");
                    finishOrder(scanner);
                }
                case 9 -> {
                    System.out.println("Exiting program...");
                    running = false;
                }
            }
        }
    }

    private void addOrder(int pizzaId) {
        boolean add = controller.addOrder(pizzaId);
        if (add) {
            System.out.println("Order added!");
        } else
            System.out.println("Order failed.");
    }

    private void finishOrder(Scanner scanner) {
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
}
