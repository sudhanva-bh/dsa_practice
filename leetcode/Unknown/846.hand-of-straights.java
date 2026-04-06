/*
 * @lc app=leetcode id=846 lang=java
 *
 * [846] Hand of Straights
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        Map<Integer, Integer> hm = new HashMap<>();
        
        for (int i : hand) {
            hm.merge(i, 1, Integer::sum);
        }

        Queue<Integer> pQueue = new PriorityQueue<>();

        for(int i : hm.keySet()) {
            pQueue.add(i);
        }

        while(!pQueue.isEmpty()) {
            int[] temp = new int[groupSize];
            int tp = 0;

            temp[tp++] = pQueue.remove();

            for(int i = 1; i < groupSize; i++){
                temp[tp] = pQueue.remove();
                hm.put(temp[tp], hm.get(temp[tp]) - 1);
                if(temp[tp] - temp[tp - 1] != 1) return false;
                tp++;
            }

            for(int t : temp) {
                if(hm.get(t) > 0) {
                    pQueue.add(t);
                } 
            }
        }
        return true;
    }
}
// @lc code=end

