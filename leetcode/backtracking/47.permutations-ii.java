/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] freq = new int[21];
        for(int i : nums) freq[i + 10]++;
        int k = 0;
        for(int i = 0; i < 21; i++) {
            while(freq[i]-- > 0) {
                nums[k++] = i - 10;
            }
        }

        rec(nums, new ArrayList<>(nums.length), new boolean[nums.length]);

        return res;
    }

    void rec(int[] nums, List<Integer> currList, boolean[] taken) {
        if(currList.size() == nums.length) {
            res.add(new ArrayList<>(currList));
        }

        for(int i = 0; i < nums.length; i++) {
            if(taken[i]) continue;

            if(i > 0 && nums[i - 1] == nums[i]) continue;

            taken[i] = true;
            currList.add(nums[i]);
            rec(nums, currList, taken);
            currList.remove(currList.size() - 1);
            taken[i] = false;
        }
    }
}
// @lc code=end

