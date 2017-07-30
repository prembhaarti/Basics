package stack;

import java.util.Arrays;

/**
 * Create an array of size 10
 *
 * take two top, top1=-1, top2=arr.length
 *
 * push1 ->
 *  throw Overflow -> top1==arr.length || top1==top2
 *  else put data at -> top1++
 *
 * push2 ->
 *  throw Overflow -> top2==0 || top2==top1
 *  else put data at -> top2--
 *
 * pop1 -> throw Underflow -> top1==-1
 *  else return data from -> top1--
 *
 * pop2 -> throw Underflow -> top2==arr.length
 *  else return data from top++
 *
 */

public class TwoStack {

    private int top1;
    private int top2;

    private static int[] array= new int[10];

    public TwoStack(){
        top1=-1;
        top2=array.length;
    }

    public int pop1(){
        if(top1==-1){
            throw new RuntimeException("stack 1 Underflow");
        }
        else{
            return top1--;
        }
    }

    public int pop2(){
        if(top2==array.length){
            throw new RuntimeException("stack 2 Underflow");
        }
        else{
            return top2++;
        }
    }

    public void push1(int data){
        if(top1==array.length || top1==top2){
            throw new RuntimeException("stack 1 overflow");
        }
        else{
            array[++top1]=data;
        }
    }

    public void push2(int data){
        if(top2==-1 || top2==top1){
            throw new RuntimeException("stack 2 overflow");
        }
        else{
            array[--top2]=data;
        }
    }

    public static void main(String[] args) {
        TwoStack stack = new TwoStack();
        for(int i=0;i<10;){
            stack.push1(i++);
            stack.push2(i++);
            System.out.println(Arrays.toString(array));
        }
        System.out.println(Arrays.toString(array));
    }
}