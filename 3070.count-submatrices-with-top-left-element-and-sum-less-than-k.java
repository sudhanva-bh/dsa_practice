/*
 * @lc app=leetcode id=3070 lang=java
 *
 * [3070] Count Submatrices with Top-Left Element and Sum Less Than k
 */

// @lc code=start
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        int[] topSum = new int[m];

        for(int i = 0; i < n; i++){
            int currSum = 0;
            for(int j = 0; j < m; j++){
                topSum[j] += grid[i][j];
                currSum += topSum[j];

                if(currSum <= k) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}
// @lc code=end

