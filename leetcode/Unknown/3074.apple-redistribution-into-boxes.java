/*
 * @lc app=leetcode id=3074 lang=java
 *
 * [3074] Apple Redistribution into Boxes
 */

// @lc code=start
import java.util.*;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int a : apple) sum += a;

        Arrays.sort(capacity);

        for(int i = capacity.length - 1; i >= 0; i--) {
            sum -= capacity[i];
            if(sum <= 0) return capacity.length - i;
        }

        return -1;
    }
}
// @lc code=end

