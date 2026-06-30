/*
 * @lc app=leetcode id=2423 lang=java
 *
 * [2423] Remove Letter To Equalize Frequency
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray())
            freq[c - 'a']++;

        int[] distinct = new int[101];
        
        for(int i : freq) distinct[i]++;

        int prev = -1, count = 0;

        for(int i = 0; i < 101; i++) {
            if(distinct[i] != 0) {
                count++;
                if(count == 1) {
                    prev = i;
                } else if(count == 2) {
                    return i - prev == 1;
                }
            }
        }

        return true;
    }
}
// @lc code=end
