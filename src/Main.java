import java.util.*;

public class Main {

    static List<Integer> playerPositions = new ArrayList<>();
    static List<Integer> cpuPositions = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("/// LET'S PLAY! ///");
        System.out.println("Enter a number 1-9 to place a piece on the corresponding tile.");
        System.out.println("Use your wits to beat the CPU!");

        char[][] tttBoard = new char[][]{
                {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '},
                {'-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-'},
                {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '},
                {'-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-'},
                {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '}};

        createBoard(tttBoard);

        while (true) {

            System.out.print("PLAYER'S TURN: ");
            Scanner scan = new Scanner(System.in);
            int playerPosition = scan.nextInt();

            while (playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)) {
                System.out.println("Position taken! Pick an open space from 1-9.");
                playerPosition = scan.nextInt();
            }

            if (playerPosition < 1 || playerPosition > 9) {
                do {
                    System.out.println("Not a valid move! Pick an open space from 1-9.");
                    scan = new Scanner(System.in);
                    playerPosition = scan.nextInt();
                }
                while (playerPosition < 1 || playerPosition > 9);
            }

            boolean gameInProgress = true;

            makeMove(tttBoard, playerPosition, "player");
            createBoard(tttBoard);

            String won = checkWinner();
            if (won.length() > 0) {
                System.out.println(won);
                gameInProgress = false;
                break;
            }

            if (gameInProgress == true) {

                Random rand = new Random();
                int cpuPosition = rand.nextInt(9) + 1;
                while (playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition)) {
                    cpuPosition = rand.nextInt(9) + 1;
                }

                makeMove(tttBoard, cpuPosition, "cpu");
                createBoard(tttBoard);

                won = checkWinner();
                if (won.length() > 0) {
                    System.out.println(won);
                    break;
                }
            }

        }
    }

    public static void createBoard(char[][] tttBoard) {
        for (char[] row : tttBoard) {
            for (char c : row)
                System.out.print(c);
            System.out.println();
        }
    }

    public static void makeMove(char[][] tttBoard, int position, String user) {
        char symbol = ' ';

        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(position);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(position);
            System.out.println("CPU'S TURN: " + position);
        }

        switch (position) {
            case 1:
                tttBoard[0][2] = symbol;
                break;
            case 2:
                tttBoard[0][8] = symbol;
                break;
            case 3:
                tttBoard[0][14] = symbol;
                break;
            case 4:
                tttBoard[2][2] = symbol;
                break;
            case 5:
                tttBoard[2][8] = symbol;
                break;
            case 6:
                tttBoard[2][14] = symbol;
                break;
            case 7:
                tttBoard[4][2] = symbol;
                break;
            case 8:
                tttBoard[4][8] = symbol;
                break;
            case 9:
                tttBoard[4][14] = symbol;
                break;
            default:
                System.out.println("Not a valid move! Pick an open space from 1-9.");
        }
    }

    public static String checkWinner() {

        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> diagonal1 = Arrays.asList(1, 5, 9);
        List<Integer> diagonal2 = Arrays.asList(3, 5, 7);

        List<List> winConditions = new ArrayList<List>();

        winConditions.add(topRow);
        winConditions.add(midRow);
        winConditions.add(botRow);
        winConditions.add(leftCol);
        winConditions.add(midCol);
        winConditions.add(rightCol);
        winConditions.add(diagonal1);
        winConditions.add(diagonal2);

        for (List condition : winConditions) {
            if (playerPositions.containsAll(condition) ||
                    (playerPositions.size() + cpuPositions.size() == 9) && playerPositions.containsAll(condition)) {
                return "CONGRATULATIONS! YOU'VE WON!";
            } else if (cpuPositions.containsAll(condition) ||
                    (playerPositions.size() + cpuPositions.size() == 9) && cpuPositions.containsAll(condition)) {
                return "CPU HAS WON. GAME OVER.";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "TIE! TRY AGAIN.";
            }
        }
        return "";
    }

}

