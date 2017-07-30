package graph;

/**
 * given a friend circle matrix
 *
 *   a b c d
 *a {1,1,0,0},
 *b {1,1,1,0},
 *c {0,1,1,0},
 *d {0,0,0,1},
 *
 * where a is friend to b, b is friend to a and c, d is non to any friend
 *
 * find no. of friend circle.
 *
 * start to traverse the matrix
 *  if it's valid, pass to recursive method with matrix,row
 *  FriendCircleCount++;
 *
 *  recursive method
 *    create visited matrix
 *      start to traverse from row we got
 *        if it's valid
 *          set current position visited
 *          call recursively passing -> matrix,visited,col
 */
public class FriendCircle {

  public static void main(String[] args) {
    int[][] circle= {
        {1,1,0,0},
        {1,1,1,0},
        {0,1,1,0},
        {0,0,0,1},
    };

    FriendCircle fc= new FriendCircle();
    System.out.println(fc.noOfFriendCircle(circle));
  }

  public boolean isValid(int[][] circle,boolean[][] visited,int j, int i){
    return j<circle.length && j>=0 && i<circle[0].length && i>=0 && circle[j][i]==1 && !visited[j][i];
  }

  public int noOfFriendCircle(int[][] circle){
    boolean visited[][] = new boolean[circle.length][circle[0].length];
    int count=0;
    for(int j=0;j<circle.length;j++){
      for(int i=0;i<circle[0].length;i++) {
        if (isValid(circle, visited, j, i)) {
          visited[j][i] = true;
          count++;
          dfs(circle, visited, j);
        }
      }
    }
    return count;
  }

  public void dfs(int[][] circle,boolean[][] visited,int j){
      for(int i=0;i<circle[0].length;i++){
        if(isValid(circle,visited,j,i)){
          visited[j][i]=true;
          if(i!=j && !visited[i][j]){
            dfs(circle,visited,i);
          }
        }
      }
  }
}