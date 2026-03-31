/*
 * @lc app=leetcode id=1922 lang=java
 *
 * [1922] Count Good Numbers
 */

// @lc code=start
class Solution {
    public long modularExp(long a, long b, int mod){
        long result = 1;
        a %= mod;

        while(b != 0){
            if((b & 1) == 1){
                result = (result * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }

        return result;
    }

    public int countGoodNumbers(long n) {
        int MOD = 1000000007;

        long evenSpots = 1004;
        long oddSpots = n / 2;
        
        return (int) ((modularExp(5, evenSpots, MOD) * modularExp(4, oddSpots, MOD)) % MOD);
    }
}

// @lc code=end

