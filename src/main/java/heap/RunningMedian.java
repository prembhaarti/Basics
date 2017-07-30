package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * given array->{4,3,5,1,2,6}
 *
 * find running median means as element will be added
 * you need to find median @ each element addition.
 *
 * create two bins : min heap    max heap
 *
 * 3 operation -> add, re-balance, getMedian
 *
 * add::
 * if num is empty or num<minHeap's root -> add in minHeap
 * else add in max heap
 *
 * re-balance::
 * if heap having more elements than other by 2
 *      shift into another
 *
 * median::
 * if both heap size equals get both average
 * else just take element from heap having more elements.
 */
public class RunningMedian {

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

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
        if(minHeap.size()==maxHeap.size()){
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        }
        else{
            PriorityQueue<Integer> biggerHeap= minHeap.size()>maxHeap.size()?minHeap:maxHeap;
            return biggerHeap.peek();
        }
    }

    private static void rebalance() {
        PriorityQueue<Integer> biggerHeap= minHeap.size()>maxHeap.size()?minHeap:maxHeap;
        PriorityQueue<Integer> smallerHeap= minHeap.size()>maxHeap.size()?maxHeap:minHeap;
        if(biggerHeap.size()-smallerHeap.size()>1){
            smallerHeap.offer(biggerHeap.poll());
        }
    }

    private static void addNumber(int num) {
        if (minHeap.isEmpty() || num < minHeap.peek()) {
            minHeap.offer(num);
        }
        else {
            maxHeap.offer(num);
        }
    }

    public static void main(String[] args) {
        int[] arr={4,3,5,1,2,6};
        double medians[]=getRunningMedian(arr);
        System.out.println(Arrays.toString(medians));
    }
}