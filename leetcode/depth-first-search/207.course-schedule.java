/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
import java.util.*;

class Solution {
    int[][] adj;

    boolean[] onPath;
    boolean[] safe;

    public boolean canFinish(int n, int[][] prerequisites) {
        int[] degree = new int[n];

        for (int[] prereq : prerequisites) {
            degree[prereq[1]]++;
        }

        adj = new int[n][];

        for (int i = 0; i < n; i++) {
            adj[i] = new int[degree[i]];
        }

        int[] ptr = new int[n];

        for (int[] prereq : prerequisites) {
            int a = prereq[0];
            int b = prereq[1];

            adj[b][ptr[b]++] = a;
        }

        onPath = new boolean[n];
        safe = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!dfs(i))
                return false;
        }
        return true;
    }

    boolean dfs(int curr) {
        if (safe[curr])
            return true;
        if (onPath[curr])
            return false;

        onPath[curr] = true;
        for (int next : adj[curr]) {
            if (!dfs(next))
                return false;
        }
        onPath[curr] = false;
        safe[curr] = true;
        return true;
    }
}
// @lc code=end
