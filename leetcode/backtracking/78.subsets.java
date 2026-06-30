/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        rec(nums, 0, new ArrayList<>());

        return res;
    }

    void rec(int[] nums, int curr, List<Integer> currList) {
        if(curr == nums.length) {
            res.add(new ArrayList<>(currList));
            return;
        }

        rec(nums, curr + 1, currList);
        
        currList.add(nums[curr]);
        rec(nums, curr + 1, currList);
        currList.remove(currList.size() - 1);
    }
}
// @lc code=end

