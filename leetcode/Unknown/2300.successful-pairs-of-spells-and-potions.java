/*
 * @lc app=leetcode id=2300 lang=java
 *
 * [2300] Successful Pairs of Spells and Potions
 */

// @lc code=start
import java.util.*;

import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        Arrays.sort(potions);

        int low, high, ans, mid;
        long currSpell;

        for(int i = 0; i < n; i++) {
            currSpell = spells[i];

            low = 0;
            high = m - 1;
            ans = m;

            while(low <= high) {
                mid = (low + high) / 2;

                if(potions[mid] * currSpell >= success) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            spells[i] = m - ans;
        }

        return spells;
    }
}
// @lc code=end
