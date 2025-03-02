package basics.interview.tree;

/**
 * Date 03/05/2015
 * @author tusroy
 * 
 * Given a root of binary basics.tree, return size of binar basics.tree
 * 
 * Solution:
 * Recursively find size of left side, right side and add one to them and return that to calling function.
 * 
 * Time complexity - O(n)
 * Space complexity(because of recursion basics.stack) - height of binary basics.tree. Worst case O(n)
 * 
 * Test cases:
 * Null basics.tree
 * 1 node basics.tree
 * multi node basics.tree
 */
public class SizeOfBinaryTree {

    public int size(Node root){
        if(root == null){
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }
    
    public static void main(String args[]){
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(15, head);
        head = bt.addNode(5, head);
        head = bt.addNode(7, head);
        head = bt.addNode(19, head);
        head = bt.addNode(20, head);
        head = bt.addNode(-1, head);
        SizeOfBinaryTree sbt = new SizeOfBinaryTree();
        System.out.println(sbt.size(head));
    }
}
