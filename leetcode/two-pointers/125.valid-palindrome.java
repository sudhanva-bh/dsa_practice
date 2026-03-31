/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        char[] ca = s.toCharArray();
        int i = 0;
        for(char c : ca){
            if(Character.isLetterOrDigit(c)){
                ca[i++] = Character.toLowerCase(c);
            }
        }

        int j = 0, k = i - 1;
        while(j<k){
            if(ca[j] == ca[k]){
                j++; k--;
            } else {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

