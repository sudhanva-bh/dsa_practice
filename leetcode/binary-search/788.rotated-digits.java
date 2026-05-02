/*
 * @lc app=leetcode id=788 lang=java
 *
 * [788] Rotated Digits
 */

// @lc code=start
class Solution {
    public int rotatedDigits(int n) {
        byte E = 0, G = 1, N = 2;
        byte[] dp = new byte[n + 1];
        byte[] first = new byte[] { E, E, G, N, N, G, G, N, E, G };

        for(int i = 0; i <= 9 && i <= n; i++) {
            dp[i] = first[i];
        }

        for(int i = 10; i <= n; i++) {
            byte A = dp[i/10], B = dp[i % 10];
            if(A == N || B == N) dp[i] = N;
            else if(A == E && B == E) dp[i] = E;
            else dp[i] = G;
        }

        int res = 0;

        for(int i = 0; i <= n; i++) {
            if(dp[i] == G) res++;
        }

        return res;
    }
}
// @lc code=end

