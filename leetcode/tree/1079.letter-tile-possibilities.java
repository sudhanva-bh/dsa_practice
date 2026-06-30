/*
 * @lc app=leetcode id=1079 lang=java
 *
 * [1079] Letter Tile Possibilities
 */

// @lc code=start
import java.util.*;

class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for(char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        } 

        return dfs(freq);
    }

    int dfs(int[] freq) {
        int count = 0;

        for(int i = 0; i < 26; i++) {
            if(freq[i] == 0) continue;

            count++;

            freq[i]--;
            count += dfs(freq);
            freq[i]++;
        }

        return count;
    }
}
// @lc code=end

