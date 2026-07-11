/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
import java.util.*;

class Solution {
    byte[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        
        char[] ca1 = s1.toCharArray();
        char[] ca2 = s2.toCharArray();

        char[] target = s3.toCharArray();

        boolean[][] dp = new boolean[ca1.length][ca2.length];

        for(int i = 0; i < ca1.length; i++) {
            dp[i][target.length - i] = true;
        }

        
    }

    boolean rec(char[] ca1, char[] ca2, char[] target, int i1, int i2) {
        if(i1 + i2 == target.length) {
            return true;
        }

        if(dp[i1][i2] != 0) {
            return dp[i1][i2] == 1;
        }

        int iTar = i1 + i2;
        if(i1 < ca1.length && ca1[i1] == target[iTar] && rec(ca1, ca2, target, i1 + 1, i2)) {
            dp[i1][i2] = 1;
            return true;
        }

        if(i2 < ca2.length && ca2[i2] == target[iTar] && rec(ca1, ca2, target, i1, i2 + 1)) {
            dp[i1][i2] = 1;
            return true;
        }

        dp[i1][i2] = 2;
        return false;
    }
}
// @lc code=end

