import java.io.*;
import java.util.*;

public class Potions {
    String name;
    int cost;
    int level;
    int damage;
    public static ArrayList<Potions> potionsList;

    public Potions(String name, int cost, int level, int damage) {
        this.name = name;
        this.cost = cost;
        this.level = level;
        this.damage = damage;
    }

    public static void populate() throws IOException {
        potionsList = new ArrayList<Potions>();

        String line;
        int ctr = 0;
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        // Parse the file
        File file = new File("./src/gamelib/Potions.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            String sp = "\\s+";
            String[] iarray = line.split(sp);

            // Skip the first header line
            if (ctr == 0 || iarray.length < 7) {
                ctr++;
                continue;
            }

            potionsList.add(new Potions(iarray[0], Integer.parseInt(iarray[1]), Integer.parseInt(iarray[2]), Integer.parseInt(iarray[3]) ) );
            ctr++;
        }

    }

    public static void printPotionsList() {
        System.out.println("Headers : Name / cost / required level / damage reduction");
        for (int j = 0; j < potionsList.size(); j++) {
            Potions potions = potionsList.get(j);
            System.out.println("[" + (j + 1) + "] " + potions.name + "  " + potions.cost + "  " + potions.level + "  " + potions.damage);
        }
    }

    public static void printHeroPotions(int heroSelect) {
        System.out.println("HERO OWNED potion\n"+"============");
        System.out.println("Headers : Name / cost / required level / damage reduction");
        ArrayList<Potions> heroPotions = Player.heroes.get(heroSelect).potionsInventory;
        for (int j = 0; j < heroPotions.size(); j++) {
            Potions potion = heroPotions.get(j);
            System.out.println("[" + (j + 1) + "] " + potion.name + "  " + potion.cost + "  " + potion.level + "  " + potion.damage);
        }
    }

    public static boolean buyPotions(int heroSelect){
        HeroType hero = Player.heroes.get(heroSelect);
        System.out.println("Hero's Gold : "+hero.gold);
        printHeroPotions(heroSelect);
        printPotionsList();

        int potionSelect=0;
        Scanner ip = new Scanner(System.in);

        try {
            System.out.print("Enter selection : ");
            potionSelect = ip.nextInt();

            while(potionSelect<1 || potionSelect>potionsList.size()){
                System.out.println("Input valid Potion number : ");
                potionSelect = ip.nextInt();
            }

        }catch (Exception e){
            System.out.println("Select valid Potion number.");
            return false;
        }

        if ( hero.gold < potionsList.get(potionSelect).cost ){
            System.out.println("Not enough gold.");
            return false;
        }

        if ( !hero.potionsInventory.contains(potionsList.get(potionSelect)) ) {
            hero.potionsInventory.add(potionsList.get(potionSelect));
            hero.gold -= potionsList.get(potionSelect).cost;
            System.out.println("Potion bought : "+potionsList.get(potionSelect));
            System.out.println("Hero's Current Gold : "+hero.gold);
            return true;
        }
        else
            System.out.println("Potion already owned!");

        return true;
    }

    public static boolean sellPotions(int heroSelect){
        HeroType hero = Player.heroes.get(heroSelect);
        System.out.println("Hero's Gold : "+hero.gold);
        System.out.println("You will get half the displayed cost of the potion in your inventory, if you sell.");
        printHeroPotions(heroSelect);

        int potionSelect=0;
        Scanner ip = new Scanner(System.in);

        try {
            System.out.print("Enter selection : ");
            potionSelect = ip.nextInt();

            while(potionSelect<1 || potionSelect>hero.potionsInventory.size()){
                System.out.println("Input valid Potion number : ");
                potionSelect = ip.nextInt();
            }

        }catch (Exception e){
            System.out.println("Select valid Potion number.");
            return false;
        }

        hero.gold += hero.potionsInventory.get(potionSelect).cost / 2;
        System.out.println("Potion sold : "+hero.potionsInventory.get(potionSelect));
        hero.potionsInventory.remove(hero.potionsInventory.get(potionSelect));
        System.out.println("Hero's Current Gold : "+hero.gold);

        return true;
    }

}