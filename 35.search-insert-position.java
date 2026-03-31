/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int high = n - 1, low = 0;
        int ans = n;

        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
// @lc code=end

// tar: 2
// 1,3,5,6,7,7,7,8,8,9
// l m   h          
//   a
