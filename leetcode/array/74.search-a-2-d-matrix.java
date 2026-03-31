/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {

    public boolean searchMatrix(int[][] mat, int target) {
        int low = 0, high = mat.length - 1, targetRow = -1;
        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (mat[mid][0] <= target) {
                targetRow = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (targetRow == -1) {
            return false;
        }

        low = 0;
        high = mat[targetRow].length - 1;

        while (high >= low) {
            int mid = low + (high - low) / 2;

            if (mat[targetRow][mid] == target) {
                return true;
            }
            if (mat[targetRow][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
// @lc code=end

