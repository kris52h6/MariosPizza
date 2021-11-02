public class Menu {
    private ArrayList<Pizza> menu = new ArrayList<>();

    public Menu() {




    //Alle pizzaer - Strings

    Pizza vesuvio = new Pizza("Hawaii", 1, new String[]{"tomatsauce", "ost", "skinke", "oregano"});
    System.out.println(vesuvio);

    Pizza amerikaner = new Pizza ("Amerikaner", 1, new String[]{"tomatsauce", "ost", "oksefars", "oregano"})Pizza cacciatore = new

                Pizza cacciatore = new Pizza ("Cacciatore", 1, new String[]{"tomatsauce", "ost", "pepperoni", "oregano"});("Cacciatore", 1, new String[]{"tomatsauce", "ost", "pepperoni", "oregano"});

    Pizza carbona = new Pizza ("Carbona", 1, new String[]{"tomatsauce", "ost", "kødsauce", "spaghetti", "cocktailpølser",  Pizza amerikaner = new Pizza ("Amerikaner", 1, new String[]{"tomatsauce", "ost", "oksefars", "oregano"});
}
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pizza pizza : menu) {
            sb.append(pizza);
        }
        return sb.toString();
    }

}