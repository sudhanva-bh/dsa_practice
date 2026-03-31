/*
 * @lc app=leetcode id=1539 lang=java
 *
 * [1539] Kth Missing Positive Number
 */

// @lc code=start
class Solution {

    public int findKthPositive(int[] arr, int k) {
        int high = arr.length - 1, low = 0, ans = -1;

        while (high >= low) {
            int mid = low + (high - low) / 2;

            if (arr[mid] - mid <= k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + 1 + ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int k1 = 9;
        System.out.println(sol.findKthPositive(arr1, k1)); // 17

        int[] arr2 = new int[]{2, 3, 4, 7, 11};
        int k2 = 5;
        System.out.println(sol.findKthPositive(arr2, k2)); // 9

        int[] arr3 = new int[]{1, 3, 4, 5, 7};
        int k3 = 1;
        System.out.println(sol.findKthPositive(arr3, k3)); // 2

        int[] arr4 = new int[]{1, 2, 3, 4};
        int k4 = 2;
        System.out.println(sol.findKthPositive(arr4, k4)); // 6

        int[] arr5 = new int[]{5, 6, 7, 8, 9};
        int k5 = 1;
        System.out.println(sol.findKthPositive(arr5, k5)); // 1

        int[] arr6 = new int[]{5, 6, 7, 8, 9};
        int k6 = 5;
        System.out.println(sol.findKthPositive(arr6, k6)); // 10

        int[] arr7 = new int[]{1};
        int k7 = 1;
        System.out.println(sol.findKthPositive(arr7, k7)); // 2

        int[] arr8 = new int[]{2};
        int k8 = 1;
        System.out.println(sol.findKthPositive(arr8, k8)); // 1

        int[] arr9 = new int[]{2, 4, 6, 8, 10};
        int k9 = 3;
        System.out.println(sol.findKthPositive(arr9, k9)); // 5

        int[] arr10 = new int[]{1, 10, 21, 22, 25};
        int k10 = 10;
        System.out.println(sol.findKthPositive(arr10, k10)); // 14
    }
}
// @lc code=end

