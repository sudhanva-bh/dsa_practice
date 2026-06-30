/*
 * @lc app=leetcode id=2217 lang=java
 *
 * [2217] Find Palindrome With Fixed Length
 */

// @lc code=start
import java.util.*;

class Solution {

    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] res = new long[n];
        int resp = 0;

        int baseLength = (intLength + 1) / 2;
        long baseNum = Math.powExact(10, baseLength);
        long baseMax = baseNum * 10;
        boolean isOdd = (baseLength & 1) == 1;

        for (int i = 0; i < n; i++) {
            long currHalf = baseNum + queries[i] - 1;
            if (currHalf < baseMax) {
                long temp = currHalf;
                if (isOdd)
                    temp /= 10;

                while (temp != 0) {
                    currHalf = currHalf * 10 + (temp % 10);
                    temp /= 10;
                }

                res[resp++] = currHalf;
            } else {
                res[resp++] = -1;
            }
        }

        return res;
    }
}
// @lc code=end
