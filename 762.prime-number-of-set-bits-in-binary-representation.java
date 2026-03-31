/*
 * @lc app=leetcode id=762 lang=java
 *
 * [762] Prime Number of Set Bits in Binary Representation
 */

// @lc code=start
class Solution {

    static boolean isPrime(int n) {
        return n == 2 || n == 3 || n == 5 || n == 7 || n == 11 || n == 13 || n == 17 || n == 19 || n == 23 || n == 29 || n == 31;
    }

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countPrimeSetBits(6, 10));
    }
}
// @lc code=end

