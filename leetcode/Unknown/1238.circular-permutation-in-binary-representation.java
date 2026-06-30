/*
 * @lc app=leetcode id=1238 lang=java
 *
 * [1238] Circular Permutation in Binary Representation
 */

// @lc code=start
import java.util.*;

class Solution {
    public static int grayToInt(int gray) {
        int num = gray;

        while (gray > 0) {
            gray >>= 1;
            num ^= gray;
        }

        return num;
    }

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();

        int len = 1 << n;
        int s = grayToInt(start);

        for (int i = 0; i < len; i++) {
            if(s == len) s = 0;
            res.add(s ^ (s >> 1));
            s++;
        }

        return res;
    }
}
// @lc code=end
