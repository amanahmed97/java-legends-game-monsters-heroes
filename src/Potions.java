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

    public static void printpotionsList() {
        System.out.println("Headers : Name / cost / required level / damage reduction");
        for (int j = 0; j < potionsList.size(); j++) {
            Potions potions = potionsList.get(j);
            System.out.println("[" + (j + 1) + "] " + potions.name + "  " + potions.cost + "  " + potions.level + "  " + potions.damage);
        }
    }

}
