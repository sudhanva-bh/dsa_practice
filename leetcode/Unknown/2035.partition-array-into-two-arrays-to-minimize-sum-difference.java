/*
 * @lc app=leetcode id=2035 lang=java
 *
 * [2035] Partition Array Into Two Arrays to Minimize Sum Difference
 */

// @lc code=start
import java.util.*;

class Solution {
    int minDiff = Integer.MAX_VALUE;
    int total;
    int n;

    HashMap<Long, Integer> hm = new HashMap<>();

    public int minimumDifference(int[] nums) {
        n = nums.length / 2;

        for (int x : nums)
            total += x;

        rec(nums, 0, 0, 0);

        return minDiff;
    }

    void rec(int[] nums, int curr, int chosen, int sum1) {
        if (chosen > n)
            return;

        if (curr == nums.length) {
            if (chosen == n) {
                int sum2 = total - sum1;
                minDiff = Math.min(minDiff, Math.abs(sum1 - sum2));
            }
            return;
        }

        // take in 1
        rec(nums, curr + 1, chosen + 1, sum1 + nums[curr]);

        // take in 2
        rec(nums, curr + 1, chosen, sum1);
    }
}
// @lc code=end

