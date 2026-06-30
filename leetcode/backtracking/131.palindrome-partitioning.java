/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
import java.util.*;

class Solution {
    List<List<int[]>> temp = new ArrayList<>();

    public List<List<String>> partition(String s) {
        rec(s, 0, new ArrayList<>());
        return buildResult(s);
    }

    void rec(String s, int curr, List<int[]> currList) {
        if(curr == s.length()) {
            temp.add(new ArrayList<>(currList));
            return;
        }

        for(int i = curr; i < s.length(); i++) {
            if(i == curr || isPalindrome(s, curr, i)) {
                currList.add(new int[]{curr, i + 1});
                rec(s, i + 1, currList);
                currList.remove(currList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }

    List<List<String>> buildResult(String s) {
        List<List<String>> res = new ArrayList<>(temp.size());

        for(List<int[]> l : temp) {
            List<String> curr = new ArrayList<>(l.size());
            for(int[] k : l) {
                curr.add(s.substring(k[0], k[1]));
            }

            res.add(curr);
        }

        return res;
    }
}
// @lc code=end

