/*
 * @lc app=leetcode id=2840 lang=java
 *
 * [2840] Check if Strings Can be Made Equal With Operations II
 */

// @lc code=start
class Solution {
    public boolean checkStrings(String s1, String s2) {
        char[] ca1 = s1.toCharArray(), ca2 = s2.toCharArray();
        int[] hm = new int[26];

        int n = ca1.length;

        for(int i = 0; i < n; i += 2){
            hm[ca1[i] - 'a']++;
            hm[ca2[i] - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(hm[i] != 0) return false;
        }

        for(int i = 1; i < n; i += 2){
            hm[ca1[i] - 'a']++;
            hm[ca2[i] - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(hm[i] != 0) return false;
        }

        return true;
    }
}
// @lc code=end

