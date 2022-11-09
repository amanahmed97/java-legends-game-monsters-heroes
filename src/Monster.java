import java.io.*;
import java.util.*;

public class Monster {
    String name;
    int level;
    int HP;
    int damage;
    int defense;
    int dodge;

    public static ArrayList<Monster> monsterList;
    public static ArrayList<Monster> spawnMonsters;

    public Monster(String name, int level, int damage, int defense, int dodge) {
        this.name = name;
        this.level = level;
        this.HP= level*100;
        this.damage = damage;
        this.defense = defense;
        this.dodge = dodge;

    }

    public static void populate() throws IOException {
        monsterList = new ArrayList<Monster>();
        populateDragons();
        populateExoskeletons();
        populateSpirits();
    }

    public static void populateDragons() throws IOException {
        String line;
        int ctr = 0;
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        // Parse the file
        File file = new File("./src/gamelib/Dragons.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            String sp = "\\s+";
            String[] iarray = line.split(sp);

            // Skip the first header line
            if (ctr == 0 || iarray.length < 7) {
                ctr++;
                continue;
            }

            monsterList.add(new Monster("Dragon " + iarray[0], Integer.parseInt(iarray[1]), Integer.parseInt(iarray[2]), Integer.parseInt(iarray[3]),
                    Integer.parseInt(iarray[4]) ) );
            ctr++;
        }

    }

    public static void populateExoskeletons() throws IOException {

        String line;
        int ctr = 0;

        // Parse the file
        File file = new File("./src/gamelib/Exoskeletons.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            String sp = "\\s+";
            String[] iarray = line.split(sp);
            // Skip the first header line
            if (ctr == 0 || iarray.length < 5) {
                ctr++;
                continue;
            }
            monsterList.add(new Monster("Exoskeleton " + iarray[0], Integer.parseInt(iarray[1]), Integer.parseInt(iarray[2]), Integer.parseInt(iarray[3]),
                    Integer.parseInt(iarray[4]) ) );
            ctr++;
        }

    }

    public static void populateSpirits() throws IOException {

        String line;
        int ctr = 0;

        // Parse the file
        File file = new File("./src/gamelib/Spirits.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            String sp = "\\s+";
            String[] iarray = line.split(sp);
            // Skip the first header line
            if (ctr == 0 || iarray.length < 4) {
                ctr++;
                continue;
            }

            monsterList.add(new Monster("Spirit " + iarray[0], Integer.parseInt(iarray[1]), Integer.parseInt(iarray[2]), Integer.parseInt(iarray[3]),
                    Integer.parseInt(iarray[4]) ) );
            ctr++;
        }
    }

    public static void printMonsterList() {
        System.out.println("Headers : Name / level / damage / defense / dodge chance");
        for (int j = 0; j < monsterList.size(); j++) {
            Monster monster = monsterList.get(j);
            System.out.println("[" + (j + 1) + "] " + monster.name + "  " + monster.level + "  " + monster.damage + "  " + monster.defense + "  " + monster.dodge);
        }
    }

    public static boolean spawnMonsters(){
        spawnMonsters = new ArrayList<Monster>();
        ArrayList<Integer> selected = new ArrayList<Integer>();

        for(int i=0; i<RunGame.numberHeroes; i++){
            int randomSelector = 
        }

        return true;
    }

}
