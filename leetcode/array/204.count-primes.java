
import java.util.Arrays;



/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] arr = new boolean[n];
        for(int i = 2; i < n; i++){
            if(!arr[i]){
                count++;
                int curr = i * 2;
                while(curr < n){
                    arr[curr] = true;
                    curr += i;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countPrimes(10));
    }
}
// @lc code=end

