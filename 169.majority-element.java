/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, current = 0;
        for(int i : nums) {
            if(count == 0){
                current = i;
                count = 1;
            } else if(i == current){
                count++;
            } else count--;
        }
        return current;
    }
}
// @lc code=end