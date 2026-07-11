/*
 * @lc app=leetcode id=1301 lang=java
 *
 * [1301] Number of Paths with Max Score
 */

// @lc code=start
import java.util.*;

class Solution {
    char[][] ca;
    int m, n;
    final static long MOD = 1_000_000_007;
    int[][][] dp;
    final static int SUM = 0, WAYS = 1;

    public int[] pathsWithMaxScore(List<String> board) {
        m = board.size();
        n = board.get(0).length();

        ca = new char[m][];
        for (int i = 0; i < m; i++) {
            ca[i] = board.get(i).toCharArray();
        }

        dp = new int[m][n][];
        dp[0][0] = new int[] { 0, 1 };

        int[] ans = rec(m - 1, n - 1);

        if (ans[SUM] == -1)
            return new int[] { 0, 0 };

        return ans;
    }

    int[] rec(int x, int y) {
        if (x < 0 || y < 0)
            return null;

        if (dp[x][y] != null)
            return dp[x][y];

        char c = ca[x][y];
        if (c == 'X')
            return dp[x][y] = new int[] { -1, 0 };

        int[] curr = new int[] { -1, 0 };

        int[] choice = rec(x - 1, y);
        helper(curr, choice);

        choice = rec(x - 1, y - 1);
        helper(curr, choice);

        choice = rec(x, y - 1);
        helper(curr, choice);

        if (curr[SUM] != -1 && Character.isDigit(c)) {
            curr[SUM] += c - '0';
        }

        return dp[x][y] = curr;
    }

    void helper(int[] curr, int[] choice) {
        if (choice != null && choice[SUM] != -1) {
            if (choice[SUM] > curr[SUM]) {
                curr[SUM] = choice[SUM];
                curr[WAYS] = choice[WAYS];
            } else if (choice[SUM] == curr[SUM]) {
                long newWays = (long) curr[WAYS] + choice[WAYS];
                curr[WAYS] = (int) (newWays % MOD);
            }
        }
    }
}

// @lc code=end
