/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start
import java.util.*;
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<Integer> pQueue = new PriorityQueue<>((a, b) -> b - a);

        int[] hm = new int[26];

        for(char c : tasks) {
            hm[c - 'A']++;
        }

        for(int i : hm) {
            if(i != 0) {
                pQueue.add(i);
            }
        }

        int totalTime = 0;

        while(!pQueue.isEmpty()) {
            int temp[] = new int[26];
            int tp = 0;
            int tasksDoneThisCycle = 0;
            int currCycles = n + 1;

            while(currCycles > 0 && !pQueue.isEmpty()) {
                int curr = pQueue.remove();

                if(curr > 1) {
                    temp[tp++] = curr - 1;
                }

                currCycles--;
                tasksDoneThisCycle++;
            }

            for(int i = 0; i < tp; i++) {
                pQueue.add(temp[i]);
            }

            if(pQueue.isEmpty()) {
                totalTime += tasksDoneThisCycle;
            } else {
                totalTime += n + 1;
            }
        }

        return totalTime;
    }
}
// @lc code=end

