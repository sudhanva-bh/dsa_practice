/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            int start = 0, end = n - 1;
            while (start < end) {
                int temp = matrix[end][i];
                matrix[end][i] = matrix[start][i];
                matrix[start][i] = temp;
                // int temp = matrix[i][end];
                // matrix[i][end] = matrix[i][start];
                // matrix[i][start] = temp;
                start++;
                end--;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
// @lc code=end
