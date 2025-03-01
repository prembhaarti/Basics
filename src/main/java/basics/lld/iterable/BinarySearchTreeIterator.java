package basics.lld.iterable;
import basics.leetcode.TreeNode;

import java.util.Stack;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BinarySearchTreeIterator
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class BinarySearchTreeIterator {
    /**
     * 173. Binary Search Tree Iterator
     *
     * time : O(n)
     * @param root
     */

    private TreeeNode cur;
    private Stack<TreeeNode> stack;

    public BinarySearchTreeIterator(TreeeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!stack.isEmpty() || cur != null) return true;
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }
}
class TreeeNode {

    int val;
    TreeeNode left;
    TreeeNode right;

    TreeeNode (int x) {
        val = x;
    }

}
