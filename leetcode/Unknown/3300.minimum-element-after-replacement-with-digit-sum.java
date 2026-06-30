/*
 * @lc app=leetcode id=3300 lang=java
 *
 * [3300] Minimum Element After Replacement With Digit Sum
 */

// @lc code=start
class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum;

        for(int i = 0; i < nums.length; i++) {
            sum = 0;
            while(nums[i] != 0) {
                sum += nums[i] % 10;
                nums[i] /= 10;
            }

            if(sum < min) min = sum;
        }

        return min;
    }
}
// @lc code=end

