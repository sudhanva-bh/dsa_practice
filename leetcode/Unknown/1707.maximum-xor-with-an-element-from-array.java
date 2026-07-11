/*
 * @lc app=leetcode id=1707 lang=java
 *
 * [1707] Maximum XOR With an Element From Array
 */

// @lc code=start
import java.util.*;

class Node {
    Node[] next = new Node[2];

    boolean containsKey(int n) {
        return next[n] != null;
    }

    Node getNext(int n) {
        return next[n];
    }

    Node getOrInsertNext(int n) {
        return next[n] == null ? next[n] = new Node() : next[n];
    }
}

class Solution {
    Node head = new Node();

    public int[] maximizeXor(int[] nums, int[][] queries) {
        final int X = 0, MAX = 1;

        Arrays.sort(nums);

        int n = nums.length, m = queries.length;

        Integer[] queriesSorted = new Integer[m];
        for (int i = 0; i < m; i++)
            queriesSorted[i] = i;
        Arrays.sort(queriesSorted, (a, b) -> queries[a][MAX] - queries[b][MAX]);

        int[] res = new int[m];

        int numsPtr = 0;

        for(int i = 0; i < m; i++) {
            int currQueryIndex = queriesSorted[i];
            int[] currQuery = queries[currQueryIndex];

            while(numsPtr < n && currQuery[MAX] >= nums[numsPtr]) {
                insertNum(nums[numsPtr]);
                numsPtr++;
            }
            res[currQueryIndex] = numsPtr == 0 ? -1 : getMax(currQuery[X]);
        }

        return res;
    }

    int getMax(int n) {
        Node curr = head;
        int max = 0;

        for (int i = 30; i >= 0; i--) {
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

    void insertNum(int n) {
        Node curr = head;

        for (int i = 30; i >= 0; i--) {
            curr = curr.getOrInsertNext((n >> i) & 1);
        }
    }
}
// @lc code=end
