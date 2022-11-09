import java.io.*;
import java.util.*;

public class Weapons {
    String name;
    int cost;
    int level;
    int damage;
    public static ArrayList<Weapons> weaponsList;

    public Weapons(String name, int cost, int level, int damage) {
        this.name = name;
        this.cost = cost;
        this.level = level;
        this.damage = damage;
    }

    public static void populate() throws IOException {
        weaponsList = new ArrayList<Weapons>();

        String line;
        int ctr = 0;
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        // Parse the file
        File file = new File("./src/gamelib/Weaponry.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            String sp = "\\s+";
            String[] iarray = line.split(sp);

            // Skip the first header line
            if (ctr == 0 || iarray.length < 7) {
                ctr++;
                continue;
            }

            weaponsList.add(new Weapons(iarray[0], Integer.parseInt(iarray[1]), Integer.parseInt(iarray[2]), Integer.parseInt(iarray[3]) ) );
            ctr++;
        }
        
    }

    public static void printWeaponsList() {
        System.out.println("WEAPONS LIST\n"+"============");
        System.out.println("Headers : Name / cost / required level / damage reduction");
        for (int j = 0; j < weaponsList.size(); j++) {
            Weapons weapon = weaponsList.get(j);
            System.out.println("[" + (j + 1) + "] " + weapon.name + "  " + weapon.cost + "  " + weapon.level + "  " + weapon.damage);
        }
    }

    public static void printHeroWeapons(int hero) {
        System.out.println("HERO OWNED WEAPONS\n"+"============");
        System.out.println("Headers : Name / cost / required level / damage reduction");
        ArrayList<Weapons> heroWeapons = Player.heroes.get(hero).weaponsInventory;
        for (int j = 0; j < heroWeapons.size(); j++) {
            Weapons weapon = heroWeapons.get(j);
            System.out.println("[" + (j + 1) + "] " + weapon.name + "  " + weapon.cost + "  " + weapon.level + "  " + weapon.damage);
        }
    }

    public static boolean buyWeapons(int hero){
        printHeroWeapons(hero);
        printWeaponsList();

        int weaponSelect=0;
        Scanner ip = new Scanner(System.in);

        try {
            System.out.print("Enter selection : ");
            weaponSelect = ip.nextInt();

            while(weaponSelect<1 || weaponSelect>weaponsList.size()){
                System.out.println("Input valid Weapon number : ");
                weaponSelect = ip.nextInt();
            }

        }catch (Exception e){
            System.out.println("Select valid Weapon number.");
            return false;
        }

        if ( !Player.heroes.get(hero).weaponsInventory.contains(weaponsList.get(weaponSelect)) )
            Player.heroes.get(hero).weaponsInventory.add(weaponsList.get(weaponSelect));
        else
            System.out.println("Weapon already owned!");

        return true;
    }

    public static boolean sellWeapons(int hero){
        printHeroWeapons(hero);
        printWeaponsList();

        int weaponSelect=0;
        Scanner ip = new Scanner(System.in);

        try {
            System.out.print("Enter selection : ");
            weaponSelect = ip.nextInt();

            while(weaponSelect<1 || weaponSelect>weaponsList.size()){
                System.out.println("Input valid Weapon number : ");
                weaponSelect = ip.nextInt();
            }

        }catch (Exception e){
            System.out.println("Select valid Weapon number.");
            return false;
        }

        if ( !Player.heroes.get(hero).weaponsInventory.contains(weaponsList.get(weaponSelect)) )
            Player.heroes.get(hero).weaponsInventory.add(weaponsList.get(weaponSelect));
        else
            System.out.println("Weapon already owned!");

        return true;
    }


}
