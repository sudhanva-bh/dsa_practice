/*
 * @lc app=leetcode id=1404 lang=java
 *
 * [1404] Number of Steps to Reduce a Number in Binary Representation to One
 */

// @lc code=start
class Solution {
    public int numSteps(String s) {
        int n = s.length();
        char[] ca = s.toCharArray();

        int i = n - 1, count = 0;
        boolean isOne = false;
        while(i > 0){
            if(ca[i] == '1') {
                count++;
                isOne = true;
                i--;
            } else if (ca[i] == '0' && isOne){
                count += 2;
                isOne = false;
                ca[i] = '1';
            } else {
                count++;
                i--;
            }
        }
        if(isOne) count += 2;
        return count;
    }
}
// @lc code=end

