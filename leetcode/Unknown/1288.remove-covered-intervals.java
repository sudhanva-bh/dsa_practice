/*
 * @lc app=leetcode id=1288 lang=java
 *
 * [1288] Remove Covered Intervals
 */

// @lc code=start
import java.util.*;

class Solution {
    public int removeCoveredIntervalsN2(int[][] intervals) { 
        final int n = intervals.length;
        int count = n;

        for(int i = 0; i < n; i++) {
            int[] curr = intervals[i];
            
            for(int j = 0; j < n; j++) {
                if(i != j && aCoversB(intervals[j], curr)) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }

    boolean aCoversB(int[] a, int[] b) {
        return a[0] <= b[0] && b[1] <= a[1];
    }

    public int removeCoveredIntervalsNLogN(int[][] intervals) {
        final int START = 0, END = 1, n = intervals.length;

        Arrays.sort(intervals, (a, b) -> {
            if (a[START] != b[START])
                return Integer.compare(a[START], b[START]);
            return Integer.compare(b[END], a[END]);
        });

        int[] curr = intervals[0];
        int prevEnd = curr[END];
        int count = 0;

        for(int i = 1; i < n; i++) {
            curr = intervals[i];
            if(curr[END] > prevEnd) {
                count++;
                prevEnd = curr[END];
            }
        }

        return count;
    }
}
// @lc code=end
