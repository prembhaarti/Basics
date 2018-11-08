package basics.dp;

import basics.util.CodeUtil;

/**
 * We have to buy and sell stocks :
 *
 * given stock prices each day:
 * prices = {2, 5, 7, 1, 4, 3, 1, 3}
 * nth day = 0  1  2  3  4  5  6  7
 *
 * we can purchase at nth day and sell after nth day
 *
 * We are allowed to do maximum k no. of transaction.
 *
 * Find maximum profit can be made using max k transaction by buying and selling stocks.
 */
public class StockBuyingProblem {

  /**
   * 1. profitIfnotDoneTransc-> go to left (day-1) (coz today transaction can lead to loss if done)
   *      first check if transaction not done on nth day then max profit was profit on n-1th day.
   * 2. if today we'll do transaction
   *      today price - (0 -> kth(today-1) day price) + (n-1)th transaction on same day(kth day)
   *              i.e - (prices[day]-prices[k])+basics.matrix[transc-1][k];
   *      check which day has maximum profit
   *
   * take maximum of first and second at basics.matrix[transc][day]
   *             prices at day
   *             2 | 5 | 7 | 1 | 4 | 3 | 1 | 3
   *          0| 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0
   *  transc  1| 0 | 3 | 5 | 5 | 5 | 5 | 5 | 5
   *          2| 0 | 3 | 5 | 5 | 8 | 8 | 8 | 8
   *          3| 0 | 3 | 5 | 5 | 8 | 8 | 8 | 10
   *
   *  first day you can't get any profit -> 0 profit
   *
   *  if you do 0 transaction -> 0 profit
   *  
   *
   */
  public int maximumProfitInKTransaction(int[] prices, int trans) {

    int[][] matrix = new int[trans + 1][prices.length];

    for(int transc=1;transc<matrix.length;transc++) {
      for(int day=1;day<matrix[0].length;day++) {
        int profitIfNotDoneTransc=matrix[transc][day-1];
        int max=profitIfNotDoneTransc;
        for(int k=0;k<day;k++) {
          //today price - kth day price + profit at one less transaction
          int profit=(prices[day]-prices[k])+matrix[transc-1][k];
          if (profit > max) max=profit;
        }
        matrix[transc][day]=Math.max(max,profitIfNotDoneTransc);
      }
    }

    CodeUtil.display2dMatrix(matrix);
    return matrix[trans][prices.length-1];


  }

  public static void main(String[] args) {
    int prices[] = {2, 5, 7, 1, 4, 3, 1, 3};
    StockBuyingProblem sbp= new StockBuyingProblem();
    System.out.println(sbp.maximumProfitInKTransaction(prices,3));
  }
}