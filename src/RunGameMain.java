import java.util.*;

public class RunGameMain {
    public static Board board;
    public static int numberHeroes = 2;
    public static Player[] players;

    public static void runGameMenu(){

        //Initialize the objects of the game
        Scanner ip = new Scanner(System.in);
        int option = 0;

        // Input for the game
        System.out.print("\nWelcome to the Java Legends game!!!");
        System.out.println("\n=======================================\n");

        numberHeroes = Player.getNumberHeroes();
        players = Player.playerSet(numberHeroes);

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
                    System.out.println("\n=======================================\n");
                    System.out.println("\nLegends - Monsters and Heroes");
//                    RulesTicTacToe.printRules();
                    System.out.print("Choose Board size : ");
                    int size = 8;
                    try {
                        size = ip.nextInt();
                        if (size < 8 || size > 100) throw new Exception("Out of valid range");
                    } catch (InputMismatchException e) {
                        ip.next();
                        System.out.println("Enter valid board size.");
                        break;
                    } catch (Exception e) {
                        System.out.println(e.toString() + "\nEnter valid board size.");
                        break;
                    }

                    board = new Board(size);
                    board.printBoard(); // todo remove
//                    RunGame.runGame();
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
