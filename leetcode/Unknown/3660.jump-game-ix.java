/*
 * @lc app=leetcode id=3660 lang=java
 *
 * [3660] Jump Game IX
 */

// @lc code=start
class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];

        pre[0] = nums[0];
        suf[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], nums[i]);
            suf[n - i - 1] = Math.min(suf[n - i], nums[n - i - 1]);
        }

        int[] res = new int[n];

        res[n - 1] = pre[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (pre[i] > suf[i + 1]) {
                res[i] = res[i + 1];
            }

            else {
                res[i] = pre[i];
            }
        }

        return res;
    }
}
// @lc code=end
