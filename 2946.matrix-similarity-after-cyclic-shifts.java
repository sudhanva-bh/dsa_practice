/*
 * @lc app=leetcode id=2946 lang=java
 *
 * [2946] Matrix Similarity After Cyclic Shifts
 */

// @lc code=start
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        k = k % n;
        // System.out.println("M: " + m + " N: " + n);
        for(int i = 0; i < m; i++){
            if(i % 2 == 0){
                for(int j = 0; j < n; j++){
                    // System.out.println("i: " + i + " j: " + j + " (j + n - k) % n " + (j + n - k) % n);
                    if(mat[i][j] != mat[i][(j + n - k) % n]) return false;
                }
            } else {
                for(int j = 0; j < n; j++){
                    // System.out.println("i: " + i + " j: " + j + " (j + k) % n " + (j + k) % n);
                    if(mat[i][j] != mat[i][(j + k) % n]) return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int k = 4;
        System.out.println(sol.areSimilar(mat, k));
    }
}
// @lc code=end

