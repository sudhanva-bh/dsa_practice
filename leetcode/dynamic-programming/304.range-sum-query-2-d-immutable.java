/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {
    int[][] preSum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        preSum = new int[m][n];
        int currSum = 0;
        for(int i = 0; i < n; i++) {
            currSum += matrix[0][i];
            preSum[0][i] = currSum;
        }

        for(int i = 1; i < m; i++) {
            currSum = 0;
            for(int j = 0; j < n; j++) {
                currSum += matrix[i][j];
                preSum[i][j] = currSum + preSum[i - 1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = preSum[row2][col2];

        if(row1 > 0) {
            res -= preSum[row1 - 1][col2];
        }

        if(col1 > 0) {
            res -= preSum[row2][col1 - 1];
        }

        if(row1 > 0 && col1 > 0) {
            res += preSum[row1 - 1][col1 - 1];
        }
        
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

