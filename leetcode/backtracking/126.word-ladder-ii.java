/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
import java.util.*;

import java.util.*;

class Solution {
    List<List<String>> res;
    int len = Integer.MAX_VALUE;

    Map<String, List<String>> adj;
    Set<String> visited;

    List<String> currList = new ArrayList<>();

    String endWord;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return new ArrayList<>();

        if (!wordList.contains(beginWord))
            wordList.add(beginWord);

        adj = new HashMap<>();
        visited = new HashSet<>();
        this.endWord = endWord;

        for (String word : wordList) {
            adj.put(word, new ArrayList<>());
        }

        int n = wordList.size();

        for (int i = 0; i < n - 1; i++) {
            String w1 = wordList.get(i);

            for (int j = i + 1; j < n; j++) {
                String w2 = wordList.get(j);

                if (differsByOne(w1, w2)) {
                    adj.get(w1).add(w2);
                    adj.get(w2).add(w1);
                }
            }
        }

        visited.add(beginWord);
        currList.add(beginWord);

        rec(beginWord);

        return res;
    }

    void rec(String currWord) {
        if (currList.size() >= len)
            return;
        if (currWord.equals(endWord)) {
            if (currList.size() < len) {
                len = currList.size();
                res = new ArrayList<>();
                res.add(new ArrayList<>(currList));
            } else if (currList.size() == len) {
                res.add(new ArrayList<>(currList));
            }
            return;
        }

        for (String next : adj.get(currWord)) {
            if (!visited.contains(next)) {
                visited.add(next);
                currList.add(next);

                rec(next);

                currList.remove(currList.size() - 1);
                visited.remove(next);
            }
        }
    }

    boolean differsByOne(String s1, String s2) {
        boolean found = false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (found)
                    return false;
                found = true;
            }
        }

        return found;
    }
}
// @lc code=end
