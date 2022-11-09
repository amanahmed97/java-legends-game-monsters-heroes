import java.io.*;
import java.util.*;

public class Spells {
    String name;
    int cost;
    int level;
    int damage;
    int mana;
    public static ArrayList<Spells> spellsList;

    public Spells(String name, int cost, int level, int damage, int mana) {
        this.name = name;
        this.cost = cost;
        this.level = level;
        this.damage = damage;
        this.mana = mana;
    }

    public static void populate() throws IOException {
        spellsList = new ArrayList<Spells>();

        String line;
        int ctr = 0;
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        // Parse the file
        File file = new File("./src/gamelib/FireSpells.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            String sp = "\\s+";
            String[] iarray = line.split(sp);

            // Skip the first header line
            if (ctr == 0 || iarray.length < 7) {
                ctr++;
                continue;
            }

            spellsList.add(new Spells(iarray[0], Integer.parseInt(iarray[1]), Integer.parseInt(iarray[2]), Integer.parseInt(iarray[3]), Integer.parseInt(iarray[4]) ) );
            ctr++;
        }

    }

    public static void printspellsList() {
        System.out.println("Headers : Name / cost / required level / mana cost");
        for (int j = 0; j < spellsList.size(); j++) {
            Spells spells = spellsList.get(j);
            System.out.println("[" + (j + 1) + "] " + spells.name + "  " + spells.cost + "  " + spells.level + "  " + spells.damage + "  " + spells.mana);
        }
    }

}
