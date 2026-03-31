/*
 * @lc app=leetcode id=2149 lang=java
 *
 * [2149] Rearrange Array Elements by Sign
 */

// @lc code=start
class Solution {

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int posPointer = 0;
        int negPointer = 0;

        for (int i : nums) {
            if (i > 0) {
                output[2 * posPointer++] = i;
            } else {
                output[2 * negPointer++ + 1] = i;
            }
        }
        return output;
    }
}
// @lc code=end

