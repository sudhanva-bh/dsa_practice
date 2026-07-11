/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
import java.util.*;

class Solution {
    char[] str, pat;

    byte[][] dp;

    public boolean isMatch(String ss, String ps) {
        str = ss.toCharArray();
        pat = ps.toCharArray();

        dp = new byte[str.length + 1][pat.length + 1];

        return rec(0, 0);
    }

    boolean rec(int iStr, int iPat) {
        if (iStr == str.length && iPat == pat.length) {
            return true;
        }

        if (iPat == pat.length) {
            return false;
        }

        if (dp[iStr][iPat] != 0) {
            return dp[iStr][iPat] == 1;
        }

        if (iStr == str.length) {
            int cache = iPat;
            while (iPat < pat.length) {
                if (pat[iPat++] != '*') {
                    dp[iStr][cache] = 2;
                    return false;
                }
            }

            return true;
        }

        if (pat[iPat] == '?') {
            if (rec(iStr + 1, iPat + 1)) {
                dp[iStr][iPat] = 1;
                return true;
            }
        } else if (pat[iPat] == '*') {
            // consume+next
            if (rec(iStr + 1, iPat + 1)) {
                dp[iStr][iPat] = 1;
                return true;
            }

            // consume
            if (rec(iStr + 1, iPat)) {
                dp[iStr][iPat] = 1;
                return true;
            }

            // next
            if (rec(iStr, iPat + 1)) {
                dp[iStr][iPat] = 1;
                return true;
            }
        } else {
            if (str[iStr] == pat[iPat]) {
                if (rec(iStr + 1, iPat + 1)) {
                    dp[iStr][iPat] = 1;
                    return true;
                }
            }
        }

        dp[iStr][iPat] = 2;
        return false;
    }
}
// @lc code=end
