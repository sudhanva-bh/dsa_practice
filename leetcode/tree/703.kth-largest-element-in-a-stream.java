/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */

// @lc code=start
import java.util.*;

class KthLargest {
    Queue<Integer> pQueue = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i : nums) {
            if(pQueue.size() < k){
                pQueue.add(i);
            } else if(pQueue.peek() < i){
                pQueue.poll();
                pQueue.add(i);
            }
        }
    }
    
    public int add(int val) {
        if(pQueue.size() < k) {
            pQueue.add(val);
        } else if (pQueue.peek() < val){
            pQueue.poll();
            pQueue.add(val);
        }

        return pQueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end

