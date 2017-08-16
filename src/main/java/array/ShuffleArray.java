package array;

import util.CodeUtil;

import java.util.Arrays;

public class ShuffleArray {


    public static void main(String[] args) {
        ShuffleArray sa = new ShuffleArray();
        int[] arr=sa.shuffle(new int[]{1,2,3,4,5,6,7});
        System.out.println(Arrays.toString(arr));
    }


    public int[] shuffle(int[] arr) {
        for(int i=arr.length-1; i>=0;i--) {
            int randomIndex=(int)(Math.random()*(i+1));
            CodeUtil.swap(arr,i,randomIndex);
        }
        return arr;
    }




}
