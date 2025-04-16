package basics;

import java.util.Arrays;

//Problem:
//room -> certain number of bags
// each bag contains mangoes
// I know how many mangoes
// x number of people with me
// donate mangoes to all people
// all mangoes from given bag to each people
// when you choose mangobag to one people as whole
// distribue mangoes to near equal to number of people.

//sum -> all bags
//        sort it out
//43/3 ~ 14

// 3 people
// 5 bags
// 5 bag contains [13, 7, 8, 9, 6]
// x1 - 10

//
//p^n
//3^n


public class InterviewWalmart {


    //array of elements
//    array size -> n
//    3 elements in array whose sum is closest to the given number
//    number -> k

    //close
    // ex- 1 -1 2 -3
    // k - 0
    public static void main(String[] args) {

        int[] arr = new int[]{1, -1, 2, -3, 5};
//        int[] arr = new int[]{-1,2,1, -4};
        int[] result = closestSumToK(arr, 1);
        for(int j=0; j< result.length; j++){
            System.out.print(result[j]+",");
        }
    }

//    // ex- 1 -1 2 -3
    // -3, -1, 1, 2
    // i, left,   right
    // 0
    public static int[] closestSumToK(int[] input, int k){
        Arrays.sort(input);
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[3];

        for(int i=0; i< input.length -2 ; i++){
            int left = i+1;
            int right = input.length-1;
            while(left < right){
                int currentSum = input[i] + input[left] + input[right];// -2
                int currentDiff = Math.abs(k-currentSum); // 2

                if(currentDiff< minDiff){ //
                    minDiff = currentDiff; //2
                    closestSum = currentSum; //-2
                    result[0]= input[i];
                    result[1]= input[left];
                    result[2]= input[right];
                }

                if(currentSum < k){
                    left++;
                }
                else {
                    right--;
                }


            }

        }
        return result;
    }




}
