/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if(nums[0] < nums[nums.length - 1]) return nums[0];

        int high = nums.length - 1, low = 0;

        while(high >= low){
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if(nums[mid] > nums[0]) low = mid + 1;
            else high = mid;
        }
        return nums[0];
    }
}
// @lc code=end

