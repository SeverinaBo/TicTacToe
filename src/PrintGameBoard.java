public class PrintGameBoard {


    public static final char[][] GAME_BOARD_TEMPLATE = {{' ', '|', ' ', '|', ' ' },
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};


    public static void printGameBoard ( char[][] GAME_BOARD_TEMPLATE){
        for (char[] row : GAME_BOARD_TEMPLATE) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
