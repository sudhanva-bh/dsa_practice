/*
 * @lc app=leetcode id=3741 lang=java
 *
 * [3741] Minimum Distance Between Three Equal Elements II
 */

// @lc code=start
import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        int[] first = new int[nums.length + 1];
        int[] second = new int[nums.length + 1];

        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < nums.length; i++) {
            int n = nums[i];
            if(first[n] != 0) {
                if(second[n] != 0) {
                    min = Math.min(min, 2 * (i - first[n]));
                    first[n] = second[n];
                    second[n] = i + 1;
                } else {
                    second[n] = i + 1;
                }
            } else {
                first[n] = i + 1;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
// @lc code=end

