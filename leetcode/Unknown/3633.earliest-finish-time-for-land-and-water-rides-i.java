/*
 * @lc app=leetcode id=3633 lang=java
 *
 * [3633] Earliest Finish Time for Land and Water Rides I
 */

// @lc code=start
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = Integer.MAX_VALUE;
        int currLandEnd, currWaterEnd;
        for(int i = 0; i < landStartTime.length; i++) {
            currLandEnd = landStartTime[i] + landDuration[i];

            for(int j = 0; j < waterStartTime.length; j++) {
                currWaterEnd = Math.max(currLandEnd, waterStartTime[j]) + waterDuration[j];
                min = Math.min(currWaterEnd, min); 
            }
        }

        for(int i = 0; i < waterStartTime.length; i++) {
            currWaterEnd = waterStartTime[i] + waterDuration[i];

            for(int j = 0; j < landStartTime.length; j++) {
                currLandEnd = Math.max(currWaterEnd, landStartTime[j]) + landDuration[j];
                min = Math.min(currLandEnd, min);
            }
        }

        return min;
    }
}
// @lc code=end

