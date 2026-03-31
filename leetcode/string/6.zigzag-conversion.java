/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        int n = s.length();
        int cycle = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder(n);

        // First row
        for (int i = 0; i < n; i += cycle) {
            sb.append(s.charAt(i));
        }

        // Middle rows
        for (int row = 1; row < numRows - 1; row++) {
            for (int i = row; i < n; i += cycle) {
                sb.append(s.charAt(i));

                int diag = i + cycle - 2 * row;
                if (diag < n) {
                    sb.append(s.charAt(diag));
                }
            }
        }

        // Last row
        for (int i = numRows - 1; i < n; i += cycle) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
// @lc code=end

