/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
import java.util.*;

class Solution {
    List<String> res = new ArrayList<>();
    static final char[][] ref = {
            {},
            {},
            { 'a', 'b', 'c' },
            { 'd', 'e', 'f' },
            { 'g', 'h', 'i' },
            { 'j', 'k', 'l' },
            { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' },
            { 'w', 'x', 'y', 'z' }
    };

    public List<String> letterCombinations(String digits) {
        rec(digits, 0, new char[digits.length()]);
        return res;
    }

    void rec(String digits, int curr, char[] ca) {
        if (curr == digits.length()) {
            res.add(new String(ca));
            return;
        }

        int digit = digits.charAt(curr) - '0';

        for(char c : ref[digit]) {
            ca[curr++] = c;
            rec(digits, curr, ca);
            curr--;
        }
    }
}
// @lc code=end
