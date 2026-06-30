/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start
import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int s : stones) {
            pq.add(s);
        }

        int high, low;

        while(pq.size() > 1) {
            high = pq.remove();
            low = pq.remove();

            pq.add(high - low);
        }

        return pq.peek();
    }
}
// @lc code=end

