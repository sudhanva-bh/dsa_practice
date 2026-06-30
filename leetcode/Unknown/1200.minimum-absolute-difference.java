/*
 * @lc app=leetcode id=1200 lang=java
 *
 * [1200] Minimum Absolute Difference
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] nums) {
        Arrays.sort(nums);

        int minDiff = nums[1] - nums[0];

        for(int i = 2; i < nums.length; i++) {
            minDiff = Math.min(minDiff, nums[i] - nums[i - 1]);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i - 1] == minDiff) {
                List<Integer> curr = new ArrayList<>(2);
                curr.add(nums[i - 1]);
                curr.add(nums[i]);

                res.add(curr);
            } 
        }

        return res;
    }
}
// @lc code=end

