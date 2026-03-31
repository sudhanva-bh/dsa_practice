/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        for(int i : nums){
            x = x ^ i;
        }
        return x;
    }
}
// @lc code=end
