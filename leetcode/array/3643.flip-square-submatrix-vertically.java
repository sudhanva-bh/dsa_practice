
import java.util.Arrays;

/*
 * @lc app=leetcode id=3643 lang=java
 *
 * [3643] Flip Square Submatrix Vertically
 */

// @lc code=start
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int top = x, bottom = x + k - 1;
        while(top < bottom){
            // System.out.println("Top: " + top + " Bottom: " + bottom);
            for(int i = y; i < y + k; i++){
                // System.out.printf("    Swap: grid[%d][%d] and grid[%d][%d]\n", top, i, bottom, i);
                grid[top][i] ^= grid[bottom][i];
                grid[bottom][i] ^= grid[top][i];
                grid[top][i] ^= grid[bottom][i];
            }
            top++;
            bottom--;
        }

        return grid;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int x = 1, y = 0, k = 3;

        sol.reverseSubmatrix(grid, x, y, k);

        for(int i = 0; i < grid.length; i++){
            System.out.println(Arrays.toString(grid[i]));
        }    
    }
}
// @lc code=end

