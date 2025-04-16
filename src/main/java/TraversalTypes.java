import basics.interviews.TreeNode;

import java.util.*;

public class TraversalTypes {
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    public static void main(String[] args) {
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

    public void traverse2DMatrix1ToNChar(int[][] matrix){
        for(int r=0; r<matrix.length;r++){
            for(int c=0;r+c<matrix.length;c++){
                if(r<=1){
                    matrix[c][r+c]=1;
                }
                else{
                    if(matrix[c+1][r+c-1]==1){
                        matrix[c][r+c]=1;
                    }
                }
            }
        }
    }


    public int binarySearch(int input[], int element) {
        int low = 0, high = input.length - 1, mid;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (input[mid] == element) {
                return mid;
            } else if (input[mid] < element) {
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

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    public void dfsRecursive(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // for level-wise printing
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
    }
    //["", "a", "ab", "abc", "ac", "b", "bc", "c"]
    private void backtrackStringCombination(String str, int index, StringBuilder path, List<String> result) {
        result.add(path.toString());
        for (int i = index; i < str.length(); i++) {
            path.append(str.charAt(i));//choose
            backtrackStringCombination(str, i + 1, path, result);//explore
            path.deleteCharAt(path.length() - 1);//backtrack
        }
    }

    // ["abc","acb","bac","bca","cba","cab"]
    private void backtrackPermultation(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i); // choose
            backtrackPermultation(chars, index + 1, result); // explore
            swap(chars, index, i); // un-choose (backtrack)
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
//




































































