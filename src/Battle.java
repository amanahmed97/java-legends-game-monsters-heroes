import java.io.*;
import java.util.*;

public class Battle {
    public static int battleRound=0;
    public static int attackTurn=1;

    public void enterBattle(){
        battleRound=1;
        System.out.println("\n======\n"+"BATTLE"+"\n======");
        // todo condition check
        Scanner ip = new Scanner(System.in);
        Monster.spawnMonsters();

        while(true){
            System.out.println("ROUND "+battleRound+"\n========="+"\nSTATS\n=====");
            HeroType.printHeroList();
            Monster.printSpawnMonsters();

            switch(attackTurn){
                case 1:
                    heroTurn();
                    attackTurn=2;
                    break;
                case 2:
                    Monster.monsterTurn();
                    attackTurn=1;
                    break;
            }

            battleRound++;
        }
    }

    public boolean heroTurn(){
        System.out.println("HERO TURN"+"\n=========");

        for (int i=0; i < RunGame.numberHeroes; i++){

            if(Player.heroes.get(i).HP <= 0)
                continue;

            heroOptions(i);
        }

        return true;
    }

    public boolean heroOptions(int heroSelect){
        int heroOption=0;
        HeroType hero = Player.heroes.get(heroSelect);
        Scanner ip = new Scanner(System.in);

        System.out.println("HERO : "+hero.name+"  HP : "+hero.HP);

        System.out.println("HERO SELECT:\n"+"[1] Attack\n"+"[2] Cast spell\n"+"[3] Use potion\n"
                +"[4] Equip Weapon\n"+"[5] Equip Armor\n"+"[6] Exit\n");

        try{
            heroOption = ip.nextInt();
        }catch (Exception e){
            System.out.println("Enter valid option.");
            heroOption = 0;
        }

        switch(heroOption){
            case 1:
                // Attack weapon
                hero.attack();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                // equip weapon
                hero.equipWeapon(heroSelect);
                break;
            case 5:
                hero.equipArmor(heroSelect);
                break;
            case 6:
                System.out.println("\n=======================================\n");
                System.out.println("Thank You for playing!!\nSee you soon!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }

        return true;
    }

}
