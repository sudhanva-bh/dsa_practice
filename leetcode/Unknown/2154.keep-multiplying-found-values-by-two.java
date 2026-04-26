/*
 * @lc app=leetcode id=2154 lang=java
 *
 * [2154] Keep Multiplying Found Values by Two
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean contains(int[] nums, int target) {
        for(int i : nums) if(i == target) return true;
        return false;
    }

    public int findFinalValue(int[] nums, int original) {
        while(contains(nums, original)) original *= 2;

        return original;
    }
}
// @lc code=end

