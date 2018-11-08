package basics.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by YATRAONLINE\prem.bharti on 26/9/17.
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int testCases=sc.nextInt();
        while(testCases-- !=0){
            int[] sides= new int[4];
            for(int i=0;i<4;i++){
                sides[i]=sc.nextInt();
            }
            System.out.println(isRectangle(sides)?"YES":"NO");
        }
    }

    public static boolean isRectangle(int[] sides){
        return (sides[0]==sides[1] && sides[2]==sides[3])
                || ((sides[0]*sides[0] + sides[1]* sides[1])==(sides[2]*sides[2]+sides[3]*sides[3]));
    }
}
