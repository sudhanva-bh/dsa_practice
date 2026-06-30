/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 */

// @lc code=start
import java.util.*;

class Solution {
    int[] hm;
    
    public int combinationSum4(int[] nums, int target) {
        hm = new int[target + 1];
        Arrays.fill(hm, -1);
        return rec(nums, target);
    }

    public int rec(int[] nums, int target) {
        if(target == 0) return 1;
        if(hm[target] != -1) return hm[target];

        int sum = 0;
        for(int i : nums) {
            if(target >= i) sum += rec(nums, target - i);
        }
        
        hm[target] = sum;
        return sum;
    }
}
// @lc code=end

