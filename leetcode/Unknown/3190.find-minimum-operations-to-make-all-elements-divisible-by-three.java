/*
 * @lc app=leetcode id=3190 lang=java
 *
 * [3190] Find Minimum Operations to Make All Elements Divisible by Three
 */

// @lc code=start
class Solution {
    public int minimumOperations(int[] nums) {
        int res = 0;
        for(int i : nums) if(i % 3 != 0) res++;
        return res;
    }
}
// @lc code=end

