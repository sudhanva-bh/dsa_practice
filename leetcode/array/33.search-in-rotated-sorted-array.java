/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {

    static int findHigh(int[] nums) {
        int low = 0, high = nums.length - 1;

        if (nums[low] <= nums[high]) {
            return high;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int jump = findHigh(nums);
        System.out.println(jump);
        int high, low;
        if (target >= nums[0]) {
            low = 0;
            high = jump;
        } else {
            low = jump + 1;
            high = nums.length - 1;
        }
        System.out.println(low + " " + high);
        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{3, 5, 1};
        int target = 1;
        System.out.println(sol.search(nums, target));
    }
}

// 4,5,6,7,0,1,2
// @lc code=end

