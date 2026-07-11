/*
 * @lc app=leetcode id=3532 lang=java
 *
 * [3532] Path Existence Queries in a Graph I
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] canReach = new int[n];
        int canReachUntil = 0;

        for(int curr = 0; curr < n; curr++) {
            while(canReachUntil < curr && nums[curr] - nums[canReachUntil] > maxDiff) {
                canReachUntil++;
            }

            if(canReachUntil == curr) canReach[curr] = curr;
            else canReach[curr] = canReach[canReachUntil];
        }

        int m = queries.length;

        boolean[] res = new boolean[m];

        for(int i = 0; i < m; i++) {
            int[] currQuery = queries[i];
            res[i] = canReach[currQuery[0]] == canReach[currQuery[1]];
        }

        return res;
    }
}
// @lc code=end

