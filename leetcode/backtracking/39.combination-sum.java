/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        rec(0, target, candidates, res, new ArrayList<>());

        return res;
    }

    void rec(int start, int target, int[] candidates, List<List<Integer>> res, List<Integer> curr) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            curr.add(candidates[i]);
            rec(i, target - candidates[i], candidates, res, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
// @lc code=end

