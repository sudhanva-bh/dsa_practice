/*
 * @lc app=leetcode id=3756 lang=java
 *
 * [3756] Concatenate Non-Zero Digits and Multiply by Sum II
 */

// @lc code=start
import java.util.*;

class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final long MOD = 1_000_000_007;
        int n = s.length();

        long[] pow10 = new long[n + 1];

        pow10[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long[] prefixSum = new long[n + 1];
        int[] prefixNonZeros = new int[n + 1];
        long[] prefixProduct = new long[n + 1];

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';

            prefixSum[i + 1] = prefixSum[i] + digit;
            prefixNonZeros[i + 1] = prefixNonZeros[i];

            if(digit == 0) {
                prefixProduct[i + 1] = prefixProduct[i];
            } else {
                prefixProduct[i + 1] = (prefixProduct[i] * 10 + digit) % MOD;
                prefixNonZeros[i + 1]++;
            }
        }

        int m = queries.length;
        int[] res = new int[m];

        for(int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int len = prefixNonZeros[r + 1] - prefixNonZeros[l];

            long start = prefixProduct[l];
            long end = prefixProduct[r + 1];

            long x = (end - (start * pow10[len]) % MOD + MOD) % MOD;
            long sum = prefixSum[r + 1] - prefixSum[l];

            res[i] = (int) ((x * sum) % MOD);
        }

        return res; 
    }
}
// @lc code=end
