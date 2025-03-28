package basics.dp;

import basics.util.CodeUtil;

public class MinPathCost {

    /**
     * Player has to start from [0][0] pos to reach [n][n] with minimum cost.
     * <p>
     * path cost basics.matrix (given)
     * 1 | 2 | 3
     * 4 | 8 | 2
     * 1 | 5 | 3
     * <p>
     * Constraint: you can move only down and right ward
     * <p>
     * So, reach from top or left having minimum cost to current position
     * <p>
     * <p>
     * start filling from first row and first column sum in sum basics.matrix
     * from row[1] and col[1]
     * check up or left -> min(up,left)+ current one
     * and fill all basics.matrix
     * <p>
     * 1 | 3  | 6
     * 5 | 11 | 8    SUM MATRIX
     * 6 | 11 | 11o
     */
    public int getMin(int[][] cost) {
        int[][] tempCompute = new int[cost.length][cost[0].length];
        int sum=0;
        for(int right=0;right<cost[0].length;right++){
            sum+=cost[0][right];
            tempCompute[0][right]=sum;
        }
        sum=0;
        for(int down=0;down<cost.length;down++){
            sum+=cost[down][0];
            tempCompute[down][0]=sum;
        }

        for(int r=1;r<cost.length;r++){
            for(int c=1;c<cost[0].length;c++){
                tempCompute[r][c]=cost[r][c]+Math.min(tempCompute[r-1][c],tempCompute[r][c-1]);
            }
        }
        CodeUtil.display2dMatrix(tempCompute);
        return tempCompute[cost.length - 1][cost[0].length - 1];
    }

    public static void main(String[] args) {

        int[][] cost = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };

        MinPathCost mpc = new MinPathCost();
        System.out.println("Min path cost:" + mpc.getMin(cost));
    }
}
