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
        System.out.println("Headers : Name / cost / required level / damage reduction");
        for (int j = 0; j < weaponsList.size(); j++) {
            Weapons weapon = weaponsList.get(j);
            System.out.println("[" + (j + 1) + "] " + weapon.name + "  " + weapon.cost + "  " + weapon.level + "  " + weapon.damage);
        }
    }

}
