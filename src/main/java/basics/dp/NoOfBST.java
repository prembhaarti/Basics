package basics.dp;

public class NoOfBST {

  /**
   *
   *                   (2n)!
   *  Catalan's No = __________
   *                 (n+1)!(n)!
   *   (n=3)  ->      6!
   *                _____ = 5
   *                4!3!
   *
   */
  private int[] countCache;
  public NoOfBST(){
  }

  public static void main(String[] args) {
    NoOfBST bst = new NoOfBST();
    System.out.println(bst.getNoOfBSTs(3));
  }
  public int getNoOfBSTs(int no){
    countCache = new int[no+1];
    countCache[0]=1;
    countCache[1]=1;

    for(int j=2;j<=no;j++){
      for(int i=0;i<j;i++){

        countCache[j]+= countCache[i]* countCache[j-i-1];

      }
    }
    return countCache[no];
  }
}
