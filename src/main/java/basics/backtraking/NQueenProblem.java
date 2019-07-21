package basics.backtraking;

public class NQueenProblem {

  public static void main(String[] args) {
    int boardSize = 4;
    int[][] board = new int[boardSize][boardSize];
    Boolean result = solveNQueen(board, 0);
    if (result==true){
      displayMatrix(board);
    }
    System.out.println(result);
  }

  private static Boolean solveNQueen(int[][] board, int col) {
    if (col >= board.length) //breakpoint when column goes beyond board length
      return true;
    //traverse each column one by one for each row start from zero
    for (int row = 0; row < board.length; row++) {//iterate all rows
      if (isSafe(board, row, col)) {
        board[row][col] = 1;
        if (solveNQueen(board, col + 1)) {
          return true;
        }

        board[row][col] = 0;
      }
    }
    return false;
  }

  private static boolean isSafe(int[][] board, int row, int col) {
    for (int i = 0; i <= col; i++) {//check for this row all columns from zero col -->
      if (board[row][i] == 1)
        return false;
    }
    for (int i = row, k = col; i >= 0 && k >= 0; i--, k--) {//diagonal current to top left most
      if (board[i][k]==1)
        return false;
    }
    for (int i = row, k = col; i < board.length && k >= 0; i++, k--) {//diagonal current to bottom left most
      if (board[i][k]==1)
        return false;
    }
    return true;
  }


  private static void displayMatrix(int[][] palin) {
    for (int i = 0; i < palin.length; i++) {
      for (int j = 0; j < palin[0].length; j++) {
        System.out.print(palin[i][j] + " ");
      }
      System.out.println();
    }
  }
}
