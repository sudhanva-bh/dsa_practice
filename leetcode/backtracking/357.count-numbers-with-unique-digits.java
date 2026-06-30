/*
 * @lc app=leetcode id=357 lang=java
 *
 * [357] Count Numbers with Unique Digits
 */

// @lc code=start
import java.util.*;

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int ans = 1, curr;
        for(int i = 1; i <= n; i++) {
            curr = 9;
            for(int j = 1; j < i; j++) {
                curr *= (10 - j);
            }
            ans += curr;
        }

        return ans;
    }

    // int count = 0;

    // public int countNumbersWithUniqueDigits(int n) {
    //     rec(n, 0, new boolean[10], false);
    //     return count;
    // }
    
    // void rec(int n, int curr, boolean[] taken, boolean hasStart) {
    //     if (curr == n) {
    //         count++;
    //         return;
    //     }

    //     for (int i = 0; i < 10; i++) {
    //         if (!hasStart && i == 0) {
    //             rec(n, curr + 1, taken, false);
    //         } else if (!taken[i]) {
    //             taken[i] = true;
    //             rec(n, curr + 1, taken, true);
    //             taken[i] = false;
    //         }
    //     }
    // }
}
// @lc code=end
