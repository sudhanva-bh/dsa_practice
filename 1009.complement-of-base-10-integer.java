/*
 * @lc app=leetcode id=1009 lang=java
 *
 * [1009] Complement of Base 10 Integer
 */

// @lc code=start
class Solution {

    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 0;
        int pow = 1;
        // System.out.println(n + ": " + Integer.toBinaryString(n));
        // System.out.println(result + ": " + Integer.toBinaryString(result));
        // System.out.println();
        while (n != 0) {
            result += pow * ((n & 1) == 1 ? 0 : 1);
            pow <<= 1;
            n >>= 1;
            // System.out.println(n + ": " + Integer.toBinaryString(n));
            // System.out.println(result + ": " + Integer.toBinaryString(result));
            // System.out.println();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 10;
        // System.out.println(sol.bitwiseComplement(n));
    }
}
// @lc code=end

