/*
 * @lc app=leetcode id=1306 lang=java
 *
 * [1306] Jump Game III
 */

// @lc code=start
class Solution {
    boolean canReachRec(int[] arr, int i, boolean[] visited) {
        if(i < 0 || i >= arr.length || visited[i]) return false;

        if(arr[i] == 0) return true;

        visited[i] = true;
        return canReachRec(arr, i + arr[i], visited) || canReachRec(arr, i - arr[i], visited);
    }

    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];

        return canReachRec(arr, n, visited);
    }
}
// @lc code=end

