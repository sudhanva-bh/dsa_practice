/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public static double myPowHelper(double x, long n){
        if(n == 0) return 1;

        double half = myPowHelper(x, n >> 2);

        if((n & 1) == 0){
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0 || x == 1) return 1;

        long N = (long) n;

        double res = myPowHelper(x, Math.abs(N));
                
        return n < 0 ? 1 / res : res;
    }
}
// @lc code=end

