/*
 * @lc app=leetcode id=1833 lang=java
 *
 * [1833] Maximum Ice Cream Bars
 */

// @lc code=start
import java.util.*;

class Solution {
    public int maxIceCream(int[] costs, int amount) {
        int max = 0;
        for(int i : costs) max = Math.max(i, max);

        int[] freq = new int[max + 1];

        for(int i : costs) freq[i]++;

        int count = 0, i = 0, units;
        long totalCost;

        while(i <= max && amount >= i) {
            totalCost = (long) i * freq[i];
            if(totalCost <= amount) {
                amount -= totalCost;
                count += freq[i];
            } else {
                count += amount / i;
                break;
            }
            i++;
        }

        return count;
    }
}
// @lc code=end

