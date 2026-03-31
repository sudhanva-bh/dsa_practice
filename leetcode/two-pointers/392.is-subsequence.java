/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {

    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int sPointer = 0;

        for(int tPointer = 0; tPointer < tLen; tPointer++){
            if(s.charAt(sPointer) == t.charAt(tPointer)){
                sPointer++;
            }
            if(sPointer == sLen) return true;
        }

        return false;
    }
}
// @lc code=end

