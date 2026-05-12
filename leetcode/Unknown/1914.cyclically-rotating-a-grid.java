/*
 * @lc app=leetcode id=1914 lang=java
 *
 * [1914] Cyclically Rotating a Grid
 */

// @lc code=start
class Solution {
    public int[][] rotateGrid(int[][] grid, int numRot) {
        int top = 0, bottom = grid.length - 1;
        int left = 0, right = grid[0].length - 1;

        int[] temp = new int[2 * (right - left) + 2 * (bottom - top)];

        while(top < bottom && left < right) {
            int len = 2 * (right - left) + 2 * (bottom - top);
            int currRot = numRot % len;
            int k = 0;

            for(int i = left; i <= right; i++) {
                temp[k++] = grid[top][i];
            }

            for(int i = top + 1; i <= bottom; i++) {
                temp[k++] = grid[i][right];
            }

            for(int i = right - 1; i >= left; i++) {
                temp[k++] = grid[bottom][i];
            }

            for(int i = bottom - 1; i > top; i++) {
                temp[k++] = grid[i][left];
            }

            // 

            k = 0;

            for(int i = left; i <= right; i++) {
                grid[top][i] = temp[(k++ + currRot) % len];
            }

            for(int i = top + 1; i <= bottom; i++) {
                grid[i][right] = temp[(k++ + currRot) % len];
            }

            for(int i = right - 1; i >= left; i++) {
                grid[bottom][i] = temp[(k++ + currRot) % len];
            }

            for(int i = bottom - 1; i > top; i++) {
                grid[i][left] = temp[(k++ + currRot) % len];
            }
        }

        return grid;
    }
}
// @lc code=end

