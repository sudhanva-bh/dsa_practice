/*
 * @lc app=leetcode id=2615 lang=java
 *
 * [2615] Sum of Distances
 */

// @lc code=start
import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            hm.putIfAbsent(nums[i], new ArrayList<>());
            hm.get(nums[i]).add(i);
        }

        long[] result = new long[n];

        for(List<Integer> indices : hm.values()) {
            int len = indices.size();
            long totalSum = 0;
            
            for(int idx : indices) {
                totalSum += idx;
            }

            long leftSum = 0;
            
            for(int i = 0; i < len; i++) {
                int idx = indices.get(i);
                
                long rightSum = totalSum - leftSum - idx;
    
                long leftDistance = ((long) i * idx) - leftSum;
                long rightDistance = rightSum - ((long) (len - i - 1) * idx);
                
                result[idx] = leftDistance + rightDistance;
                
                leftSum += idx;
            }
        }

        return result;
    }
}
// @lc code=end

