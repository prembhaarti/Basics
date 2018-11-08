package basics.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * given basics.array->{4,3,5,1,2,6}
 *
 * find running median means as element will be added
 * you need to find median @ each element addition.
 *
 * create two bins : min basics.heap    max basics.heap
 *
 * 3 operation -> add, re-balance, getMedian
 *
 * add::
 * if num is empty or num<minHeap's root -> add in minHeap
 * else add in max basics.heap
 *
 * re-balance::
 * if basics.heap having more elements than other by 2
 *      shift into another
 *
 * median::
 * if both basics.heap size equals get both average
 * else just take element from basics.heap having more elements.
 */
public class RunningMedian {

    static PriorityQueue<Integer> mxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> mnHeap = new PriorityQueue<>();

    public static double[] getRunningMedian(int[] arr){
        double medians[] = new double[arr.length];
        for(int i=0;i<arr.length;i++) {
            addNumber(arr[i]);
            rebalance();
            medians[i]=getMedian();
        }
        return medians;
    }

    private static double getMedian() {
        if(mxHeap.size()==mnHeap.size()){
            return (double)(mxHeap.peek()+mnHeap.peek())/2;
        }
        else{
            PriorityQueue<Integer> biggerHeap= mxHeap.size()>mnHeap.size()?mxHeap:mnHeap;
            return biggerHeap.peek();
        }
    }

    private static void rebalance() {
        PriorityQueue<Integer> biggerHeap= mxHeap.size()>mnHeap.size()?mxHeap:mnHeap;
        PriorityQueue<Integer> smallerHeap= mxHeap.size()>mnHeap.size()?mnHeap:mxHeap;
        if(biggerHeap.size()-smallerHeap.size()>1){
            smallerHeap.offer(biggerHeap.poll());
        }
    }

    private static void addNumber(int num) {
        if (mxHeap.isEmpty() || num < mxHeap.peek()) {
            mxHeap.offer(num);
        }
        else {
            mnHeap.offer(num);
        }
    }

    public static void main(String[] args) {
        int[] arr={4,3,5,1,2,6};
        double medians[]=getRunningMedian(arr);
        System.out.println(Arrays.toString(medians));
    }
}
