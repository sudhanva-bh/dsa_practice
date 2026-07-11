/*
 * @lc app=leetcode id=3620 lang=java
 *
 * [3620] Network Recovery Pathways
 */

// @lc code=start
import java.util.*;

class Solution {
    int[][][] adj;
    boolean[] online;
    long maxTotalWeight;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        this.online = online;
        maxTotalWeight = k;
        
        final int FROM = 0, TO = 1, WEIGHT = 2;

        int n = online.length;
        int maxEdge = 0;
        int minEdge = Integer.MAX_VALUE;

        for (int[] edge : edges) {
            if (edge[WEIGHT] > maxEdge)
                maxEdge = edge[WEIGHT];
            if (edge[WEIGHT] < minEdge)
                minEdge = edge[WEIGHT];
        }

        adj = new int[n][][];

        int[] deg = new int[n];

        for (int[] edge : edges) {
            deg[edge[FROM]]++;
        }

        for (int i = 0; i < n; i++) {
            adj[i] = new int[deg[i]][];
        }

        int[] ptr = new int[n];

        int from, to, weight;

        for (int[] edge : edges) {
            from = edge[FROM];
            to = edge[TO];
            weight = edge[WEIGHT];
            adj[from][ptr[from]++] = new int[] { to, weight };
        }

        int low = minEdge, high = maxEdge, ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canReach(0, mid)) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    long[] dp;

    boolean canReach(int curr, int maxWeight) {
        dp = new long[adj.length];
        Arrays.fill(dp, -1);

        return dfs(curr, maxWeight) <= maxTotalWeight;
    }

    long dfs(int u, int maxWeight) {
        if (u == adj.length - 1)
            return 0;

        if (dp[u] != -1)
            return dp[u];

        long INF = Long.MAX_VALUE / 4;
        long best = INF;

        for (int[] edge : adj[u]) {
            int v = edge[0];
            int w = edge[1];

            if (w < maxWeight)
                continue;

            if (v != adj.length - 1 && !online[v])
                continue;

            long cost = dfs(v, maxWeight);

            if (cost != INF)
                best = Math.min(best, cost + w);
        }

        return dp[u] = best;
    }
}
// @lc code=end
