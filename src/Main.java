import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[][] tttBoard = new char[][]{
                {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '},
                {'-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-'},
                {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '},
                {'-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-'},
                {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '}};

        createBoard(tttBoard);

        System.out.print("PLAYER'S TURN: ");
        Scanner scan = new Scanner(System.in);
        int position = scan.nextInt();

        if (position < 1 || position > 9) {
            do {
                System.out.println("Not a valid move! Pick an open space from 1-9.");
                scan = new Scanner(System.in);
                position = scan.nextInt();
            }
            while (position < 1 || position > 9);
        }

        switch (position) {
            case 1:
                tttBoard[0][2] = 'X';
                break;
            case 2:
                tttBoard[0][8] = 'X';
                break;
            case 3:
                tttBoard[0][14] = 'X';
                break;
            case 4:
                tttBoard[2][2] = 'X';
                break;
            case 5:
                tttBoard[2][8] = 'X';
                break;
            case 6:
                tttBoard[2][14] = 'X';
                break;
            case 7:
                tttBoard[4][2] = 'X';
                break;
            case 8:
                tttBoard[4][8] = 'X';
                break;
            case 9:
                tttBoard[4][14] = 'X';
                break;
            default:
                System.out.println("Not a valid move! Pick an open space from 1-9.");
        }

        createBoard(tttBoard);

    }

    public static void createBoard(char[][] tttBoard) {
        for (char[] row : tttBoard) {
            for (char c : row)
                System.out.print(c);
            System.out.println();
        }
    }


}

