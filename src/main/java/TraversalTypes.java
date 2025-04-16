import java.util.PriorityQueue;

public class TraversalTypes {

    public static void main(String[] args) {
        System.out.println("");





    }

    public void traverse2DMatrix(int[][] matrix){
        for(int r=0; r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                //if cell contains 1, find min of left above diagonal, left, above
                if(matrix[r][c]==1){
                    matrix[r][c] = Math.min(matrix[r-1][c-1], Math.min(matrix[r][c-1], matrix[r-1][c]));
                }
            }
        }
    }

    public boolean isValid2DMatrixTraversal(int[][] matrix, int row, int col, boolean[][] visited){
        return (row>=0 && row<matrix.length && col>=0 && col<matrix[0].length &&
                matrix[row][col]==1 &&
                !visited[row][col]);
    }

    public int binarySearch(int input[], int search) {
        int low = 0, high = input.length - 1, mid;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (input[mid] == search) {
                return mid;
            } else if (input[mid] < search) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int arrayRecursion(int stairs){
        int[] stepsCount = new int[stairs];
        stepsCount[0]=1;
        stepsCount[1]=2;

        for(int i=2;i<stairs;i++) {
            stepsCount[i]=stepsCount[i-2]+stepsCount[i-1];
        }
        return stepsCount[stairs-1];
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public int minHeapUsageRopeBindingCost(int[] ropesLen){
        if(ropesLen.length<2){
            return 0;
        }
        for(int i=0; i<ropesLen.length;i++){
            minHeap.add(ropesLen[i]);
        }
        int cost=0;
        while(minHeap.size()!=1){ //minHeap.isEmpty();
            int first= minHeap.poll();
            int second= minHeap.poll();
            int sum=first+second;
            cost+=sum;
            minHeap.offer(sum);
        }
        return cost;
    }

}
//




































































