/*
 * @lc app=leetcode id=2110 lang=java
 *
 * [2110] Number of Smooth Descent Periods of a Stock
 */

// @lc code=start
class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long res = 0;
        if (n == 1)
            return 1;

        int left = 0, right = 1, len;

        while (right < n) {
            if (prices[right] - prices[right - 1] != -1) {
                len = right - left;
                res += (long) len * (len + 1) / 2;
                left = right;
            }
            right++;
        }

        len = n - left;
        res += (long) len * (len + 1) / 2;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getDescentPeriods(new int[] { 3, 2, 1, 4 }));
    }
}
// @lc code=end
