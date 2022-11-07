import java.util.*;
import java.io.*;

public class RunGame {

    public static void runGame(){
        Scanner ip = new Scanner(System.in);
        int gameOption=0;
        
        while (true) {
            System.out.println("\n=======================================\n");
            System.out.println("\nGame Menu:\n1.Play Game \n2.Scores\n3.Exit");
            System.out.print("Enter:");

            try {
                gameOption = ip.nextInt();
            } catch (Exception e) {
                // Flush the input token, to ask input again
                ip.next();
                gameOption=0;
            }

            switch (gameOption) {
                case 1:
                    System.out.println("\n=======================================\n");
                    System.out.println("\nTic Tac Toe");
//                    RulesTicTacToe.printRules();
                    System.out.print("Choose Board size : ");
                    int size = 3;
                    try {
                        size = ip.nextInt();
                        if (size < 3 || size > 1000) throw new Exception("Out of valid range");
                    } catch (InputMismatchException e) {
                        ip.next();
                        System.out.println("Enter valid board size.");
                        break;
                    } catch (Exception e) {
                        System.out.println(e.toString() + "\nEnter valid board size.");
                        break;
                    }

                    RunGameMain.board = new Board(size);
                    RunGame.runGame();
                    break;
                case 2:
                    System.out.println("\n=======================================\n");
//                    PlayerScore.printScore(numberHeroes, players);
                    break;
                case 3:
                    System.out.println("\n=======================================\n");
                    System.out.println("Thank You for playing!!\nSee you soon!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid gameOption. Try again.");
            }

        }
    }
}
