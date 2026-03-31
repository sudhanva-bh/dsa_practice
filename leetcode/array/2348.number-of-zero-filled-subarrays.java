/*
 * @lc app=leetcode id=2348 lang=java
 *
 * [2348] Number of Zero-Filled Subarrays
 */

// @lc code=start
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length, i = 0;
        long count = 0;
        while(i < n){
            if(nums[i] == 0){
                int k = 0;
                while(i < n && nums[i] == 0){
                    i++; k++;
                }
                count += k * (k+1) / 2;
            } else i++;
        }
        return count;
    }
}
// @lc code=end

