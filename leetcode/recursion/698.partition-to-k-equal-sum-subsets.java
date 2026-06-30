/*
 * @lc app=leetcode id=698 lang=java
 *
 * [698] Partition to K Equal Sum Subsets
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums)
            sum += i;

        if (sum % k != 0)
            return false;

        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, temp;
        while (left < right) {
            temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }

        return rec(nums, new int[k], 0, sum / k);
    }

    boolean rec(int[] nums, int[] currList, int curr, int max) {
        if (curr == nums.length) {
            return true;
        }

        for (int i = 0; i < currList.length; i++) {

            if (i > 0 && currList[i] == currList[i - 1])
                continue;

            if (currList[i] + nums[curr] <= max) {
                currList[i] += nums[curr];

                if (rec(nums, currList, curr + 1, max))
                    return true;

                currList[i] -= nums[curr];

                if (currList[i] == 0)
                    break;
            }
        }

        return false;
    }
}
// @lc code=end
