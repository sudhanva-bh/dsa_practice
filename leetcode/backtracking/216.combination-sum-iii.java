/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        rec(1, n, new ArrayList<>(), k);
        return res;
    }

    void rec(int start, int target, List<Integer> curr, int k) {
        if(target == 0) {
            if(curr.size() == k) res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = start; i < 10; i++) {
            if(target >= i) {
                curr.add(i);
                rec(i + 1, target - i, curr, k);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
// @lc code=end

