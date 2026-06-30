/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start

import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
       rec(nums, 0, new boolean[nums.length], new ArrayList<>(nums.length));
       return res;
    }

    void rec(int[] nums, int curr, boolean[] taken, List<Integer> currList) {
        if(curr == nums.length) {
            res.add(new ArrayList<>(currList));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!taken[i]) {
                taken[i] = true;
                currList.add(nums[i]);
                rec(nums, curr + 1, taken, currList);
                currList.remove(currList.size() - 1);
                taken[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.permute(new int[] {1, 2, 3});
    }   
}
// @lc code=end

