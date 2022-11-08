public class Board {
    int rows;
    int columns;
    public static int dimension;

    public Board(int r, int c) {
        rows = r;
        columns = c;
        dimension = r;
    }

    BoardMarker[][] BoardMap;

    public Board(int n) {
        dimension = n;
        dimension = n;
        dimension=n;
        BoardMap = new BoardMarker[n][n];
        for (int i = 0; i < n; i++) {
            for (int j=0; j<n; j++)
                BoardMap[i][j] = new BoardMarker(i*n+j);
        }
    }

    public void printBoard() {

        for (int i = 0; i < dimension; i++) {

            for (int k = 0; k < dimension; k++) {
//                if (dimension * dimension > 9) System.out.print("+----");
//                else
                System.out.print("+-----");
            }
            System.out.print("+\n");

            for (int j = 0; j < dimension; j++) {
                if (BoardMap[i][j].symbol == '-')
                    System.out.print("|   ");
                else
                System.out.print("|  " + BoardMap[i][j].symbol);

//                if ((dimension * dimension > 9 && (i * dimension + j) < 9) || (dimension * dimension > 9 && BoardMap[i][j].symbol != '-'))
//                    System.out.print("   ");
//                else
                System.out.print("  ");
            }
            System.out.print("|\n");
        }
        //Last line pattern
        for (int i = 1; i <= dimension; i++) {
//            if (dimension * dimension > 9) System.out.print("+----");
//            else
            System.out.print("+-----");
        }
        System.out.print("+\n");
    }

    public int setBoard(int xpos, int ypos, char symbol) {
        BoardMap[xpos][ypos].symbol = symbol;
        return BoardMap[xpos][ypos].position;
    }

    public int getBoardSymbol(int xpos, int ypos) {
        return BoardMap[xpos][ypos].symbol;
    }

    public static boolean validPosition(int newXPosition, int newYPosition){
        if( newXPosition<0 || newYPosition<0 || newXPosition>dimension || newYPosition>dimension ) {
            System.out.println("Invalid move.");
            return false;
        }

        return true;
    }

}
