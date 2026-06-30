/*
 * @lc app=leetcode id=3020 lang=java
 *
 * [3020] Find the Maximum Number of Elements in Subset
 */

// @lc code=start
import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();

        int max = 0;
        for (int i : nums) {
            max = Math.max(i, max);
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        int intmax = 46_340;

        int ones = hm.getOrDefault(1, 0);
        if((ones & 1) == 0) ones--;

        if(ones >= nums.length >> 1) return ones;
        
        hm.remove(1);

        int res = 0;

        int count2, curr;
        boolean count1;

        for (int i : hm.keySet()) {
            count1 = false;
            count2 = 0;
            for (int j = i; j > 0 && j <= max; j *= j) {
                curr = hm.getOrDefault(j, 0);
                
                if(curr > 1) {
                    count2++;
                } else  {
                    if(curr == 1) count1 = true;
                    break;
                }

                if(j > intmax) break;
            }

            if(!count1) count2--;
            res = Math.max((count2 << 1) + 1, res);
        }

        return Math.max(res, ones);
    }
}
// @lc code=end
