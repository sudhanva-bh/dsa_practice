/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;

        while(digits[i] == 9 && i >= 0) {
            i--;
            digits[i] = 0;
        }

        if(i == -1) {
            int[] res = new int[digits.length + 1];
            int j = 0;
            res[j++] = 1;
            while(i < res.length) {
                res[i] = 0;
            }

            return res;
        }

        digits[i]++;
        return digits;
    }
}
// @lc code=end

