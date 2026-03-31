/*
 * @lc app=leetcode id=930 lang=java
 *
 * [930] Binary Subarrays With Sum
 */

// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length, count = 0, curr = 0;
        
        int left = 0, right = 0;

        while(right < n){
            curr += nums[right];
            while(curr <= goal){
                
            }
        }

        return count;
    }
}
// @lc code=end

