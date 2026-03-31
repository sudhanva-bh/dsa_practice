/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0; 
        long max = nums[0];
        for(int i : nums){
            sum += i;
            max = Math.max(sum, max);
            if(sum < 0){
                sum = 0;
            }
        }
        return (int) max;
    }
}
// @lc code=end

