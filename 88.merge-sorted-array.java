
import java.util.Arrays;

/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ks = m + n - 1;
        int k1 = m - 1;
        int k2 = n - 1;

        while(k1 >= 0 && k2 >= 0){
            if(nums1[k1] > nums2[k2]){
                nums1[ks--] = nums1[k1--];
            } else {
                nums1[ks--] = nums2[k2--];
            }
        }

        while(k1 >= 0){
            nums1[ks--] = nums1[k1--];
        }

        while(k2 >= 0){
            nums1[ks--] = nums2[k2--];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3, n = 3;

        sol.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}

// 1,2,3,0,0,0

// 2,5,6
// @lc code=end

