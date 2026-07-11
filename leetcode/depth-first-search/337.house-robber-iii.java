/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
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
    final static int TAKE = 0, NOT_TAKE = 1;
    final static int MASK = 0xFFFFFFFF;

    public int rob(TreeNode node) {
        int[] res = rec(node);
        return Math.max(res[TAKE], res[NOT_TAKE]);
    }

    long rec(TreeNode node) {
        if (node == null)
            return 0;

        long left = rec(node.left);
        long right = rec(node.right);

        // rob
        int rob = node.val + left[NOT_TAKE] + right[NOT_TAKE];
        int notRob = Math.max(left[TAKE], left[NOT_TAKE]) + Math.max(right[TAKE], right[NOT_TAKE]);

        return new int[] { rob, notRob };
    }
}
// @lc code=end
