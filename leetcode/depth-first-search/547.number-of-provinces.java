/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 */

// @lc code=start
import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(isConnected, visited, i);
            }
        }

        return provinces;
    }

    void dfs(int[][] isConnected, boolean[] visited, int curr) {
        visited[curr] = true;
        for(int i = 0; i < isConnected.length; i++) {
            if(!visited[i] && isConnected[curr][i] == 1) {
                dfs(isConnected, visited, i);
            }
        }
    }
}
// @lc code=end

