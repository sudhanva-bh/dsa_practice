/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        int low = 0, high = nums.length - 1, ans = 0;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[mid + 1])
    }
}
// @lc code=end

