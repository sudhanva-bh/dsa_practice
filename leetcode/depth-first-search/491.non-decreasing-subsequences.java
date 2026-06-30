/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Non-decreasing Subsequences
 */

// @lc code=start
import java.util.*;

class Solution {
    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        rec(nums, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }

    void rec(int[] nums, int curr, List<Integer> currList) {
        if (currList.size() > 1) {
            res.add(new ArrayList<>(currList));
        }

        if (curr == nums.length)
            return;

        if (currList.size() == 0 || currList.get(currList.size() - 1) <= nums[curr]) {
            currList.add(nums[curr]);
            rec(nums, curr + 1, currList);
            currList.remove(currList.size() - 1);
        }

        rec(nums, curr + 1, currList);
    }
}
// @lc code=end
