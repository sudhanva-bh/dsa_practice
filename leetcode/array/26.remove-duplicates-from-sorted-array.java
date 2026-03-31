/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {

    public int removeDuplicates(int[] nums) {
        int n = nums.length, end = 0, i = 0;
        while (i < n) {
            nums[end] = nums[i];
            while (i < n && nums[i] == nums[end]) {
                i++;
            }
            end++;
        }
        return end;
    }
}
// @lc code=end

// 
// i
// e
