/*
 * @lc app=leetcode id=1161 lang=java
 *
 * [1161] Maximum Level Sum of a Binary Tree
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

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<Integer> res;

    public int maxLevelSum(TreeNode root) {
        res = new ArrayList<>();

        dfs(root, 0);

        int n = res.size();
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for(int i = 0; i < n; i++) {
            if(res.get(i) > max) {
                max = res.get(i);
                maxIndex = i;
            }
        }

        return maxIndex + 1;
    }

    void dfs(TreeNode curr, int level) {
        if(curr == null) return;

        if(res.size() == level) res.add(curr.val);
        else res.set(level, res.get(level) + curr.val);

        dfs(curr.left, level + 1);
        dfs(curr.right, level + 1);
    }
}
// @lc code=end
