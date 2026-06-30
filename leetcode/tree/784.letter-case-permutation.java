/*
 * @lc app=leetcode id=784 lang=java
 *
 * [784] Letter Case Permutation
 */

// @lc code=start
import java.util.*;

class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        rec(0, s.toCharArray());
        return res;
    }

    void rec(int curr, char[] ca) {
        if (curr == ca.length) {
            res.add(new String(ca));
            return;
        }

        rec(curr + 1, ca);
        
        if(Character.isAlphabetic(ca[curr])) {
            ca[curr] ^= 32;
            rec(curr + 1, ca);
            ca[curr] ^= 32;
        }
    }
}
// @lc code=end
