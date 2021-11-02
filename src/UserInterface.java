import java.util.Scanner;

public class UserInterface {

    public UserInterface() {
        System.out.println("Welcome to Marios Pizzabar! " +
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
}
