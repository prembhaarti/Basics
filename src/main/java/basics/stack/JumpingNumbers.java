package basics.stack;

import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers {

    public void jumpingNumbers(int num){
        for (int i=1;i<10 && i<num;i++) {
            jumpingNumbersQueue(num,i);
        }
    }

    private void jumpingNumbersQueue(int num,int sent){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sent);
        while (!queue.isEmpty()) {
            sent = queue.poll();
            if (sent <= num) {
                System.out.println(sent);
                int lastDigit = sent % 10;
                int nextDigit = sent * 10 + (lastDigit + 1);
                int prevDigit = sent * 10 + (lastDigit - 1);
                if (lastDigit == 0) {
                    queue.add(nextDigit);
                } else if (lastDigit == 9) {
                    queue.add(prevDigit);
                } else {
                    queue.add(prevDigit);
                    queue.add(nextDigit);
                }
            }
        }
    }

    public static void main(String[] args) {
        JumpingNumbers jumpingNumbers= new JumpingNumbers();
        jumpingNumbers.jumpingNumbers(50);
    }

}