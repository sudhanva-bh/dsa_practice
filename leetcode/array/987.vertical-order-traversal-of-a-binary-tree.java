/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
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

class NodeLevel {
    TreeNode node;
    int x;
    int y;

    NodeLevel(TreeNode n, int x, int y) {
        node = n;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<NodeLevel> queue = new PriorityQueue<>((a, b) -> {
            if (a.x != b.x)
                return Integer.compare(a.x, b.x);
            if (a.y != b.y)
                return Integer.compare(a.y, b.y);
            return Integer.compare(a.node.val, b.node.val);
        });

        queue.add(new NodeLevel(root, 0, 0));

        List<List<Integer>> resPos = new ArrayList<>();
        List<List<Integer>> resNeg = new ArrayList<>();

        while (!queue.isEmpty()) {
            NodeLevel curr = queue.remove();
            TreeNode currNode = curr.node;
            int x = curr.x + 1, y = curr.y, val = currNode.val;
            if (y >= 0) {
                if (resPos.size() == y) {
                    resPos.add(new ArrayList<>());
                }

                resPos.get(y).add(val);
            } else {
                int posY = -y - 1;

                if (resNeg.size() == posY) {
                    resNeg.add(new ArrayList<>());
                }

                resNeg.get(posY).add(val);
            }

            if (currNode.left != null) {
                queue.add(new NodeLevel(currNode.left, x, y - 1));
            }

            if (currNode.right != null) {
                queue.add(new NodeLevel(currNode.right, x, y + 1));
            }
        }

        Collections.reverse(resNeg);
        for(List<Integer> l : resPos) {
            resNeg.add(l);
        }

        return resNeg;
    }
}
// @lc code=end
