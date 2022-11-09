import java.io.*;
import java.util.*;

public class Battle {
    public static int battleRound=0;
    public static int attackTurn=1;

    public void enterBattle(){
        battleRound=1;
        System.out.println("\n======\n"+"BATTLE"+"\n======");

        Scanner ip = new Scanner(System.in);

        while(true){
            System.out.println("ROUND "+battleRound+"\n=========");

            switch(attackTurn){
                case 1:
                    heroTurn();
                    attackTurn=2;
                    break;
                case 2:
                    monsterTurn();
                    attackTurn=1;
                    break;
            }

            battleRound++;
        }
    }

    public boolean heroTurn(){
        System.out.println("HERO TURN"+"\n=========");

        for (int i=0; i < RunGame.numberHeroes; i++){

            if(Player.heroes.get(i).HP < 1)
                continue;

            System.out.println("HERO : "+Player.heroes.get(i).name);
            heroOptions(i);
        }

        return true;
    }

    public boolean heroOptions(int heroSelect){
        int heroOption=0;
        HeroType hero = Player.heroes.get(heroSelect);
        Scanner ip = new Scanner(System.in);

        System.out.println("HERO SELECT:\n"+"[1] Weapon attack\n"+"[2] Cast spell\n"+"[3] Use potion\n"
                +"[4] Equip Weapon\n"+"[5] Equip Armor\n");

        try{
            heroOption = ip.nextInt();
        }catch (Exception e){
            System.out.println("Enter valid option.");
            heroOption = 0;
        }

        switch(heroOption){
            case 1:
                // Attack weapon
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                // equip weapon
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }

        return true;
    }

}
