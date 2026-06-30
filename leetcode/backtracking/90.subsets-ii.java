/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int[] freq = new int[21];
        for (int i : nums)
            freq[i + 10]++;

        int k = 0;
        for (int i = 0; i < 21; i++) {
            while (freq[i]-- > 0) {
                nums[k++] = i - 10;
            }
        }

        rec(nums, 0, new ArrayList<>(nums.length));

        return res;
    }

    void rec(int[] nums, int curr, List<Integer> currList) {
        if (curr == nums.length) {
            res.add(new ArrayList<>(currList));
            return;
        }

        int next = curr + 1;
        currList.add(nums[curr]);
        rec(nums, next, currList);
        currList.remove(currList.size() - 1);
        
        while (next < nums.length && nums[next] == nums[curr])
            next++;
        rec(nums, next, currList);
    }
}
// @lc code=end
