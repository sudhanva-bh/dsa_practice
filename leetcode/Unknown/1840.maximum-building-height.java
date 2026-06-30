/*
 * @lc app=leetcode id=1840 lang=java
 *
 * [1840] Maximum Building Height
 */

// @lc code=start
import java.util.*;

class Solution {
    final static int x = 0, y = 1;

    public int maxBuilding(int n, int[][] restrictions) {
        if (restrictions.length == 0)
            return n - 1;

        Arrays.sort(restrictions, (a, b) -> Integer.compare(a[0], b[0]));

        int[] first = new int[] { 1, 0 };
        int[] last = new int[] { n, n - 1 };

        int[] prev = first;

        for (int[] next : restrictions) {
            limit(prev, next);
            prev = next;
        }

        if (restrictions[restrictions.length - 1][x] != n) {
            limit(prev, last);
            prev = last;
            limit(prev, restrictions[restrictions.length - 1]);
        }

        prev = restrictions[restrictions.length - 1];

        for (int i = restrictions.length - 2; i >= 0; i--) {
            limit(prev, restrictions[i]);
            prev = restrictions[i];
        }

        int max = maxBetween(first, restrictions[0]);

        for (int i = 1; i < restrictions.length; i++) {
            max = Math.max(maxBetween(restrictions[i - 1], restrictions[i]), max);
        }

        if (restrictions[restrictions.length - 1][x] != n) {
            max = Math.max(maxBetween(restrictions[restrictions.length - 1], last), max);
        }

        return max;

    }

    void limit(int[] prev, int[] next) {
        if (next[y] > prev[y])
            next[y] = Math.min(next[y], prev[y] + Math.abs(next[x] - prev[x]));
    }

    int maxBetween(int[] l1, int[] l2) {
        return (l1[y] + l2[y] + l2[x] - l1[x]) >> 1;
    }

    public static void main(String[] args) {
        new Solution().maxBuilding(0, new int[][] { { 5, 3 }, { 2, 5 }, { 7, 4 }, { 10, 3 } });
    }
}
// @lc code=end
