import java.io.IOException;
import java.util.*;

public class RunGameMain {

    public static void runGameMenu() throws IOException {

        //Initialize the objects of the game
        Scanner ip = new Scanner(System.in);
        int option = 0;

        // Input for the game
        System.out.print("\nWelcome to the Java Legends game!!!");
        System.out.println("\n=======================================\nLEGENDS - HEROES AND MONSTERS");


        // Game Menu
        while (true) {
            System.out.println("\n=======================================\n");
            System.out.println("\nGame Menu:\n1.Play Game \n2.Scores\n3.Exit");
            System.out.print("Enter:");

            try {
                option = ip.nextInt();
            } catch (Exception e) {
                // Flush the input token, to ask input again
                ip.next();
                option=0;
            }

            switch (option) {
                case 1:
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
                    System.out.println("Invalid option. Try again.");
            }

        }

    }

}
