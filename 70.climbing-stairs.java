
import java.util.HashMap;

/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    int[] hm = new int[46];
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(hm[n] != 0) return hm[n];
        int output = climbStairs(n-1)+climbStairs(n-2);
        hm[n] = output;
        return output;
    }
}
// @lc code=end

