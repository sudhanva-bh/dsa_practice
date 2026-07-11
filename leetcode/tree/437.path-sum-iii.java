/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
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
    int count = 0;
    int targetSum;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        this.targetSum = targetSum;
        higherDfs(root);

        return count;
    }

    void higherDfs(TreeNode curr) {
        dfs(curr, 0);
        
        if(curr.left != null) higherDfs(curr.left);
        if(curr.right != null) higherDfs(curr.right);
    }

    void dfs(TreeNode curr, long currSum) {
        currSum += curr.val;

        if(currSum == targetSum) count++;

        if(curr.left != null) dfs(curr.left, currSum);
        if(curr.right != null) dfs(curr.right, currSum);
    }
}
// @lc code=end

