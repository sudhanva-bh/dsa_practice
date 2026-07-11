/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 */

// @lc code=start
import java.util.*;

class Solution {
    // int[] hm;
    
    public int combinationSum4(int[] nums, int target) {
        // hm = new int[target + 1];
        // Arrays.fill(hm, -1);
        // return rec(nums, target);

        int[] dp = new int[target + 1];
        dp[0] = 1;

        Arrays.sort(nums);

        for(int i = 0; i <= target; i++) {
            for(int j : nums) {
                if(i + j > target) break;
                dp[i + j] += dp[i];
            }
        }

        return dp[target];
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // public int rec(int[] nums, int target) {
    //     if(target == 0) return 1;
    //     if(hm[target] != -1) return hm[target];

    //     int sum = 0;
    //     for(int i : nums) {
    //         if(target >= i) sum += rec(nums, target - i);
    //     }
        
    //     hm[target] = sum;
    //     return sum;
    // }
}
// @lc code=end

