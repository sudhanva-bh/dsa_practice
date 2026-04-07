/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
import java.util.*;


class Solution {
    public static String RLE(String s) {
        StringBuilder sb = new StringBuilder();

        char[] ca = s.toCharArray();
        int left = 0, right;

        for(right = 1; right < ca.length; right++) {
            if(ca[right] != ca[left]) {
                sb.append(right - left);
                sb.append(ca[right]);
                right = left;
            }
        }

        sb.append(right - left);
        sb.append(ca[right]);

        return sb.toString();
    }

    public String countAndSay(int n) {
        if(n == 1) return "1";
        return RLE(countAndSay(n - 1));
    }
}
// @lc code=end

