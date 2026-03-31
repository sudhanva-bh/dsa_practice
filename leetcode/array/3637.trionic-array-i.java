/*
 * @lc app=leetcode id=3637 lang=java
 *
 * [3637] Trionic Array I
 */

// @lc code=start
class Solution {

    public boolean isTrionic(int[] nums) {
        int i = 0, j, n = nums.length;

        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if(i == 0) return false;
        j = i;

        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }
        if(i == j) return false;
        j = i;

        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        return i == n - 1 && j < i;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{1, 3, 5, 4, 2, 6};
        System.out.println(sol.isTrionic(nums));
    }
}
// @lc code=end

