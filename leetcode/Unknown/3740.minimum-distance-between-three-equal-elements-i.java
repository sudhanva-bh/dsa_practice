/*
 * @lc app=leetcode id=3740 lang=java
 *
 * [3740] Minimum Distance Between Three Equal Elements I
 */

// @lc code=start
import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        int[] first = new int[nums.length + 1];
        int[] second = new int[nums.length + 1];

        Arrays.fill(first, -1);
        Arrays.fill(second, -1);

        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < nums.length; i++) {
            int n = nums[i];
            if(first[n] != -1) {
                if(second[n] != -1) {
                    min = Math.min(min, 2 * (i - first[n]));
                    first[n] = second[n];
                    second[n] = i;
                } else {
                    second[n] = i;
                }
            } else {
                first[n] = i;
            }
        }

        return( min == Integer.MAX_VALUE) ? -1 : min;
    }
}
// @lc code=end

