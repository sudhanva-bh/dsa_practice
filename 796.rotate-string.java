/*
 * @lc app=leetcode id=796 lang=java
 *
 * [796] Rotate String
 */

// @lc code=start
class Solution {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String c = goal + goal;
        return c.contains(s);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rotateString("abcde", "cdeab")); // true (2 shifts)
        System.out.println(sol.rotateString("abcde", "abced")); // false (same chars, wrong order)
        System.out.println(sol.rotateString("abcde", "abcde")); // true (0 shifts)
        System.out.println(sol.rotateString("abcde", "bcdea")); // true (1 shift)
        System.out.println(sol.rotateString("abcde", "eabcd")); // true (4 shifts)

        System.out.println(sol.rotateString("a", "a"));         // true (single char)
        System.out.println(sol.rotateString("a", "b"));         // false

        System.out.println(sol.rotateString("", ""));            // true (both empty)
        System.out.println(sol.rotateString("aa", "aa"));        // true (repeated chars)
        System.out.println(sol.rotateString("aa", "a"));         // false (length mismatch)

        System.out.println(sol.rotateString("abab", "baba"));    // true
        System.out.println(sol.rotateString("abab", "abba"));    // false

        System.out.println(sol.rotateString("waterbottle", "erbottlewat")); // true (classic case)
        System.out.println(sol.rotateString("rotation", "tationro"));       // true
        System.out.println(sol.rotateString("rotation", "tionrota"));       // false

    }
}
// @lc code=end

// s =      abcde
// goal =   cdeab
