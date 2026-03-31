/*
 * @lc app=leetcode id=1021 lang=java
 *
 * [1021] Remove Outermost Parentheses
 */

// @lc code=start
class Solution {

    public String removeOuterParentheses(String s) {
        if (s.equals("")) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int start = 0, opening = 0;
        for (int i = 0; i < n; i++) {
            if (opening == 0) {
                start = i;
                opening++;
            } else if (s.charAt(i) == '(') {
                opening++;
            } else {
                opening--;
                if (opening == 0) {
                    sb.append(s.substring(start + 1, i + 1));
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end

