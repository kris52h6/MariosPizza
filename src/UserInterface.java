import java.util.Scanner;

public class UserInterface {

    private final Controller controller;

    public UserInterface(Controller controller){
        this.controller = controller;
    }

    public void start(){
        System.out.println("Welcome to Marios Pizzabar!");

        mainMenu();
    }

    public void mainMenu() {
        System.out.println(
                "\nCommands:" +
                "\n\t1. Menu" +
                "\n\t2. Orders" +
                "\n\t3. Add order" +
                "\n\t4. Finish order" +
                "\n\t9. Exit program"
        );

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1 -> {
                    System.out.println("Showing menu.");
                    // TODO show menu
                }
                case 2 -> {
                    System.out.println("Show orders.");
                    showAllOrders();
                    // TODO show orders
                }
                case 3 -> {
                    System.out.println("Add order.");
                    // TODO add order
                }
                case 4 -> {
                    System.out.println("Finish order.");
                    // TODO finish order / add order to order history file.
                }
                case 9 -> {
                    System.out.println("Exiting program...");
                    running = false;
                }
            }
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

    }
}
