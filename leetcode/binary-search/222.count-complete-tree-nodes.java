/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int height = 0;
        TreeNode curr = root;

        while(curr.left != null) {
            height++;
            curr = curr.left;
        }

        int rightheight = 0;

        while(curr.right != null) {
            rightheight++;
            curr = curr.right;
        }

        if(rightheight == height) return ((1 << (height + 1))) - 1;

        // System.out.println(height);

        int low = 0, high = (1 << height) - 1;
        int ans = 0;

        // System.out.println(low + " " + high);

        // System.out.println(isPossibleToReachLeaf(root, 0, height));

        while(low <= high) {
            int mid = (low + high) / 2;

            if(isPossibleToReachLeaf(root, mid, height)) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }

        // System.out.println(ans);

        return (1 << height) + ans;
    }

    boolean isPossibleToReachLeaf(TreeNode node, int path, int height) {
        for(int i = height - 1; i > 0; i--) {
            if(((path >> i) & 1) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        if((path & 1) == 0) {
            return node.left != null;
        } else {
            return node.right != null;
        }
    }
}
// @lc code=end

