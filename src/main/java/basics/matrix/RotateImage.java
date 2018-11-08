package basics.matrix;

import basics.util.CodeUtil;

public class RotateImage {

  static int[][] matrix=
          {
                  {1, 2, 3, 4},
                  {5, 6, 7, 8},
                  {9,10,11,12},
                  {13,14,15,16}

          };

  public static void rotateMatrixBy90(int[][] matrix) {
    if(matrix!=null && matrix.length!=0){
      diagonalTranspose(matrix);
      horizontalTranspose(matrix);
    }
  }

  public static void diagonalTranspose(int[][] matrix) {
    for(int j=0;j<matrix.length;j++) {
      for(int i=0;i<j;i++) {
        int temp=matrix[j][i];
        matrix[j][i]=matrix[i][j];
        matrix[i][j]=temp;
      }
    }
  }

  public static void horizontalTranspose(int[][] matrix) {
    for(int j=0;j<matrix.length/2;j++) {
      for(int i=0;i<matrix.length;i++) {
        int temp=matrix[j][i];
        matrix[j][i]=matrix[matrix.length-1-j][i];
        matrix[matrix.length-1-j][i]=temp;
      }
    }
  }

  public static void main(String[] args) {
    CodeUtil.display2dMatrix(matrix);
    rotateMatrixBy90(matrix);
    System.out.println();
    CodeUtil.display2dMatrix(matrix);
  }

  public void rotate(int[][] matrix) {
    int rowPos=matrix.length-1;
    int colPos=matrix[0].length-1;

    for(int j=0;j<=matrix.length/2;j++) {
      for(int i=0;i<matrix[0].length-1;i++) {
        int temp=matrix[i][colPos-j];
        matrix[i][colPos-j]=matrix[j][i];
        temp=matrix[rowPos-j][colPos-i];

      }
    }
  }
}