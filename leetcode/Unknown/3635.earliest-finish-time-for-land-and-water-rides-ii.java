/*
 * @lc app=leetcode id=3635 lang=java
 *
 * [3635] Earliest Finish Time for Land and Water Rides II
 */

// @lc code=start
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ln = landStartTime.length;
        int wn = waterStartTime.length;
        
        // land -> water

        int minLandEnd = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < ln; i++) {
            minLandEnd = Math.min(minLandEnd, landStartTime[i] + landDuration[i]);
        }

        for(int i = 0; i < wn; i++) {
            min = Math.min(min, Math.max(minLandEnd, waterStartTime[i]) + waterDuration[i]);
        }

        // water -> land

        int minWaterEnd = Integer.MAX_VALUE;

        for(int i = 0; i < wn; i++) {
            minWaterEnd = Math.min(minWaterEnd, waterStartTime[i] + waterDuration[i]);
        }

        for(int i = 0; i < ln; i++) {
            min = Math.min(min, Math.max(minWaterEnd, landStartTime[i]) + landDuration[i]);
        }

        return min;
    }
}
// @lc code=end

