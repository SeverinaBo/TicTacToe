import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> computerPositions = new ArrayList<>();
    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your placement (1-9):");

            int playerPos = scanner.nextInt();
            while (playerPositions.contains(playerPos) || computerPositions.contains(playerPos)) {
                System.out.println("Position taken...enter a correct position");
                playerPos = scanner.nextInt();
            }

            placePiece(gameBoard, playerPos, "player");


            String result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
            //could use AI for this randomiser

            Random random = new Random();
            int cpPosition = random.nextInt(9) + 1;
            while (playerPositions.contains(cpPosition) || computerPositions.contains(cpPosition)) {
                cpPosition = random.nextInt(9) + 1;
            }

            placePiece(gameBoard, cpPosition, "computer");

            printGameBoard(gameBoard);

            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
        }

    }
        public static void printGameBoard ( char[][] gameBoard){
            for (char[] row : gameBoard) {
                for (char c : row) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
        public static void placePiece ( char[][] gameBoard, int position, String user){
            char symbol = ' ';
            if (user.equals("player")) {
                symbol = 'X';
                playerPositions.add(position);
            } else if (user.equals("computer")) {
                symbol = 'O';
                computerPositions.add(position);
            }

            switch (position) {
                case 1 -> gameBoard[0][0] = symbol;
                case 2 -> gameBoard[0][2] = symbol;
                case 3 -> gameBoard[0][4] = symbol;
                case 4 -> gameBoard[2][0] = symbol;
                case 5 -> gameBoard[2][2] = symbol;
                case 6 -> gameBoard[2][4] = symbol;
                case 7 -> gameBoard[4][0] = symbol;
                case 8 -> gameBoard[4][2] = symbol;
                case 9 -> gameBoard[4][4] = symbol;
                default -> {
                }
            }
        }

public static String checkWinner() {
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);

        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);

        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> winningConditions = new ArrayList<>();

        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(botRow);

        winningConditions.add(leftCol);
        winningConditions.add(midCol);
        winningConditions.add(rightCol);

        winningConditions.add(cross1);
        winningConditions.add(cross2);

        for (List l : winningConditions) {
            if (playerPositions.containsAll(l)) {
                return "Congratulations you won!";
            } else if (computerPositions.containsAll(l)) {
                return "Computer Wins";
            }
        }

        if (playerPositions.size() + computerPositions.size() == 9) {
                return "You are equally smart";
            }

        return "";


}}
