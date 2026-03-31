
import java.util.*;

/*
 * @lc app=leetcode id=3719 lang=java
 *
 * [3719] Longest Balanced Subarray I
 */

// @lc code=start
class Solution {

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            // System.out.println("i: " + i);
            Map<Integer, Integer> hashMap = new HashMap<>();
            int even = 0, odd = 0;
            for (int j = i; j < n; j++) {
                // System.out.println("  j: " + j + " nums[j]: " + nums[j]);
                hashMap.put(nums[j], hashMap.getOrDefault(nums[j], 0) + 1);
                // System.out.println("    hashmap[nums[j]]: " + hashMap.get(nums[j]));
                if (hashMap.get(nums[j]) == 1) {
                    if (nums[j] % 2 == 0) {
                        even++; 
                    }else {
                        odd++;
                    }
                }
                // System.out.println("    even: " + even + " odd: " + odd);
                if (odd == even) {
                    max = Math.max(max, j - i + 1);
                    // System.out.println("->>>>>> Max updated: " + max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{1, 2, 3, 2};
        // System.out.println(sol.longestBalanced(nums));
    }
}
// @lc code=end

