/*
 * @lc app=leetcode id=1582 lang=java
 *
 * [1582] Special Positions in a Binary Matrix
 */

// @lc code=start
class Solution {

    public int numSpecial(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[] hcount = new int[rows], ccount = new int[cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                hcount[row] += mat[row][col];
                ccount[col] += mat[row][col];
            }
        }

        int count = 0;

        for (int row = 0; row < rows; row++) {
            if (hcount[row] == 1) {
                for (int col = 0; col < cols; col++) {
                    if (mat[row][col] == 1 && ccount[col] == 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
// @lc code=end

