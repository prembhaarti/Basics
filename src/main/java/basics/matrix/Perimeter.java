package basics.matrix;

/**
 * Given basics.matrix:
 * find perimeter to cover overall crop :ie 1 is crop
 *
 * start to traverse basics.matrix
 *
 * if found 1 -> find connected ie. 1 in up, down, left, right
 * then it fence = 4-connected components
 *
 * keep adding each fence perimeter and return
 *
 */
public class Perimeter {
  public static void main(String[] args) {

    int [][] matrix={
        {0,0,0,0},
        {1,1,0,0},
        {1,1,0,0},
        {1,1,0,0}
    };

    Perimeter perimeter= new Perimeter();
    System.out.println(perimeter.getPerimeter(matrix));
  }

  public int getPerimeter(int[][] matrix){
    int perimeter=0;
    for(int j=0;j<matrix.length;j++){
      for(int i=0;i<matrix[0].length;i++){
        if(matrix[j][i]==1){
          perimeter+=4-getConnected(matrix,j,i);
        }
      }
    }
    return perimeter;
  }

  public int getConnected(int[][] matrix,int j, int i){
    int [] rows = {-1,0,0,1};
    int [] cols = {0,-1,1,0};

    int connected=0;
    for(int k=0;k<rows.length;k++){
      if(isValid(matrix, j+rows[k],i+cols[k]) && matrix[j+rows[k]][i+cols[k]]==1){
        connected++;
      }
    }
    return connected;
  }

  public boolean isValid(int[][] matrix,int j, int i){
    return j>=0 && j<matrix.length && i>=0 && i<matrix[0].length;
  }
}