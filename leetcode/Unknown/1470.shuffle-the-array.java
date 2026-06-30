/*
 * @lc app=leetcode id=1470 lang=java
 *
 * [1470] Shuffle the Array
 */

// @lc code=start
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int x = 0, y = n;
        int k = 0;

        while(x < n) {
            nums[k++] |= nums[x++] << 16;
            nums[k++] |= nums[y++] << 16;
        }

        k = 0;

        while(k < n + n) {
            nums[k++] >>= 16;
        }

        return nums;
    }
}
// @lc code=end

