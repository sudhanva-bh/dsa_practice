/*
 * @lc app=leetcode id=1022 lang=java
 *
 * [1022] Sum of Root To Leaf Binary Numbers
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * }
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
    int sum = 0;

    static boolean isLeaf(TreeNode node){
        return node.left == null;
    }

    void sumRoomToLeafHelper(TreeNode curr, int prevSum) {
        prevSum = (prevSum << 1) + curr.val;
        if(isLeaf(curr)){
            sum += prevSum;
            return;
        }
        sumRoomToLeafHelper(curr.left, prevSum);
        sumRoomToLeafHelper(curr.right, prevSum);
    }

    public int sumRootToLeaf(TreeNode root) {
        sumRoomToLeafHelper(root, 0);
        return sum;
    }
}
// @lc code=end

