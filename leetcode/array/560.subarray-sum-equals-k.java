/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0, n = nums.length, curr = 0;

        hm.put(0, 1);
        for(int i = 0; i < n; i++){
            curr += nums[i];
            count += hm.get(curr - k);
            hm.put(curr, hm.getOrDefault(curr, 0) + 1);
        }

        return count;
    }
}
// @lc code=end

