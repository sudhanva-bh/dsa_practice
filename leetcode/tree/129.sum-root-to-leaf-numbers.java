/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
 */

// @lc code=start
/**
 * Definition for a binary tree node.
*/
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
    int sum = 0;

    private void sumNodes(TreeNode node, int currSum) {
        currSum = currSum * 10 + node.val;

        if(node.left != null) {
            sumNodes(node.left, currSum);
        }
        
        if(node.right != null) {
            sumNodes(node.right, currSum);
        }

        if(node.right == null && node.left == null) {
            sum += currSum;
        }
    }
    
    public int sumNumbers(TreeNode root) {
        sumNodes(root, 0);
        return sum;
    }
}
// @lc code=end

