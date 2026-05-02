/*
 * @lc app=leetcode id=2211 lang=java
 *
 * [2211] Count Collisions on a Road
 */

// @lc code=start
class Solution {
    public int countCollisions(String directions) {
        int right = 0, count = 0;
        boolean stop = false;

        for(char c : directions.toCharArray()) {
            if(c == 'R') {
                right++;
            } else if(c == 'L') {
                if(right == 0) {
                    if(stop) count++;
                } else {
                    stop = true;
                    count += right + 1;
                    right = 0;
                }
            } else if(c == 'S') {
                count += right;
                right = 0;
                stop = true;
            }
        }

        return count;
    }
}
// @lc code=end

