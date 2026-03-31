/*
 * @lc app=leetcode id=1594 lang=java
 *
 * [1594] Maximum Non Negative Product in a Matrix
 */

// @lc code=start
class Solution {
    int max = -1;
    int MOD = 1000000007;
    public void maxProductPathHelper(int[][] grid, int m, int n, int i, int j, int currentProduct){
        currentProduct = (int) (((long) currentProduct * grid[i][j])) % MOD;

        if(i == m - 1 && j == n - 1) {
            if(currentProduct > max) max = currentProduct;
            return;
        }

        if(i != m - 1) maxProductPathHelper(grid, m, n, i + 1, j, currentProduct);
        if(j != n - 1) maxProductPathHelper(grid, m, n, i, j + 1, currentProduct);
    }

    public int maxProductPath(int[][] grid) {
        maxProductPathHelper(grid, grid.length, grid[0].length, 0, 0, 1);

        return max;
    }
}
// @lc code=end

