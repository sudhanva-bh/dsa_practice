/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 *
 * https://leetcode.com/problems/counting-bits/description/
 *
 * algorithms
 * Easy (80.20%)
 * Likes:    11789
 * Dislikes: 601
 * Total Accepted:    1.5M
 * Total Submissions: 1.9M
 * Testcase Example:  '2'
 *
 * Given an integer n, return an array ans of length n + 1 such that for each i
 * (0 <= i <= n), ans[i] is the number of 1's in the binary representation of
 * i.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 10^5
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * It is very easy to come up with a solution with a runtime of O(n log n). Can
 * you do it in linear time O(n) and possibly in a single pass?
 * Can you do it without using any built-in function (i.e., like
 * __builtin_popcount in C++)?
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        int bits = 32 - Integer.numberOfLeadingZeros(n);
        // arr[1]  = 1 + arr[0]
        // arr[2]  = 1 + arr[0]
        // arr[3]  = 1 + arr[1]
        // arr[4]  = 1 + arr[0]
        // arr[5]  = 1 + arr[1]
        // arr[6]  = 1 + arr[2]
        // arr[7]  = 1 + arr[3]
        // arr[8]  = 1 + arr[0]
        // arr[9]  = 1 + arr[1]
        // arr[10] = 1 + arr[2]
        // arr[11] = 1 + arr[3]
        // arr[12] = 1 + arr[4]
        // arr[13] = 1 + arr[5]
        // arr[14] = 1 + arr[6]
        // arr[15] = 1 + arr[7]
        // arr[16] = 1 + arr[0]

        arr[0] = 0;
        try {
            for (int i = 0; i < bits; i++) {    // 1
                int pow = (int) Math.pow(2, i); // 2
                for (int j = 0; j < pow; j++) { // = 0 - 1
                    arr[pow + j] = 1 + arr[j];
                }
            }
        } catch (Exception e) {
        }

        return arr;
    }
    
}
// @lc code=end

// [0,1,1,2,1,2,2,3,1,2,2]
// n = 0;
// 0000
// 0001
// 0010
// 0011
// 0100
// 0101
// 0110
// 0111
// 1000
// 1001
// 1010
// 1011
// 1100
// 1101
// 1110
// 1111
// all 2^n       will have 1
// all 2^n + 1   will have 2
// all 2^n + 2^m will have 2 for all n < m
