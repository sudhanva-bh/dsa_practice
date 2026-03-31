/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<Integer> grayCode(int n) {
        int len = 1 << n;
        List<Integer> res = new ArrayList<>(len);
        for(int i = 0; i < len; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}
// @lc code=end

