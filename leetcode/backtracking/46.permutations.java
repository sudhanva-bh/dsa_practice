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
        int n = nums.length;

        for(int i : nums) {
            res.add(new ArrayList<>(Arrays.asList(i)));
        }

        System.out.println(res);

        for(int i = 1; i < n; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> curr : res) {
                for(int j : nums) {
                    if(!curr.contains(j)) {
                        List<Integer> tempL = new ArrayList<>(curr);
                        tempL.add(j);
                        temp.add(tempL);
                    }
                }
            }
            res = temp;
            System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.permute(new int[] {1, 2, 3});
    }   
}
// @lc code=end

