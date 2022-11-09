import java.io.*;
import java.util.*;

public class Armory {
    String name;
    int cost;
    int level;
    int damage;
    public static ArrayList<Armory> armoryList;

    public Armory(String name, int cost, int level, int damage) {
        this.name = name;
        this.cost = cost;
        this.level = level;
        this.damage = damage;
    }

    public static void populate() throws IOException {
        armoryList = new ArrayList<Armory>();

        String line;
        int ctr = 0;
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        // Parse the file
        File file = new File("./src/gamelib/Armory.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            String sp = "\\s+";
            String[] iarray = line.split(sp);

            // Skip the first header line
            if (ctr == 0 || iarray.length < 7) {
                ctr++;
                continue;
            }

            armoryList.add(new Armory(iarray[0], Integer.parseInt(iarray[1]), Integer.parseInt(iarray[2]), Integer.parseInt(iarray[3]) ) );
            ctr++;
        }

    }

    public static void printArmoryList() {
        System.out.println("Headers : Name / cost / required level / damage reduction");
        for (int j = 0; j < armoryList.size(); j++) {
            Armory armory = armoryList.get(j);
            System.out.println("[" + (j + 1) + "] " + armory.name + "  " + armory.cost + "  " + armory.level + "  " + armory.damage);
        }
    }

}
