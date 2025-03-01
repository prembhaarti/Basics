package basics.lld.connect4game;

import java.util.Scanner;

public class ConnectFour {

    private final Board board;
    private Player currentPlayer;
    public ConnectFour() {

        board = Board.getInstance();
        currentPlayer = Player.RED;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            board.displayBoard();
            System.out.println(currentPlayer + "'s turn. Choose a column (0-6): ");
            int col = scanner.nextInt();

            char disc = (currentPlayer == Player.RED) ? 'R' : 'Y';
            if (!board.dropDisc(col, disc)) {
                System.out.println("Invalid move, try again.");
                continue;
            }

            if (board.checkWin(disc)) {
                board.displayBoard();
                System.out.println(currentPlayer + " wins!");
                gameOver = true;
                break;
            }

            if (board.isFull()) {
                board.displayBoard();
                System.out.println("Game ends in a draw!");
                break;
            }

            currentPlayer = (currentPlayer == Player.RED) ? Player.YELLOW : Player.RED;
        }
        scanner.close();
    }
}
