
import java.util.Arrays;

/*
 * @lc app=leetcode id=3379 lang=java
 *
 * [3379] Transformed Array
 */

// @lc code=start
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        for(int i = 0; i < n; i++){
            System.out.println(i);
            if(nums[i] == 0){
                output[i] = nums[i];
            } else if(nums[i] > 0){
                output[i] = nums[(i + nums[i]) % n];
            } else {
                int newIndex = (i + nums[i]) % n;
                if(newIndex < 0) newIndex = n + newIndex;
                output[i] = nums[newIndex];
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{-1,4,-1};
        System.out.println(Arrays.toString(sol.constructTransformedArray(nums)));
    }
}
// @lc code=end

