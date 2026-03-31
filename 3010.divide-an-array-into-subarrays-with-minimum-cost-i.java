/*
 * @lc app=leetcode id=3010 lang=java
 *
 * [3010] Divide an Array Into Subarrays With Minimum Cost I
 */

// @lc code=start
class Solution {
    public int minimumCost(int[] nums) {
        int minFirst = Integer.MAX_VALUE, minSecond = Integer.MAX_VALUE, n = nums.length;
        for(int i = 1; i < n; i++){
            if(nums[i] <= minSecond){
                if(nums[i] <= minFirst){
                    minSecond = minFirst;
                    minFirst = nums[i];
                } else {
                    minSecond = nums[i];
                }
            }
        }
        return nums[0] + minFirst + minSecond;
    }
}
// @lc code=end

