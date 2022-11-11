import java.util.*;
import java.io.*;

public class RunGame {
    public static Board board;
    public static int numberHeroes = 1;
    public static Player player;

    public static void runGame() throws IOException {
        // Setting up game variables
        Scanner ip = new Scanner(System.in);
        char gameInput=0;
        int gameTurn = 1;
        boolean gameCheck = false;
        int newXPosition;
        int newYPosition;

        System.out.println("Starting game");
        setupGame();

        while (true) {
            System.out.println("\n=================================================\n");
            System.out.println("\nGame Turn " + gameTurn);
            board.printBoard();

            System.out.println("\nMovement: w - Move Up, s - Move Down, a - Move Left, d - Move Right");
            System.out.println("Actions: i - info, m - Enter Market, q - Quit");
            System.out.print("Enter: ");


            try {
                gameInput = ip.next().charAt(0);
                gameInput = Character.toLowerCase(gameInput);

            } catch (Exception e) {
                // Flush the input token, to ask input again
//                ip.next();
                gameInput=0;
                System.out.println("Enter valid option.");
            }

            switch (gameInput) {
                case 'w':
                    newXPosition = player.xPosition-1;
                    if (Board.validPosition(newXPosition, player.yPosition))
                        player.setPosition(newXPosition, player.yPosition);
                    break;
                case 'a':
                    newYPosition = player.yPosition-1;
                    if (Board.validPosition(player.xPosition, newYPosition))
                        player.setPosition(player.xPosition, newYPosition);
                    break;
                case 's':
                    newXPosition = player.xPosition+1;
                    if (Board.validPosition(newXPosition, player.yPosition))
                        player.setPosition(newXPosition, player.yPosition);
                    break;
                case 'd':
                    newYPosition = player.yPosition+1;
                    if (Board.validPosition(player.xPosition, newYPosition))
                        player.setPosition(player.xPosition, newYPosition);
                    break;
                case 'i':
                    break;
                case 'm':
                    Market.enterMarket();
                    Battle.enterBattle(); //todo remove
                    break;
                case 'q':
                    System.out.println("\n=======================================\n");
                    System.out.println("Thank You for playing!!\nSee you soon!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid gameInput. Try again.");
            }

            gameTurn++;
        }
    }

    public static void setupGame() throws IOException {
        // Setup Game variables
        Scanner ip = new Scanner(System.in);
        System.out.println("\n=======================================\n");
        System.out.println("\nLegends - Monsters and Heroes");
//                    GameRules.printRules();
        System.out.print("Choose Board size : ");
        int size = 8;
        try {
            size = ip.nextInt();
            if (size < 8 || size > 100) throw new Exception("Out of valid range");
        } catch (InputMismatchException e) {
            ip.next();
            System.out.println("Enter valid board size.");
//            break;
        } catch (Exception e) {
            System.out.println(e.toString() + "\nEnter valid board size.");
//            break;
        }

        board = new Board(size);
        numberHeroes = Player.getNumberHeroes();
        player = new Player("Yours Truly",1);
        Player.heroSet(numberHeroes);
        Weapons.populate();
        Armory.populate();
        Potions.populate();
        Spells.populate();
        Monster.populate();
    }
}
