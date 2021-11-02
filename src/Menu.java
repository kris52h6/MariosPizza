public class Menu {
    private ArrayList<Pizza> menu = new ArrayList<>();

    public Menu() {

    //Alle pizzaer - Strings

    Pizza vesuvio = new Pizza("Vesuvio", 1, new String[]{"tomatsauce", "ost", "skinke", "oregano"}, 57);

    Pizza amerikaner = new Pizza ("Amerikaner", 2, new String[]{"tomatsauce", "ost", "oksefars", "oregano"}, 53);

    Pizza cacciatore = new Pizza ("Cacciatore", 3, new String[]{"tomatsauce", "ost", "pepperoni", "oregano"}, 57);

    Pizza carbona = new Pizza ("Carbona", 4, new String[]{"tomatsauce", "ost", "kødsauce", "spaghetti", "cocktailpølser", "Oregano"}, 63);

    Pizza dennis = new Pizza ("Dennis", 5, new String[]{"tomatsauce", "ost", "skinke", "pepperoni", "cocktailpølser", "Oregano"}, 65);

    Pizza bertil = new Pizza ("Bertil", 6, new String[]{"tomatsauce", "ost", "bacon", "oregano"}, 57);

    Pizza silvia = new Pizza ("Silvia", 7, new String[]{"tomatsauce", "ost", "pepperoni", "rød peber", "løg", "oliven", "oregano"}, 61);

    Pizza victoria = new Pizza ("Victoria", 8, new String[]{"tomatsauce", "ost", "skinke", "ananas", "champignon", "løg", "oregano"},61);

    Pizza toronfo = new Pizza ("Toronfo", 9, new String[]{"tomatsauce", "ost", "skinke", "kebab", "bacon", "chili", "oregano"}, 61);

    Pizza capricciosa = new Pizza("Capricciosa", 10, new String[]{"tomatsauce", "ost", "skinke", "champignon", "oregano"}, 61);

    Pizza hawai = new Pizza("Hawai", 11, new String[]{"tomatsauce", "ost", "skinke", "ananas", "oregano"}, 61);

    Pizza leBlissola = new Pizza("Le Blissola", 12, new String[]{"tomatsauce", "ost", "skinke", "rejer", "oregano"}, 61);

    Pizza venezia = new Pizza("Venezia", 13, new String[]{"tomatsauce", "ost", "skinke", "bacon", "oregano"}, 61);

    Pizza mafia = new Pizza("Mafia", 14, new String[]{"tomatsauce", "ost", "pepperoni", "bacon", "løg", "oregano"}, 61);

    addToMenu(vesuvio);
    addToMenu(amerikaner);
    addToMenu(cacciatore);
    addToMenu(carbona);
    addToMenu(dennis);
    addToMenu(bertil);
    addToMenu(silvia);
    addToMenu(victoria);
    addToMenu(toronfo);
    addToMenu(capricciosa);
    addToMenu(hawai);
    addToMenu(leBlissola);
    addToMenu(venezia);
    addToMenu(mafia);

    }

    public void addToMenu(Pizza pizza) {
        menuList.add(pizza);
    }

    public Iterable<Pizza> getAllPizzas() {
        return menuList;
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