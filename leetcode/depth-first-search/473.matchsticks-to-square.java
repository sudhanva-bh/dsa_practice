/*
 * @lc app=leetcode id=473 lang=java
 *
 * [473] Matchsticks to Square
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int max = 0;
        for (int i : matchsticks)
            max += i;
        if (max % 4 != 0)
            return false;

        max /= 4;
        Arrays.sort(matchsticks);

        int left = 0;
        int right = matchsticks.length - 1;
        while (left < right) {
            int temp = matchsticks[left];
            matchsticks[left] = matchsticks[right];
            matchsticks[right] = temp;
            left++;
            right--;
        }
        
        return rec(matchsticks, new int[4], 0, max);
    }

    boolean rec(int[] matchsticks, int[] sides, int curr, int max) {
        if (curr == matchsticks.length) {
            int match = sides[0];
            for (int i : sides) {
                if (match != i)
                    return false;
            }

            return true;
        }

        int l = curr == 0 ? 1 : 4;

        for (int i = 0; i < l; i++) {
            if (i > 0 && sides[i] == sides[i - 1])
                continue;
            if (sides[i] + matchsticks[curr] > max)
                continue;
            sides[i] += matchsticks[curr];
            if (rec(matchsticks, sides, curr + 1, max))
                return true;
            sides[i] -= matchsticks[curr];

            if (sides[i] == 0)
                break;
        }

        return false;
    }
}
// @lc code=end
