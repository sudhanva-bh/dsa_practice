/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        rec(n, k, new ArrayList<>(k), 0);
        return res;
    }

    void rec(int n, int k, List<Integer> currList, int curr) {
        if (currList.size() == k) {
            res.add(new ArrayList<>(currList));
            return;
        }
        
        int remainingNeeded = k - currList.size();

        for (int i = curr + 1; i <= n - remainingNeeded + 1; i++) {
            currList.add(i);
            rec(n, k, currList, i);
            currList.remove(currList.size() - 1);
        }
    }
}
// @lc code=end
