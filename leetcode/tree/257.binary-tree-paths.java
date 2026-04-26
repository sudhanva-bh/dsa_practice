/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 */

// @lc code=start
/**
 * Definition for a binary tree node.
*/
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<String> sol = new ArrayList<>();

    private void helper(TreeNode node, StringBuilder curr) {
        
        curr.append(((curr.length() == 0) ? "" : "->") + Integer.toString(node.val));
        int temp = curr.length();
        
        if(node.right == null && node.left == null) {
            sol.add(curr.toString());
            return;
        }

        if(node.left != null) helper(node.left, curr);
        curr.setLength(temp);
        if(node.right != null) helper(node.right, curr);
        curr.setLength(temp);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, new StringBuilder());
        return sol;
    }
}
// @lc code=end
