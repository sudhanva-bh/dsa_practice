/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        long num = 0;
        boolean isNegative = false;
        while(s.charAt(i) == ' ') i++;
        if(s.charAt(i) == '+') i++;
        else if(s.charAt(i) == '-'){
            isNegative = true;
            i++;
        }
        while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            i++;
            num = num * 10 + s.charAt(i) - '0';
            if(isNegative && num > Integer.MAX_VALUE + 1){
                return -(Integer.MAX_VALUE + 1);
            } else if(!isNegative && num > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        return (int) num;
    }
}
// @lc code=end

