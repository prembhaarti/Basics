package matrix;

import java.util.Scanner;

/*
There is a stack of water glasses in a form of pascal triangle and a person wants to pour the water at the topmost glass,
but the capacity of each glass is 1 unit . Overflow takes place in such a way that after 1 unit, 1/2 of remaining unit gets into bottom
left glass and other half in bottom right glass.

Now the pours K units of water in the topmost glass and wants to know how much water is there in the jth glass of the ith row.

Assume that there are enough glasses in the triangle till no glass overflows.
 */

public class PascalWaterCheck {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    int j = sc.nextInt();
    int l = sc.nextInt();
    double[][] glasses = new double[k][k];
    int level = 0;
    glasses[0][0] = k;
    boolean waterLevelExceed = true;

    while (waterLevelExceed) {
      waterLevelExceed = false;

      for (int i = 0; i <= level; i++) {
        if (glasses[level][i]  > 1) {

          double extraWater = glasses[level][i] - 1;
          waterLevelExceed = true;
          glasses[level][i] = 1;
          glasses[level+1][i] = extraWater / 2;
          glasses[level+1][i + 1] = extraWater / 2;
        }
      }

      level++;
    }

    System.out.println(glasses[j-1][l-1]);

  }
}
