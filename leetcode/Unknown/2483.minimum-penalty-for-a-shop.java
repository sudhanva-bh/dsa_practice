/*
 * @lc app=leetcode id=2483 lang=java
 *
 * [2483] Minimum Penalty for a Shop
 */

// @lc code=start
class Solution {
    public int bestClosingTime(String customers) {
        char[] ca = customers.toCharArray();

        int n = ca.length, penalty = 0;

        for(int i = 0; i < n; i++) {
            if(ca[i] == 'Y') penalty++;
        }

        if(penalty == 0) return 0;

        int minPenalty = penalty, minPenaltyHour = 0;
        
        for(int i = 0; i < n; i++) {
            if(ca[i] == 'Y') {
                penalty--;
            } else {
                penalty++;
            }

            if(minPenalty > penalty) {
                minPenalty = penalty;
                minPenaltyHour = i;
            }
        }

        return minPenaltyHour + 1;
    }
}
// @lc code=end

