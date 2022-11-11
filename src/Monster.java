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
        Random random = new Random();
        //todo scale level
        for(int i=0; i<RunGame.numberHeroes; i++){
            int randomSelector = random.nextInt(monsterList.size());
            if ( !selected.contains(randomSelector) ) {
                spawnMonsters.add(monsterList.get(randomSelector));
                selected.add(randomSelector);
            }
        }

        return true;
    }

    public static void printSpawnMonsters() {
        System.out.println("Headers : Name / level / damage / defense / dodge chance");
        for (int j = 0; j < spawnMonsters.size(); j++) {
            Monster monster = spawnMonsters.get(j);
            System.out.println("[" + (j + 1) + "] " + monster.name + "  " + monster.level + "  " + monster.damage + "  " + monster.defense + "  " + monster.dodge);
        }
    }

    public static boolean monsterTurn(){
        Random random = new Random();

        for(int i=0; i<spawnMonsters.size(); i++){
            int randomSelector = random.nextInt(Player.heroes.size());

            if(Player.heroes.get(randomSelector).HP <= 0) {
                i--;
                continue;
            }

            HeroType hero = Player.heroes.get(randomSelector);
            // Check Hero agility to dodge
            double dodgeChance = hero.agility * 0.002;
            int randomDodge = random.nextInt(hero.agility);

            if ( randomDodge > dodgeChance ){
                // todo armor
                hero.HP -= spawnMonsters.get(i).damage;
                System.out.println("Monster "+spawnMonsters.get(i).name+" attacks Hero "+hero.name
                        +" for damage "+spawnMonsters.get(i).damage);
            }else{
                System.out.println("Hero "+hero.name+" dodged Monster attack");
            }

        }

        return true;
    }


}
