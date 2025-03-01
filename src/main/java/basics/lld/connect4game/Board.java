package basics.lld.connect4game;

import java.util.Arrays;

public class Board {

    private static final Board board = new Board();

    private final int rows = 6;
    private final int cols = 7;
    private final char[][] grid;
    private final char EMPTY_SLOT = '.';

    private static final WinStrategy winStrategy = new WinStrategy(board.rows, board.cols, board.grid);

    private Board() {
        grid = new char[rows][cols];
        for (char[] row : grid) {
            Arrays.fill(row, EMPTY_SLOT);
        }
    }

    public boolean dropDisc(int col, char disc) {
        if (col < 0 || col >= cols || grid[0][col] != EMPTY_SLOT) {
            return false; // Invalid move
        }
        for (int row = rows - 1; row >= 0; row--) {
            if (grid[row][col] == EMPTY_SLOT) {
                grid[row][col] = disc;
                return true;
            }
        }
        return false;
    }

    public boolean checkWin(char disc) {
        return winStrategy.checkWin(disc);
    }

    public boolean isFull() {
        for (int col = 0; col < cols; col++) {
            if (grid[0][col] == EMPTY_SLOT) {
                return false;
            }
        }
        return true;
    }

    public void displayBoard() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static Board getInstance() {
        return board;
    }

}
