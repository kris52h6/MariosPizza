public class Controller {
    private Menu menu;

    public Controller() {
        this.menu = new Menu();
    }

    public Menu getMenu() {
        return menu;
    }

    public Iterable<Pizza> getAllPizzas() {
        return menu.getAllPizzas();
    }


}