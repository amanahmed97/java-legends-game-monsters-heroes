import java.util.*;

class Player {
    String name;
    int team = 0;
    int score = 0;
    String playerMarker;
    int xPosition = 0;
    int yPosition = 0;

    public Player(String name, int team) {
        this.name = name;
        this.team = team;
        this.xPosition = 0;
        this.yPosition = 0;
        RunGame.board.setBoard(this.xPosition, this.yPosition, 'H');
    }

    public Player(String name, int team, String playerMarker) {
        this.name = name;
        this.team = team;
        this.playerMarker = playerMarker;
        this.xPosition = 0;
        this.yPosition = 0;
        RunGame.board.setBoard(this.xPosition, this.yPosition, 'H');
    }

    public int scoreUpdate(int s) {
        score += s;
        return score;
    }

    public int getScore() {
        return score;
    }

    public boolean setPosition(int xPosition, int yPosition){
        // Reset old position
        RunGame.board.setBoard(this.xPosition, this.yPosition, '-');
        // New position
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        RunGame.board.setBoard(this.xPosition, this.yPosition, 'H');

        return true;
    }

    public static int getNumberHeroes() {
        // Default set to 1 player Hero
        int numberPlayers = 1;
        Scanner ip = new Scanner(System.in);

        System.out.print("Enter number of heroes to play - Max 3 : ");
        try {
            numberPlayers = ip.nextInt();
            while (numberPlayers<1 || numberPlayers>3) {
                System.out.println("Enter value between 1 to 3 : ");
                numberPlayers = ip.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Enter valid value.");
            numberPlayers = getNumberHeroes();
        }

        return numberPlayers;
    }

    public static Player[] playerSet(int numberPlayers) {
        Scanner ip = new Scanner(System.in);
        Player[] players = new Player[numberPlayers];

        for (int i = 0; i < numberPlayers; i++) {
            // Player Information input
            System.out.println("Player " + (i + 1) + " :");
            System.out.print("Please enter your name:");
            players[i] = new Player(ip.nextLine(), i + 1);
            System.out.println("Hello " + players[i].name + "!\n");
        }

        return players;
    }
}