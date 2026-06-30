/*
 * @lc app=leetcode id=3737 lang=java
 *
 * [3737] Count Subarrays With Majority Element I
 */

// @lc code=start
import java.util.*;

class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int res = 0;

        boolean found = false;

        for (int i : nums)
            if (i == target) {
                found = true;
                break;
            }
        
        if(!found) return 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0, len = 0;
            for (int j = i; j < nums.length; j++) {
                len++;
                if(nums[j] == target) count++;

                if(count > (len >> 1)) res++;
            }
        }

        return res;
    }
}
// @lc code=end
