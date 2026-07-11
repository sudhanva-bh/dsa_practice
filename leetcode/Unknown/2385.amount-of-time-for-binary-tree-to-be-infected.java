/*
 * @lc app=leetcode id=2385 lang=java
 *
 * [2385] Amount of Time for Binary Tree to Be Infected
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
    TreeNode[] parents = new TreeNode[100001];

    TreeNode startNode;
    int start;

    public int amountOfTime(TreeNode root, int start) {
        this.start = start;

        dfsToSearch(root, null);

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(startNode);

        int time = -1;

        boolean[] visited = new boolean[100001];
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;

            while (size-- > 0) {
                TreeNode curr = queue.remove();

                TreeNode parent = parents[curr.val];
                TreeNode left = curr.left;
                TreeNode right = curr.right;

                if (parent != null) {
                    visited[parent.val] = true;
                    queue.add(parent);
                }

                if (left != null && !visited[left.val]) {
                    visited[left.val] = true;
                    queue.add(left);
                }

                if (right != null && !visited[right.val]) {
                    visited[right.val] = true;
                    queue.add(right);
                }
            }
        }

        return time;
    }

    boolean dfsToSearch(TreeNode curr, TreeNode parent) {
        parents[curr.val] = parent;
        
        if (curr.val == start) {
            startNode = curr;
            return true;
        }

        if (curr.left != null && dfsToSearch(curr.left, curr)) {
            return true;
        }

        if (curr.right != null && dfsToSearch(curr.right, curr)) {
            return true;
        }

        parents[curr.val] = null;
        return false;
    }
}
// @lc code=end
