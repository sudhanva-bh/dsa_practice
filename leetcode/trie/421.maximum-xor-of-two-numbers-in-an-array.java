/*
 * @lc app=leetcode id=421 lang=java
 *
 * [421] Maximum XOR of Two Numbers in an Array
 */

// @lc code=start
import java.util.*;

class Node {
    private Node[] next = new Node[2];

    boolean containsKey(int n) {
        return next[n] != null;
    }

    Node getNext(int n) {
        return next[n];
    }

    Node getOrInsertNext(int n) {
        if (!containsKey(n))
            next[n] = new Node();
        return next[n];
    }
}

class Solution {
    Node head = new Node();
    int max2;

    public int findMaximumXOR(int[] nums) {
        int minTrailing = 32;
        for(int i : nums) {
            minTrailing = Math.min(minTrailing, Integer.numberOfTrailingZeros(i));
        }

        max2 = 31 - minTrailing;

        for (int i : nums) {
            insert(i);
        }

        int max = 0;

        for (int i : nums) {
            max = Math.max(max, getMax(i));
        }

        return max;
    }

    void insert(int n) {
        Node curr = head;

        for (int i = max2; i >= 0; i--) {
            curr = curr.getOrInsertNext((n >> i) & 1);
        }
    }

    int getMax(int n) {
        Node curr = head;
        int max = 0;

        for (int i = max2; i >= 0; i--) {
            int bit = (n >> i) & 1;
            int desired = 1 - bit;

            if (curr.containsKey(desired)) {
                max |= (1 << i);
                curr = curr.getNext(desired);
            } else {
                curr = curr.getNext(bit);
            }
        }

        return max;
    }
}
// @lc code=end
