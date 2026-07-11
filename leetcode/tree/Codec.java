/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
import java.text.DecimalFormat;
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

public class Codec {
    char none = 'n';

    StringBuilder sb = new StringBuilder();
    DecimalFormat df = new DecimalFormat("0000");

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb.setLength(0);

        dfsBuildString(root);

        return sb.toString();
    }

    void dfsBuildString(TreeNode node) {
        if (node == null) {
            sb.append(none);
            return;
        }

        sb.append(numToStr(node.val));

        dfsBuildString(node.left);
        dfsBuildString(node.right);
    }

    String numToStr(int n) {
        return df.format(n + 1000);
    }

    int index;
    char[] ca;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        ca = data.toCharArray();

        return dfsBuildTree();
    }

    TreeNode dfsBuildTree() {
        if (index == ca.length) {
            return null;
        }

        if (ca[index] == none) {
            index++;
            return null;
        }

        TreeNode curr = new TreeNode(strToNum(ca, index));

        index += 4;

        curr.left = dfsBuildTree();
        curr.right = dfsBuildTree();

        return curr;
    }

    int strToNum(char ca[], int i) {
        return (ca[i] - '0') * 1000 + (ca[i + 1] - '0') * 100 + (ca[i + 2] - '0') * 10 + (ca[i + 3] - '0') - 1000;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
