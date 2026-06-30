/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        rec(0, target, candidates, new ArrayList<>());
        return res;
    }

    void rec(int start, int target, int[] candidates, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(start > 0 && candidates[i] == candidates[i-1]) continue;
            if(target < candidates[i]) break;

            curr.add(candidates[i]);
            rec(i + 1, target - candidates[i], candidates, curr);
            curr.remove(curr.size() - 1);

        }
    }
}
// @lc code=end


