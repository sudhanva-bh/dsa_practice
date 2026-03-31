/*
 * @lc app=leetcode id=313 lang=java
 *
 * [313] Super Ugly Number
 */

// @lc code=start
import java.util.*;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Queue<Integer> pQueue = new PriorityQueue<>();
        pQueue.add(1);
        for(int i = 0; i < n; i++) {
            int curr = pQueue.remove();
            for(int p : primes){
                pQueue.add(p * curr);
            }
        }

        return pQueue.remove();
    }
}
// @lc code=end

