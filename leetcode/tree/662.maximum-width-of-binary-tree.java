/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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

class WeightNode {
    TreeNode node;
    long weight;

    WeightNode(TreeNode n, long w) {
        node = n;
        weight = w;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        long max = 0;

        Queue<Pair<TreeNode, Long>> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 0L));

        while (!queue.isEmpty()) {
            int size = queue.size();

            long firstWeight = queue.peek().getValue();
            long currWeight = 0;

            while (size-- > 0) {
                Pair<TreeNode, Long> curr = queue.remove();
                currWeight = curr.getValue() - firstWeight;

                TreeNode currNode = curr.getKey();

                if (currNode.left != null)
                    queue.add(new Pair(currNode.left, (currWeight << 1)));
                if (currNode.right != null)
                    queue.add(new Pair(currNode.right, (currWeight << 1) + 1));
            }

            max = Math.max(max, currWeight);
        }

        return (int) max + 1;
    }
}
// @lc code=end
