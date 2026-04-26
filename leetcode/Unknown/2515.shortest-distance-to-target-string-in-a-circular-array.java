/*
 * @lc app=leetcode id=2515 lang=java
 *
 * [2515] Shortest Distance to Target String in a Circular Array
 */

// @lc code=start
class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int npsi = n + startIndex;

        for(int i = 0; i < (n / 2)+ 1; i++) {
            if(words[(startIndex + i) % n].equals(target) || words[(npsi - i) % n].equals(target)) {
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end

