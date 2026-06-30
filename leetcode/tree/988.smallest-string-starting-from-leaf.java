/*
 * @lc app=leetcode id=988 lang=java
 *
 * [988] Smallest String Starting From Leaf
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
    String res;

    public String smallestFromLeaf(TreeNode root) {
        rec(root, new StringBuilder());
        return res;
    }

    void rec(TreeNode node, StringBuilder sb) {
        sb.append((char) (node.val + 'a'));
        if (node.left == null && node.right == null) {
            String s = sb.reverse().toString();
            if (res == null || res.compareTo(sb.toString()) > 0) {
                res = s;
            }
            sb.reverse();
        }

        if (node.left != null) {
            rec(node.left, sb);
        }

        if (node.right != null) {
            rec(node.right, sb);
        }

        sb.setLength(sb.length() - 1);
    }
}
// @lc code=end
