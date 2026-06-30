/*
 * @lc app=leetcode id=2215 lang=java
 *
 * [2215] Find the Difference of Two Arrays
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean[] nums1hm = new boolean[2001];
        boolean[] nums2hm = new boolean[2001];

        for(int i : nums1) {
            nums1hm[i + 1000] = true;
        }

        for(int i : nums2) {
            nums2hm[i + 1000] = true;
        }

        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();

        for(int i = 0; i < 2001; i++) {
            if(nums1hm[i] && !nums2hm[i]) {
                res1.add(i - 1000);
            } else if(nums2hm[i] && !nums1hm[i]) {
                res2.add(i - 1000);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(res1);
        res.add(res2);

        return res;
    }
}
// @lc code=end

