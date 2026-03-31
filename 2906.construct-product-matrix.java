/*
 * @lc app=leetcode id=2906 lang=java
 *
 * [2906] Construct Product Matrix
 */

// @lc code=start
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int MOD = 12345;
        int[] prefixProduct = new int[m*n];
        int[] suffixProduct = new int[m*n];

        prefixProduct[0] = 1;
        for(int i = 1; i < m * n; i++){
            prefixProduct[i] = (int)((long)prefixProduct[i - 1] * grid[(i - 1) / n][(i - 1) % n] % MOD);
        }

        suffixProduct[m * n - 1] = 1;
        for(int i = m * n - 2; i >= 0; i--){
            suffixProduct[i] = (int)((long)suffixProduct[i + 1] * grid[(i + 1) / n][(i + 1) % n] % MOD);
        }

        int[][] result = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int idx = i * n + j;
                result[i][j] = (int)((long)prefixProduct[idx] * suffixProduct[idx] % MOD);
            }
        }

        return result;
    }
}
// @lc code=end

