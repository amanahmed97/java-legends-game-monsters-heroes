import java.io.*;
import java.util.*;

public class Market {

    public static void enterMarket(){

        System.out.println("=====================\n"+"WELCOME TO THE MARKET\n"+"=====================\n");

        int mOption = 0;
        Scanner ip = new Scanner(System.in);

        // Market Menu
        System.out.println("OPTIONS:\n1. BUY \n2. SELL \n3.EXIT");

        try{
            System.out.print("Enter : ");
            mOption = ip.nextInt();
        }catch (Exception e){
            System.out.println("Enter valid option.");
            mOption = 0;
        }

        switch (mOption){
            case 1:
                buyMarket();
                break;
            case 2:
                sellMarket();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid option");
                break;
        }

    }

    public static void buyMarket(){
        System.out.println("SELL MENU\n========");

        int buyOption = 0;
        Scanner ip = new Scanner(System.in);

        // Buy Menu
        System.out.println("SELL ITEMS:\n1. WEAPONRY \n2. ARMORY \n3.POTIONS \n4.SPELLS \n5.RETURN");

        try{
            System.out.print("Enter : ");
            buyOption = ip.nextInt();
        }catch (Exception e){
            System.out.println("Enter valid option.");
            buyOption = 0;
        }

        int hero = Player.selectHero();

        switch (buyOption){
            case 1:
                Weapons.buyWeapons(hero);
                break;
            case 2:
                Armory.buyArmory(hero);
                break;
            case 3:
                Potions.buyPotions(hero);
                break;
            case 4:
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid option");
                break;
        }

    }

    public static void sellMarket(){
        System.out.println("BUY MENU\n========");

        int buyOption = 0;
        Scanner ip = new Scanner(System.in);

        // Buy Menu
        System.out.println("BUY ITEMS:\n1. WEAPONRY \n2. ARMORY \n3.POTIONS \n4.SPELLS \n5.RETURN");

        try{
            System.out.print("Enter : ");
            buyOption = ip.nextInt();
        }catch (Exception e){
            System.out.println("Enter valid option.");
            buyOption = 0;
        }

        int hero = Player.selectHero();

        switch (buyOption){
            case 1:
                Weapons.sellWeapons(hero);
                break;
            case 2:
                Armory.sellArmory(hero);
                break;
            case 3:
                Potions.sellPotions(hero);
                break;
            case 4:
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid option");
                break;
        }

    }

}
