/*
 * @lc app=leetcode id=2614 lang=java
 *
 * [2614] Prime In Diagonal
 */

// @lc code=start
import java.util.*;

class Solution {

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if ((n & 1) == 0) return false;

        for (int i = 3; i <= n / i; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int diagonalPrime(int[][] nums) {
        int max = 0;
        int n = nums.length;
        int curr;

        for(int i = 0; i < n; i++) {
            curr = nums[i][i];
            if(isPrime(curr) && curr > max) {
                max = curr;
            }
        }

        for(int i = 0; i < n; i++) {
            curr = nums[i][n - i - 1];
            if(isPrime(curr) && curr > max) {
                max = curr;
            }
        }

        return max;
    }
}
// @lc code=end
