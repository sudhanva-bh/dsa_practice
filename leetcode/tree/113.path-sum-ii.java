/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 */

// @lc code=start

import java.util.*;

/**
 * Definition for a binary tree node.
 */
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
    List<List<Integer>> resList;
    List<Integer> currList;
    int tar;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        resList = new ArrayList<>();
        currList = new ArrayList<>();
        tar = targetSum;
        
        dfs(root, 0);

        return resList;
    }

    void dfs(TreeNode curr, int sum) {
        sum += curr.val;
        currList.add(curr.val);

        if(curr.left == null && curr.right == null) {
            if(sum == tar) resList.add(new ArrayList<>(currList));
        }

        if(curr.left != null) {
            dfs(curr.left, sum);
        }

        if(curr.right != null) {
            dfs(curr.right, sum);
        }

        currList.remove(currList.size() - 1);
        sum -= curr.val;
    }
}
// @lc code=end
