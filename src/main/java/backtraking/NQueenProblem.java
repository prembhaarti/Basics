package backtraking;

public class NQueenProblem {
  public static void main(String[] args) {
    int q = 4;
    int[][] board = new int[q][q];
    Boolean result = solveNQueen(board, 0);
    if (result==true){
      displayMatrix(board);
    }
    System.out.println(result);
  }
  private static void displayMatrix(int[][] palin) {
    for (int i = 0; i < palin.length; i++) {
      for (int j = 0; j < palin[0].length; j++) {
        System.out.print(palin[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static Boolean solveNQueen(int[][] board, int col) {
    if (col >= board.length)
      return true;

    for (int j = 0; j < board.length; j++) {
      if (isSafe(board, j, col)) {
        board[j][col] = 1;
        if (solveNQueen(board, col + 1))
          return true;

        board[j][col] = 0;
      }
    }
    return false;
  }

  private static boolean isSafe(int[][] board, int j, int col) {
    for (int i = 0; i <= col; i++) {
      if (board[j][i] == 1)
        return false;
    }
    for (int i = j, k = col; i >= 0 && k >= 0; i--, k--) {
      if (board[i][k]==1)
        return false;
    }
    for (int i = j, k = col; i < board.length && k >= 0; i++, k--) {
      if (board[i][k]==1)
        return false;
    }
    return true;
  }
}
