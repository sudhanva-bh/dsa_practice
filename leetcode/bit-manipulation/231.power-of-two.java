/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        System.out.println(String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0'));
        System.out.println(String.format("%32s", Integer.toBinaryString(~n + 1)).replace(' ', '0'));
        System.out.println(String.format("%32s", Integer.toBinaryString(n - 1)).replace(' ', '0'));
        System.out.println(String.format("%32s", Integer.toBinaryString((~n + 1) | (n - 1) + 1)).replace(' ', '0'));
        return ((~n + 1) | (n - 1)) == 0xFFFFFFFF;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(3));
    }
}
// @lc code=end

