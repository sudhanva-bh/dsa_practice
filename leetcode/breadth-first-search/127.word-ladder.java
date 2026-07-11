/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hs = new HashSet<>(wordList);
        hs.add(beginWord);

        if(!hs.contains(endWord)) return 0;

        Queue<String> queue = new ArrayDeque<>();

        queue.add(beginWord);
        hs.remove(beginWord);

        int currDist = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            currDist++;

            while(size-- > 0) {
                
            }
        }
    }
}
// @lc code=end
