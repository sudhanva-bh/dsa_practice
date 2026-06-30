/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
import java.util.*;

class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        rec(n << 1, n, 0, 0, new char[n << 1], 0);
        return res;
    }

    void rec(int len, int n, int opening, int closing, char[] ca, int i) {
        // System.out.println(
        //         "len: " + len +
        //                 ", opening: " + opening +
        //                 ", closing: " + closing +
        //                 ", ca: " + java.util.Arrays.toString(ca) +
        //                 ", i: " + i);

        if (i == len) {
            res.add(new String(ca));
            return;
        }

        if (opening < n) {
            // close
            ca[i++] = '(';
            rec(len, n, opening + 1, closing, ca, i);
            i--;
        }

        if (opening > closing) {
            // open
            ca[i++] = ')';
            rec(len, n, opening, closing + 1, ca, i);
            i--;
        }
    }
}
// @lc code=end
