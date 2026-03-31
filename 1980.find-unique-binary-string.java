/*
 * @lc app=leetcode id=1980 lang=java
 *
 * [1980] Find Unique Binary String
 */

// @lc code=start
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char[] result = new char[n];
        for(int i = 0; i < n; i++){
            result[i] = nums[i].charAt(i) == '0' ? '1' : '0';
        }
        return new String(result);
    }
}
// @lc code=end

