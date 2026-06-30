/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 */

// @lc code=start
import java.util.*;

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i : nums) max = Math.max(max, i);

        int[] freq = new int[max + 1];
        for(int i : nums) freq[i]++;

        if(max == 0) return freq[0];

        int prev2 = 0;
        int prev1 = freq[1];
        int curr;

        for(int i = 2; i <= max; i++) {
            curr = Math.max(freq[i] * i + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
// @lc code=end

