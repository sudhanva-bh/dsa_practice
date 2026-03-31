/*
 * @lc app=leetcode id=371 lang=java
 *
 * [371] Sum of Two Integers
 */

// @lc code=start
class Solution {

    public int getSum(int a, int b) {
        int cin = 0, result = 0, mask = 1;
        // include cin in condition so final carry is handled
        while (a != 0 || b != 0 || cin != 0) {
            int da = a & 1;
            int db = b & 1;
            int bit = da ^ db ^ cin;          // sum bit (0 or 1)
            result ^= (bit * mask);          // place the bit (multiply by mask, no +)
            cin = (da & db) | (db & cin) | (cin & da);
            a = a >>> 1;                     // unsigned shift to avoid sign-extension loops
            b = b >>> 1;
            mask <<= 1;                      // move mask to next bit (no +)
        }
        return result;
    }
}

// @lc code=end

