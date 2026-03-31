/*
 * @lc app=leetcode id=3212 lang=java
 *
 * [3212] Count Submatrices With Equal Frequency of X and Y
 */

// @lc code=start
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        int[] topDiff = new int[m];
        boolean[] topContainsX = new boolean[m];
        
        for(int i = 0; i < n; i++){
            int currDiff = 0;
            boolean currContainsX = false;

            for(int j = 0; j < m; j++){
                if (grid[i][j] == 'X') {
                    topDiff[j]++;
                    topContainsX[j] = true;
                } else if (grid[i][j] == 'Y') {
                    topDiff[j]--;
                }

                currDiff += topDiff[j];
                currContainsX |= topContainsX[j];

                if(currContainsX && currDiff == 0) count++;
            }
        }

        return count;
    }
}
// @lc code=end

