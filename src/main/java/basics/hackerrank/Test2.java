package basics.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by YATRAONLINE\prem.bharti on 26/9/17.
 */
public class Test2 {

    public static void main(String[] args) {

    }

    public String spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return "[]";
        }

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;

        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            up++;

            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
            }
            down--;

            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
        }
        return result.toString().replace(",","");
    }

}
class X{

}
