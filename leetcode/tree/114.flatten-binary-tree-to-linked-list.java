/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 */

// @lc code=start
import java.util.*;

// @formatter:off
// Definition: binary tree node
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
// @formatter:on

class Solution {
    public void flatten(TreeNode root) {
        flattenAndGetTail(root);
    }

    TreeNode flattenAndGetTail(TreeNode node) {
        if(node == null) return null;

        if(node.right == null && node.left == null) return node;

        if(node.right != null) {
            TreeNode rightTail = flattenAndGetTail(node.right);
            if(node.left != null) {
                TreeNode leftTail = flattenAndGetTail(node.left);
                TreeNode tempRight = node.right;

                node.right = node.left;
                node.left = null;

                leftTail.right = tempRight;
            }

            return rightTail;
        } else {
            TreeNode leftTail = flattenAndGetTail(node.left);
            node.right = node.left;
            node.left = null;
            
            return leftTail;
        }
    }
}
// @lc code=end

