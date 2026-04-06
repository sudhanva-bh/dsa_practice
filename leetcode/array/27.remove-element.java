/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0, j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                count++;
            } else {
                nums[j++] = nums[i];
            }
        }
        // System.out.println(Arrays.toString(nums));
        return nums.length - count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(sol.removeElement(arr, val));
    }
}
// @lc code=end

