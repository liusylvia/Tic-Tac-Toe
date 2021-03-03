public class Main {

    public static void main(String[] args) {

        char[][] tttBoard = new char[][]{
                {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '},
                {'-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-'},
                {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '},
                {'-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-'},
                {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '}};

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

