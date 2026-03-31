/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length, start = 0, mid = 0, end = n-1;
        while(mid <= end){
            if(nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] = nums[start];
                nums[start] = temp;
                start++;
                mid++;
            } else if(nums[mid] == 2){
                int temp = nums[mid];
                nums[mid] = nums[end];
                nums[end] = temp;
                end--;
            } else {
                mid++;
            }
        }
    }
}

// [0,0,2,1,1,2]
//  s
//  m
//            e
// @lc code=end

