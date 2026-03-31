/*
 * @lc app=leetcode id=1903 lang=java
 *
 * [1903] Largest Odd Number in String
 */

// @lc code=start
class Solution {
    public String largestOddNumber(String num) {
        char[] numsArray = num.toCharArray();
        int n = numsArray.length;
        for(int i = n - 1; i >= 0; i--){
            if(numsArray[i]%2 == 1) {
                num.substring(0, i+1);
            }
        }
        return "";
    }
}


// @lc code=end

