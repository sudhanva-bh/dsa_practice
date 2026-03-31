/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
class Solution {
    static boolean canShip(int[] weights, int days, int capacity){
        int currentDays = 0, currentWeight = 0;

        for(int iWeight : weights){
            if(currentWeight + iWeight <= capacity){
                currentWeight += iWeight;
            } else {
                currentDays++;
                if(currentDays > days) return false;
                currentWeight = iWeight;
            }
        }
        return true;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int high = weights[0], low = weights[0];
        for(int i : weights){
            high = Math.max(high, i);
            low = Math.min(low, i);
        }

        int ans = high;

        while(high >= low){
            int mid = low + (high - low) / 2;
            if(canShip(weights, days, mid)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
// @lc code=end

