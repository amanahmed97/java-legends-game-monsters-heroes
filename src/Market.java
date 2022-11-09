import java.io.*;
import java.util.*;

public class Market {

    public void enterMarket(){

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

    public void buyMarket(){
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
                Weapons.buyWeapons(hero);
                break;
            case 2:
                sellMarket();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid option");
                break;
        }

    }

}
