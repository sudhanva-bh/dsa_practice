/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = ca.length - 1;
        while(i >= 0){
            if(ca[i] == ' ') i--;

            if (i < 0) break;
            int end = i;

            // find word start
            while (i >= 0 && s.charAt(i) != ' ') i--;
            sb.append(s.substring(i + 1, end + 1)).append(' ');
        }

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
// @lc code=end

