/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
import java.util.*;

class Solution {

    public int findMaxForm(String[] strs, int max0, int max1) {
        int n = strs.length;

        int[][] dp = new int[max0 + 1][max1 + 1];
        
        for(String s : strs) {
            int curr0 = 0, curr1 = 0;
            
            for(char c : s.toCharArray()) {
                if(c == '0') curr0++;
                else curr1++;
            }

            for(int z = max0; z >= curr0; z--) {
                for(int o = max1; o >= curr1; o--) {
                    dp[z][o] = Math.max(dp[z][o], dp[o - curr0][z-curr1] + 1);
                }
            }
        }

        return dp[max0][max1];
    }
}
// @lc code=end
