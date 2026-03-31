/*
 * @lc app=leetcode id=3546 lang=java
 *
 * [3546] Equal Sum Grid Partition I
 */

// @lc code=start
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long[] colWiseSum = new long[m];
        long[] rowWiseSum = new long[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                colWiseSum[i] += grid[i][j];
                rowWiseSum[j] += grid[i][j];
            }
        }

        long leftSum = 0, rightSum = 0;
        for(int i = 0; i < m; i++){
            leftSum += colWiseSum[i];
        }

        for(int i = m - 1; i >= 0; i--){
            leftSum -= colWiseSum[i];
            rightSum += colWiseSum[i];
            if(leftSum == rightSum) return true;
        }

        leftSum = 0; rightSum = 0;
        for(int i = 0; i < n; i++){
            leftSum += rowWiseSum[i];
        }

        for(int i = n - 1; i >= 0; i--){
            leftSum -= rowWiseSum[i];
            rightSum += rowWiseSum[i];
            if(leftSum == rightSum) return true;
        }

        return false;
    }
}
// @lc code=end

