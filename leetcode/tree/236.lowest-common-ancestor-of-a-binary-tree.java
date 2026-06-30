import java.util.*;
/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int p, q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p.val;
        this.q = q.val;

        dfs(root);

        return dfs(root);
    }

    TreeNode dfs(TreeNode node) {
        if(node == null) return null;

        if(node == null || node.val == p || node.val == q) return node;

        TreeNode left = dfs(node.left);
        TreeNode right = dfs(node.right);

        if(left != null && right != null) return node;

        return left != null ? left : right;
    }
}
// @lc code=end
