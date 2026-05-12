/*
 * @lc app=leetcode id=1665 lang=java
 *
 * [1665] Minimum Initial Energy to Finish Tasks
 */

// @lc code=start
import java.util.*;

class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt((int[] a) -> a[1]).reversed());
        
        int minEffort = 0;
        int currEffort = 0;

        for(int[] t : tasks) {
            if(t[0] > currEffort) {
                minEffort += t[1] - currEffort;
                currEffort = t[1];
            }
            currEffort -= t[0];
        }

        return minEffort;
    }
}
// @lc code=end
