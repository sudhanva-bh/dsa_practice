/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 */

// @lc code=start
import java.util.*;

// @formatter:off
// Definition: binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
// @formatter:on

class Solution {
    boolean[] visitedInPath = new boolean[501];

    TreeNode[] visitedPath = new TreeNode[501];
    int i = 0;

    List<Integer> res = new ArrayList<>();

    TreeNode target;

    boolean recToFindPath(TreeNode node) {
        visitedInPath[node.val] = true;
        visitedPath[i++] = node;

        if (node == target) {
            return true;
        }

        if (node.left != null && recToFindPath(node.left)) {
            return true;
        }
        if (node.right != null && recToFindPath(node.right)) {
            return true;
        }

        visitedInPath[node.val] = false;
        i--;
        return false;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int requiredDepth) {
        this.target = target;

        recToFindPath(root);

        while(requiredDepth >= 0 && i > 0) {
            TreeNode curr = visitedPath[--i];
            recToFindNodesAtDepth(curr, requiredDepth);
            requiredDepth--;
        }

        return res;
    }

    void recToFindNodesAtDepth(TreeNode curr, int depth) {
        if(depth == 0) {
            res.add(curr.val);
            return;
        }

        depth--;
        if(curr.left != null && !visitedInPath[curr.left.val]) recToFindNodesAtDepth(curr.left, depth);
        if(curr.right != null && !visitedInPath[curr.right.val]) recToFindNodesAtDepth(curr.right, depth);
    }
}
// @lc code=end
