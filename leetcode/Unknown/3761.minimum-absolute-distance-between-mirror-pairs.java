/*
 * @lc app=leetcode id=3761 lang=java
 *
 * [3761] Minimum Absolute Distance Between Mirror Pairs
 */

// @lc code=start
import java.util.*;

class Solution {
    public int reverse(int n) {
        int res = 0;
        while(n != 0) {
            res = res * 10 + (n % 10);
            n /= 10;
        } 
        return res;
    }
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();
        int minDist = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int curr = hm.getOrDefault(nums[i], -1);
            if(curr != -1) {
                minDist = Math.min(curr - 1, minDist);
            }

            hm.put(reverse(nums[i]), i);
        }
        return minDist;
    }
}
// @lc code=end

