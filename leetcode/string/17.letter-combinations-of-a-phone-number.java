/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        char[][] ref = {
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'} 
        };   
        
        Queue<Integer> queue = new ArrayDeque<>(Math.powExact(3, digits.length()));

        char[] ca = digits.toCharArray();
        for(char c : ref[ca[0] - '0']){
            queue.add(c - 'a');
        }

        for(int i = 1; i < ca.length; i++) {
            int queueLen = queue.size();
            char[] currToAppend = ref[ca[i] - '0'];

            for(int j = 0; j < queueLen; j++) {
                int curr = queue.remove() * 26;
                for(char c : currToAppend) {
                    queue.add(curr + (c - 'a'));
                }
            }
        }

        List<String> res = new ArrayList<>(queue.size());

        for(int i : queue) {
            res.add(convertToAlphabet(i, digits.length()));
        }

        return res;
    }

    public static String convertToAlphabet(int i, int n) {
        char[] temp = new char[n];
        for(int j = n - 1; j >= 0; j--) {
            temp[j] = (char)(i % 26 + 'a');
            i /= 26;
        }

        return new String(temp);
    }
}
// @lc code=end

