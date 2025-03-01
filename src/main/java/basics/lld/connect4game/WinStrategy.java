package basics.lld.connect4game;

public class WinStrategy {
    private final int rows;
    private final int cols;
    private final char[][] grid;


    public WinStrategy(int rows, int cols, char[][] grid) {
        this.rows = rows;
        this.cols = cols;
        this.grid = grid;
    }

    public boolean checkWin(char disc) {
        // Check all directions: horizontal, vertical, and two diagonals
        return checkHorizontal(disc) || checkVertical(disc) || checkDiagonal(disc);
    }

    private boolean checkHorizontal(char disc) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <= cols - 4; col++) {
                if (grid[row][col] == disc && grid[row][col + 1] == disc &&
                        grid[row][col + 2] == disc && grid[row][col + 3] == disc) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVertical(char disc) {
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row <= rows - 4; row++) {
                if (grid[row][col] == disc && grid[row + 1][col] == disc &&
                        grid[row + 2][col] == disc && grid[row + 3][col] == disc) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal(char disc) {
        for (int row = 0; row <= rows - 4; row++) {
            for (int col = 0; col <= cols - 4; col++) {
                if (grid[row][col] == disc && grid[row + 1][col + 1] == disc &&
                        grid[row + 2][col + 2] == disc && grid[row + 3][col + 3] == disc) {
                    return true;
                }
            }
        }
        for (int row = 3; row < rows; row++) {
            for (int col = 0; col <= cols - 4; col++) {
                if (grid[row][col] == disc && grid[row - 1][col + 1] == disc &&
                        grid[row - 2][col + 2] == disc && grid[row - 3][col + 3] == disc) {
                    return true;
                }
            }
        }
        return false;
    }

}
