/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, n = nums.length;
        int currZeros = 0, max = 0;

        while(right < n){
            if(nums[right++] == 0) currZeros++;
            while(left <= right && currZeros > k){
                if(nums[left++] == 0) currZeros--;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        System.out.println(sol.longestOnes(nums, k));
    }
}
// @lc code=end

