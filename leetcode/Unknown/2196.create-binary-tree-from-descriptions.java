/*
 * @lc app=leetcode id=2196 lang=java
 *
 * [2196] Create Binary Tree From Descriptions
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

class Node {
    TreeNode n;
    boolean hasParent;

    Node(int val) {
        n = new TreeNode(val);
    }
}

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, Node> treeMap = new HashMap<>();

        int parent = 0, child = 1, isLeft = 2;

        for(int[] curr : descriptions) {
            treeMap.putIfAbsent(curr[parent], new Node(curr[parent]));
            Node p = treeMap.get(curr[parent]);
            
            treeMap.putIfAbsent(curr[child], new Node(curr[child]));
            Node c = treeMap.get(curr[child]);

            if(curr[isLeft] == 1) {
                p.n.left = c.n;
            } else {
                p.n.right = c.n;
            }

            c.hasParent = true;
        }

        for(Node node : treeMap.values()) {
            if(!node.hasParent) return node.n;
        }

        return null;
    }
}
// @lc code=end
