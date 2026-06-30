/*
 * @lc app=leetcode id=3558 lang=java
 *
 * [3558] Number of Ways to Assign Edge Weights I
 */

// @lc code=start
import java.util.*;

class Solution {
    final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 2;

        List<Integer>[] hm = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            hm[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            hm[edge[0]].add(edge[1]);
            hm[edge[1]].add(edge[0]);
        }

        int slots = findHeightOfTree(hm, 1, 0) - 1;

        return modExponent(2, slots);
    }

    int modExponent(int a, int b) {
        long res = 1;

        long curr = a;
        int currB;

        while(b != 0) {
            currB = b & 1;
            b >>= 1;

            if(currB == 1) {
                res *= curr;
                res %= MOD;
            }

            curr *= curr;
            curr %= MOD;
        }

        return (int) res;
    }

    int findHeightOfTree(List<Integer>[] hm, int curr, int parent) {
        List<Integer> currList = hm[curr];

        int maxHeight = 0;

        for (int child : currList) {
            if (child != parent) {
                maxHeight = Math.max(maxHeight, findHeightOfTree(hm, child, curr));
            }
        }

        return maxHeight + 1;
    }
}
// @lc code=end
