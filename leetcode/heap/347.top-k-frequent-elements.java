/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start

import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        int[] res = new int[k];
        int rp = 0;

        Queue<Entry<Integer, Integer>> pQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));

        for(Entry<Integer, Integer> e : hm.entrySet()) {
            if(pQueue.size() < k) {
                pQueue.add(e);
            } else if(pQueue.peek().getValue() < e.getValue()) {
                pQueue.remove();
                pQueue.add(e);
            }
        }

        for(Entry<Integer, Integer> e : pQueue) {
            res[rp++] = e.getKey();
        }

        return res;
    }
}
// @lc code=end

