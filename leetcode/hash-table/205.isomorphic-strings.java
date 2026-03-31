/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {

    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[128];
        for(int i = 0; i < s.length(); i++){
            if(map[s.charAt(i)] == 0){
                map[s.charAt(i)] = t.charAt(i) + 1;
            } else if(s.charAt(i) != t.charAt(i) + 1){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

