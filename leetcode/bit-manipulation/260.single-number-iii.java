/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2) return nums;
        int xor = 0;
        for(int i : nums) {
            xor ^= i;
        }

        int diff = xor & ((~xor) + 1);
        int xor2 = 0;

        for(int i : nums) {
            if((i & diff) != 0) {
                xor2 ^= i;
            }
        }

        return new int[]{xor2, xor ^ xor2};
    }
}
// @lc code=end

