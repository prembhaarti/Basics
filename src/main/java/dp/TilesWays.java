package dp;

/**
 * given 2XW width tiles
 * we need to tell how many ways it can be arranged.
 *
 * i.e
 * -----------------------------------------
 * |      |       |       |       |         |
 * -----------------------------------------
 * |      |       |       |       |         |
 * -----------------------------------------
 *
 * tiles can be place horizontally or vertically.
 */
public class TilesWays {

  public int noOfWaysTilesCanArranged(int width){
    int count[]= new int[width];
    if(width<0) {
      return 0;
    }
    //pre-populating
    count[0]=1;
    count[1]=2;
    if(width==1){
      return count[0];
    }
    if(width==2){
      return count[1];
    }
    for(int i=2;i<width;i++){
      count[i]=count[i-1]+count[i-2];
    }
    return count[width-1];
  }

  public static void main(String[] args) {
    TilesWays tilesWays=new TilesWays();
    System.out.println(tilesWays.noOfWaysTilesCanArranged(5));
  }

}
