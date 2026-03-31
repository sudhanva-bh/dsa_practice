/*
 * @lc app=leetcode id=3567 lang=java
 *
 * [3567] Minimum Absolute Difference in Sliding Submatrix
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int nm = m - k + 1;
        int nn = n - k + 1;

        int[][] res = new int[nm][nn];

        int[] temp = new int[k*k];

        for(int i = 0; i < nm; i++){
            for(int j = 0; j < nn; j++){
                for(int p = 0; p < k; p++){
                    for(int r = 0; r < k; r++){
                        temp[k * p + r] = Math.abs(grid[i + p][j + r]);
                    }
                }
                Arrays.sort(temp);
                int min = Integer.MAX_VALUE;
                for(int p = 1; p < k * k; p++){
                    if(temp[p] != temp[p - 1]){
                        min = Math.min(min, temp[p] - temp[p - 1]);
                    }
                }
                res[i][j] = min;
            }
        }

        return res;
    }
}
// @lc code=end

