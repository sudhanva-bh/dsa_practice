
import java.util.Arrays;

/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */
// @lc code=start
class Solution {

    public int[] searchRange(int[] nums, int target) {
        int ansL = -1, ansH = -1;
        int n = nums.length;
        int high = n - 1, low = 0;

        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ansL = mid;
                ansH = mid;
                break;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (ansL != -1) {
            int highL = ansL, lowL = low;
            while (highL >= lowL) {
                int mid = lowL + (highL - lowL) / 2;
                if (nums[mid] < target) {
                    lowL = mid + 1;
                } else if (nums[mid] > target) {
                    highL = mid - 1;
                } else {
                    highL = mid - 1;
                    ansL = mid;
                }
            }
            int highH = high, lowH = ansH;
            while (highH >= lowH) {
                int mid = lowH + (highH - lowH) / 2;
                if (nums[mid] > target) {
                    highH = mid - 1;
                } else if (nums[mid] < target) {
                    lowH = mid + 1;
                } else {
                    lowH = mid + 1;
                    ansH = mid;
                }
            }
        }
        return new int[]{ansL, ansH};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{1, 1, 1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 6, 7, 7, 7};
        int target = 7;
        System.out.println(Arrays.toString(sol.searchRange(arr, target)));
    }
}
// @lc code=end

