package basics.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * basics.Matrix given sorted horizontally and vertically
 *             {10, 20, 30, 40},
 *             {15, 25, 35, 45},
 *             {24, 29, 37, 48},
 *             {32, 33, 39, 50}
 * have to find Kth minimum element in basics.matrix.
 *
 * Create a min basics.heap -> add first row elements in that
 *                      with node having data, row, col
 *
 * Now, start to extract one element at a time upto k times,
 *  get row and col from extracted element and
 *  go one down row+1,col and add that basics.matrix element in basics.heap
 *
 *  if row+1 is out of limit then add Integer.Max,-1,-1 in new node
 *
 *  when it's kth element break and return.
 */
public class KthMinRowCol {

    static int[][] matrix= {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {24, 29, 37, 48},
            {32, 33, 39, 50},
    };

    static PriorityQueue<HNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(HNode::getNum));

    public static int getKthElement(int[][] matrix,int k){
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<col;i++){
            minHeap.add(new HNode(matrix[0][i],0,i));
        }

        int count=1;
        while(count<k){
            HNode node = minHeap.remove();
            if(node.row<row-1){
                minHeap.add(new HNode(matrix[node.row+1][node.col],node.row+1,node.col));
            }
            else {
                minHeap.add(new HNode(Integer.MAX_VALUE,-1,-1));
            }
            count++;
        }
        return minHeap.peek().getNum();
    }

    public static void main(String[] args) {
//        for(int i=1;i<17;i++) {
            System.out.println(getKthElement(matrix, 10));
//        }
    }

}

class HNode{
    int num;
    int row;
    int col;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public HNode(int num, int row, int col) {
        this.num = num;
        this.row = row;
        this.col = col;
    }
}
