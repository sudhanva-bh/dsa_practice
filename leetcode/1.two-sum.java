/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
import java.util.*;

class Solution {
    boolean isValid(
            int n,
            int[][] edges,
            int source,
            int target,
            int k,
            int wmax) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            int cost = (w > wmax) ? 1 : 0;

            graph[u].add(new int[] { v, cost });
            graph[v].add(new int[] { u, cost });
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<Integer> dq = new ArrayDeque<>();

        dist[source] = 0;
        dq.offerFirst(source);

        while (!dq.isEmpty()) {
            int node = dq.pollFirst();

            for (int[] nei : graph[node]) {
                int next = nei[0];
                int cost = nei[1];

                if (dist[node] + cost < dist[next]) {
                    dist[next] = dist[node] + cost;

                    if (cost == 0) {
                        dq.offerFirst(next);
                    } else {
                        dq.offerLast(next);
                    }
                }
            }
        }

        return dist[target] <= k;
    }

    public int minimumThreshold(int n, int[][] edges, int source, int target, int k) {
        int low = 0;
        int high = 0;

        for (int[] e : edges) {
            high = Math.max(high, e[2]);
        }

        int ans = -1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(isValid(n, edges, source, target, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
// @lc code=end
