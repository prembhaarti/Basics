package basics.interview.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 12/23/2014
 * @author tusroy
 * 
 * Video link https://youtu.be/ZmnqCZp9bBs
 * 
 * Given an basics.array representing height of bar in bar basics.graph, find max histogram
 * area in the bar basics.graph. Max histogram will be max rectangular area in the
 * basics.graph.
 * 
 * Maintain a basics.stack
 * 
 * If basics.stack is empty or value at index of basics.stack is less than or equal to value at current
 * index, push this into basics.stack.
 * Otherwise keep removing values from basics.stack till value at index at top of basics.stack is
 * less than value at current index.
 * While removing value from basics.stack calculate area
 * if basics.stack is empty
 * it means that till this point value just removed has to be smallest element
 * so area = input[top] * i
 * if basics.stack is not empty then this value at index top is less than or equal to
 * everything from basics.stack top + 1 till i. So area will
 * area = input[top] * (i - basics.stack.peek() - 1);
 * Finally maxArea is area if area is greater than maxArea.
 * 
 * 
 * Time complexity is O(n)
 * Space complexity is O(n)
 * 
 * References:
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 */
public class MaximumHistogram {

    public int maxHistogram(int input[]){
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < input.length;){
            if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
                stack.offerFirst(i++);
            }else{
                int top = stack.pollFirst();
                //if basics.stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                //if basics.stack is not empty then everythin from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - basics.stack.peek() - 1);
                else{
                    area = input[top] * (i - stack.peekFirst() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pollFirst();
            //if basics.stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
            if(stack.isEmpty()){
                area = input[top] * i;
            }
            //if basics.stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - basics.stack.peek() - 1);
            else{
                area = input[top] * (i - stack.peekFirst() - 1);
            }
        if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
    
    public static void main(String args[]){
        MaximumHistogram mh = new MaximumHistogram();
        int input[] = {2,2,2,6,1,5,4,2,2,2,2};
        int maxArea = mh.maxHistogram(input);
        //System.out.println(maxArea);
        assert maxArea == 12;
    }
}
