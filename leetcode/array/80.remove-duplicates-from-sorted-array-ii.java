/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0;

        int prev, count;
        int p = 1;
        prev = nums[0];
        count = 1;

        for(int i = 1; i < nums.length; i++) {
            if(prev == nums[i]) {
                count++;
            } else {
                prev = nums[i];
                count = 1;
            }
            if(count <= 2) nums[p++] = nums[i];
        }

        return p;
    }
}
// @lc code=end

