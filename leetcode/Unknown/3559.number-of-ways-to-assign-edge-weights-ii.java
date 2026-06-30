/*
 * @lc app=leetcode id=3559 lang=java
 *
 * [3559] Number of Ways to Assign Edge Weights II
 */

// @lc code=start
import java.util.*;

class Solution {

    int[] degree;
    int[][] adj;
    int[][] binaryLift;
    int[] firstParent;
    int[] heightMap;

    int MOD = 1_000_000_007;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;

        degree = new int[n + 1];

        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        adj = new int[n + 1][];

        for (int i = 1; i < n + 1; i++) {
            adj[i] = new int[degree[i]];
        }

        int[] pos = new int[n + 1];

        for (int[] edge : edges) {
            adj[edge[0]][pos[edge[0]]++] = edge[1];
            adj[edge[1]][pos[edge[1]]++] = edge[0];
        }

        int log = 32 - Integer.numberOfLeadingZeros(n);

        binaryLift = new int[log][n + 1];

        firstParent = binaryLift[0];

        heightMap = new int[n + 1];

        dfs(1, 0, 0);

        int temp;

        for (int i = 1; i < log; i++) {
            for (int j = 0; j < n + 1; j++) {
                temp = binaryLift[i - 1][j];

                if (temp != 0) {
                    temp = binaryLift[i - 1][temp];
                }

                binaryLift[i][j] = temp;
            }
        }

        int h1, h2, h;
        int q1, q2;

        int[] res = new int[queries.length];
        int r = 0;

        for (int[] q : queries) {
            h1 = heightMap[q[0]];
            h2 = heightMap[q[1]];

            if (h1 > h2) {
                q1 = q[0];
                q2 = q[1];
            } else {
                q1 = q[1];
                q2 = q[0];
            }

            q1 = jumpUp(q1, Math.abs(h1 - h2));

            // while (q1 != q2) {
            // q1 = jumpUp(q1, 1);
            // q2 = jumpUp(q2, 1);
            // }

            q1 = findCommonAns(q1, q2);

            h = h1 + h2 - (heightMap[q1] << 1);

            if (h == 0) {
                res[r++] = 0;
            } else {
                res[r++] = modExponent(h - 1);
            }
        }

        return res;
    }

    int findCommonAns(int q1, int q2) {
        if (q1 == q2)
            return q1;

        for (int i = binaryLift.length - 1; i >= 0; i--) {
            if (binaryLift[i][q1] != binaryLift[i][q2]) {
                q1 = binaryLift[i][q1];
                q2 = binaryLift[i][q2];
            }
        }

        return firstParent[q1];
    }

    int modExponent(int b) {
        long res = 1;

        long curr = 2;
        int currB;

        while (b != 0) {
            currB = b & 1;
            b >>= 1;

            if (currB == 1) {
                res *= curr;
                res %= MOD;
            }

            curr *= curr;
            curr %= MOD;
        }

        return (int) res;
    }

    void dfs(int curr, int parent, int height) {
        int[] currList = adj[curr];
        firstParent[curr] = parent;
        heightMap[curr] = height;

        for (int child : currList) {
            if (child != parent) {
                dfs(child, curr, height + 1);
            }
        }
    }

    int jumpUp(int node, int k) {
        int currLevel = 0, currDigit;

        while (k != 0) {
            currDigit = k & 1;
            k >>= 1;

            if (currDigit == 1) {
                node = binaryLift[currLevel][node];
                if (node == 0)
                    return 0;
            }

            currLevel++;
        }

        return node;
    }
}
// @lc code=end
