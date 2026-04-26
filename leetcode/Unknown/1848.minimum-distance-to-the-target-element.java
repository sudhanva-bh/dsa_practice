/*
 * @lc app=leetcode id=1848 lang=java
 *
 * [1848] Minimum Distance to the Target Element
 */

// @lc code=start
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;

        int minDist = Integer.MAX_VALUE;
        // go forward
        int i = start;
        while(i < n && nums[i] != target) i++;
        if(i < n && nums[i] == target) minDist = i - start;

        i = start;
        while(i >= 0 && nums[i] != target) i--;
        if(i >= 0 && nums[i] == target) minDist = Math.min(minDist, start - i);

        return minDist;
    }
}
// @lc code=end

