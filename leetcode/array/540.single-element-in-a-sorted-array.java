/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 */

// @lc code=start
class Solution {

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;

        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }
        int high = nums.length - 2, low = 1;

        while (high >= low) {
            int mid = low + (high - low) / 2;

            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }

            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    low = mid + 1;
                } else if (nums[mid] == nums[mid - 1]) {
                    high = mid - 1;
                }
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    high = mid - 1;
                } else if (nums[mid] == nums[mid - 1]) {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("ans " + sol.singleNonDuplicate(nums));
    }
}

// 1,1,3,3,4,4,5,8,8
// l       l   m   h
// 0 1 2 3 4 5 6 7 8
// @lc code=end

