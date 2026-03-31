/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 */

// @lc code=start
class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int start = 0, n = nums.length;
        for (int end = 0; end < n; end++) {
            if (nums[end] == 0 || end == n - 1) {
                if (end - start > max) {
                    max = end - start;
                }
                start = end + 1;
            }
        }
        return max;
    }
}
// @lc code=end
// 0,1,1,0,0,1,0,1,1,1,1,0,0,0,1,0
// s
// e

