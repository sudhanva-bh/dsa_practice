/*
 * @lc app=leetcode id=2492 lang=java
 *
 * [2492] Minimum Score of a Path Between Two Cities
 */

// @lc code=start
import java.util.*;

import java.util.*;

class Solution {
    int[][][] adj;
    boolean[] visited;
    int minmin = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        final int u = 0, v = 1, w = 2;
        adj = new int[n][][];
        int[] degree = new int[n];

        for (int[] road : roads) {
            road[u]--;
            road[v]--;
            degree[road[u]]++;
            degree[road[v]]++;
            minmin = Math.min(minmin, road[w]);
        }

        for (int i = 0; i < n; i++) {
            adj[i] = new int[degree[i]][];
        }

        int currU, currV, weight;

        int[] p = new int[n];

        for (int[] road : roads) {
            currU = road[u];
            currV = road[v];
            weight = road[w];

            adj[currU][p[currU]++] = new int[] { currV, weight };
            adj[currV][p[currV]++] = new int[] { currU, weight };
        }

        printAdj();

        visited = new boolean[n];

        visited[0] = true;
        return dfs(0);
    }

    int dfs(int curr) {
        int min = Integer.MAX_VALUE;

        for (int[] next : adj[curr]) {
            min = Math.min(min, next[1]);
            if (!visited[next[0]]) {
                visited[next[0]] = true;
                min = Math.min(min, dfs(next[0]));
            }
            if (min == minmin)
                return min;
        }

        return min;
    }

    void printAdj() {
        for (int i = 0; i < adj.length; i++) {
            System.out.print(i + " -> ");

            for (int[] edge : adj[i]) {
                System.out.print("(" + edge[0] + ", " + edge[1] + ") ");
            }

            System.out.println();
        }
    }
}
// @lc code=end
