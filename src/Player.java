import java.io.IOException;
import java.util.*;

class Player {
    String name;
    int team = 0;
    int score = 0;
    String playerMarker;
    int xPosition = 0;
    int yPosition = 0;
    public static ArrayList<HeroType> heroes;

    public Player(String name, int team) {
        this.name = name;
        this.team = team;
        this.xPosition = 0;
        this.yPosition = 0;
        RunGame.board.setBoard(this.xPosition, this.yPosition, 'H');
        heroes = new ArrayList<HeroType>();
    }

    public Player(String name, int team, String playerMarker) {
        this.name = name;
        this.team = team;
        this.playerMarker = playerMarker;
        this.xPosition = 0;
        this.yPosition = 0;
        RunGame.board.setBoard(this.xPosition, this.yPosition, 'H');
        heroes = new ArrayList<HeroType>();
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
        int numberHeroes = 1;
        Scanner ip = new Scanner(System.in);

        System.out.print("Enter number of heroes to play - Max 3 : ");
        try {
            numberHeroes = ip.nextInt();
            while (numberHeroes<1 || numberHeroes>3) {
                System.out.println("Enter value between 1 to 3 : ");
                numberHeroes = ip.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Enter valid value.");
            numberHeroes = getNumberHeroes();
        }

        return numberHeroes;
    }

    public static void heroSet(int numberHeroes) throws IOException {
        HeroType.populate();

        Scanner ip = new Scanner(System.in);
        int heroSelect=0;

        for (int i = 0; i < numberHeroes; i++) {
            // Player Information input
            System.out.println("Choose Hero " + (i + 1) + " :");
            HeroType.printHeroList();
            System.out.print("Enter Hero Number : ");
            try {
                heroSelect = ip.nextInt();

                while(heroSelect<1 || heroSelect>HeroType.heroList.size()){
                    System.out.println("Input valid Hero number : ");
                    heroSelect = ip.nextInt();
                }
                heroes.add(HeroType.heroList.get(heroSelect-1));

            }catch (Exception e){
                System.out.println("Select valid Hero number.");
                heroSet(numberHeroes);
            }
        }
        printHeroes();
    }

    public static void printHeroes(){
        System.out.println("Your Heroes : ");
        for (int i=0; i<heroes.size();i++)
            System.out.println("["+(i+1)+"] "+heroes.get(i).name);
    }

    public static int selectHero(){
        printHeroes();

        int heroSelect=0;
        Scanner ip = new Scanner(System.in);

        try {
            System.out.print("Enter selection : ");
            heroSelect = ip.nextInt();

            while(heroSelect<1 || heroSelect>heroes.size()){
                System.out.println("Input valid Hero number : ");
                heroSelect = ip.nextInt();
            }

        }catch (Exception e){
            System.out.println("Select valid Hero number.");
            heroSelect = selectHero()+1;
        }

        return heroSelect-1;
    }


}