package dp;

/**
 * you are given option of taking 1 or 2 steps at once.
 *
 * You have to reach to the top, then how many different ways you can reach up to top
 */
public class ClimbStairs {

  /**
   * problem is like fibonacci number
   *
   *  f(n) = f(n-1)+f(n-2)   :: n>=2   n(0)->1 , n(1)->2
   */
    public int count(int n, int k){
      int[] stepsCount = new int[n];
      stepsCount[0]=1;
      stepsCount[1]=2;

      for(int i=2;i<n;i++) {
        stepsCount[i]=stepsCount[i-2]+stepsCount[i-1];
      }

      return stepsCount[n-1];
    }

  public static void main(String[] args) {
    ClimbStairs cs= new ClimbStairs();
    System.out.println(cs.count(4, 2));
  }

}
