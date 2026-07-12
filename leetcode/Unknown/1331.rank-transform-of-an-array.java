/*
 * @lc app=leetcode id=1331 lang=java
 *
 * [1331] Rank Transform of an Array
 */

// @lc code=start
import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] ranks = new int[n];
        if(n == 0) return ranks;

        int[][] arrIndex = new int[n][];

        for (int i = 0; i < n; i++) {
            arrIndex[i] = new int[] { arr[i], i };
        }

        Arrays.sort(arrIndex, (a, b) -> Integer.compare(a[0], b[0]));

        int currRank = 1;
        int curr = arrIndex[0][0];


        for (int[] entry : arrIndex) {
            if (entry[0] != curr) {
                curr = entry[0];
                currRank++;
            }
            ranks[entry[1]] = currRank;
        }

        return ranks;
    }
}
// @lc code=end
