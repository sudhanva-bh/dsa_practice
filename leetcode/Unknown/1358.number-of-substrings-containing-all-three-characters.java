/*
 * @lc app=leetcode id=1358 lang=java
 *
 * [1358] Number of Substrings Containing All Three Characters
 */

// @lc code=start
import java.util.*;

class Solution {
    public int numberOfSubstrings(String s) {
        int[] hm = new int[3];

        char[] ca = s.toCharArray();
        int n = ca.length;

        for(int i = 0; i < n; i++) {
            ca[i] -= 'a';
            hm[ca[i]]++;
        }

        if(hm[0] == 0 || hm[1] == 0 || hm[2] == 0) return 0;

        hm = new int[3];

        // find number of substrings not having atleast one of them

        long count = 0;
        int left = 0;

        for(int right = 0; right < n; right++) {
            hm[ca[right]]++;

            while(left <= right && isValid(hm)) {
                hm[ca[left++]]--;
            }

            count += right - left + 1;
        }

        return (int) ((long) n * (n + 1) / 2 - count);
    }

    boolean isValid(int[] hm) {
        return hm[0] > 0 && hm[1] > 0 && hm[2] > 0;
    }
}
// @lc code=end
