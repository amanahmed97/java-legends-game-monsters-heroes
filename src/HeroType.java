import java.io.*;
import java.util.*;

public class HeroType {
    String name;
    int level;
    int HP;
    int MP;
    int strength;
    int dexterity;
    int agility;
    int gold;

    ArrayList<Weapons> weaponsInventory;
    ArrayList<Armory> armoryInventory;
    ArrayList<Spells> spellsInventory;
    ArrayList<Potions> potionsInventory;
    public static ArrayList<HeroType> heroList;

    public HeroType(String name, int MP, int strength, int agility, int dexterity, int gold, int level) {
        this.name = name;
        this.level = level;
        this.HP = level * 100;
        this.MP = MP;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.gold = gold;
        this.weaponsInventory = new ArrayList<Weapons>();
        this.armoryInventory = new ArrayList<Armory>();
        this.spellsInventory = new ArrayList<Spells>();
        this.potionsInventory = new ArrayList<Potions>();
    }

    public static void populate() throws IOException {
        heroList = new ArrayList<HeroType>();
        populateWarriors();
        populatePaladins();
        populateSorcerers();
    }

    public static void populateWarriors() throws IOException {
        String line;
        int ctr = 0;
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        // Parse the file
        File file = new File("./src/gamelib/Warriors.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            String sp = "\\s+";
            String[] iarray = line.split(sp);

            // Skip the first header line
            if (ctr == 0 || iarray.length < 7) {
                ctr++;
                continue;
            }

            heroList.add(new HeroType("Warrior " + iarray[0], Integer.parseInt(iarray[1]), Integer.parseInt(iarray[2]), Integer.parseInt(iarray[3]),
                    Integer.parseInt(iarray[4]), Integer.parseInt(iarray[5]), Integer.parseInt(iarray[6])));
            ctr++;
        }

    }

    public static void populatePaladins() throws IOException {

        String line;
        int ctr = 0;

        // Parse the file
        File file = new File("./src/gamelib/Paladins.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            String sp = "\\s+";
            String[] iarray = line.split(sp);
            // Skip the first header line
            if (ctr == 0 || iarray.length < 4) {
                ctr++;
                continue;
            }
            heroList.add(new HeroType("Paladin " + iarray[0], Integer.parseInt(iarray[1]), Integer.parseInt(iarray[2]), Integer.parseInt(iarray[3]),
                    Integer.parseInt(iarray[4]), Integer.parseInt(iarray[5]), Integer.parseInt(iarray[6])));
            ctr++;
        }

    }

    public static void populateSorcerers() throws IOException {

        String line;
        int ctr = 0;

        // Parse the file
        File file = new File("./src/gamelib/Sorcerers.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            String sp = "\\s+";
            String[] iarray = line.split(sp);
            // Skip the first header line
            if (ctr == 0 || iarray.length < 4) {
                ctr++;
                continue;
            }

            heroList.add(new HeroType("Sorcerer " + iarray[0], Integer.parseInt(iarray[1]), Integer.parseInt(iarray[2]), Integer.parseInt(iarray[3]),
                    Integer.parseInt(iarray[4]), Integer.parseInt(iarray[5]), Integer.parseInt(iarray[6])));
            ctr++;
        }
    }

    public static void printHeroList() {
        System.out.println("Headers : Name / mana / strength / agility / dexterity / starting money / starting experience");
        for (int j = 0; j < heroList.size(); j++) {
            HeroType hero = heroList.get(j);
            System.out.println("[" + (j + 1) + "] " + hero.name + "  " + hero.MP + "  " + hero.strength + "  " + hero.agility + "  " + hero.dexterity + "  " + hero.gold + "  " + hero.level);
        }
    }

}
