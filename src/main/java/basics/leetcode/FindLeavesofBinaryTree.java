package basics.leetcode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FindLeavesofBinaryTree
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 366. Find Leaves of Binary Tree
 */
public class FindLeavesofBinaryTree {
    /**
     * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves,
     * repeat until the tree is empty.

     Example:
     Given binary tree
         1
        / \
       2   3
      / \
     4   5   0
     /
     null   -1
     Returns [4, 5, 3], [2], [1].


     Explanation:
     1. Removing the leaves [4, 5, 3] would result in this tree:

       1
      /
     2
     2. Now removing the leaf [2] would result in this tree:

     1
     3. Now removing the leaf [1] would result in the empty tree:

     []
     Returns [4, 5, 3], [2], [1].

     time : O(n)
     space : O(n)

     * @param root
     * @return
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private int helper(List<List<Integer>> res, TreeNode root) {
        if (root == null) return -1;
        int left = helper(res, root.left);
        int right = helper(res, root.right);
        int level = Math.max(left, right) + 1;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        root.left = null;
        root.right = null;
        return level;
    }

    public List<List<Integer>> getLeaves(TreeNode root){

        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        addResult(root, levelMap);
        List<List<Integer>> resultList = new ArrayList<>(levelMap.values());
        return resultList;
    }

    private int addResult(TreeNode root,  Map<Integer, List<Integer>> levelMap) {
        if(root == null){
            return -1;
        }
        int level = Math.max(addResult(root.left,levelMap), addResult(root.right, levelMap))+1;
        if(levelMap.containsKey(level)){
            levelMap.get(level).add(root.val);
        }
        else{
            List<Integer> levelList = new ArrayList<>();
            levelList.add(root.val);
            levelMap.put(level, levelList);
        }
        return level;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        FindLeavesofBinaryTree flob= new FindLeavesofBinaryTree();
        System.out.println(flob.getLeaves(treeNode));
    }


}
