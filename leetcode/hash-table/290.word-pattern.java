/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] list = s.split(" +");
        if(pattern.length() != list.length) return false;

        Map<Character, String> hm = new HashMap<>();

        char[] ca = pattern.toCharArray();
        for(int i = 0; i < ca.length; i++) {
            if(!hm.containsKey(ca[i])) {
                hm.put(ca[i], list[i]);
            } else {
                if(!hm.get(ca[i]).equals(list[i])) return false;
            }
        }

        return true;
    }
}
// @lc code=end

