/*
 * @lc app=leetcode id=1886 lang=java
 *
 * [1886] Determine Whether Matrix Can Be Obtained By Rotation
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    static boolean isEqual(int[][] mat, int[][] tar, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != tar[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    static void rotate90(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        if(isEqual(mat, target, n)) return true;

        for(int i = 0; i < 3; i++){
            rotate90(mat);
            if(isEqual(mat, target, n)) return true;
        }
        return false;
    }
}
// @lc code=end

