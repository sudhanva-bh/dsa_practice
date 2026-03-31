/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
import java.util.*;

class MedianFinder {
    Queue<Integer> left = new PriorityQueue<>();
    Queue<Integer> right = new PriorityQueue<>(Comparator.reverseOrder());

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(left.isEmpty()) {
            left.add(num);
        } else if(left.peek() < num) {
            left.add(num);
            if(left.size() > right.size() + 1) {
                right.add(left.remove());
            }
        } else {
            right.add(num);
            if(right.size() > left.size() + 1) {
                left.add(right.remove());
            }
        }
    }
    
    public double findMedian() {
        int ls = left.size(), rs = right.size();

        if(ls == rs) return (left.peek() + right.peek()) / 2.0;
        else if(ls > rs) return left.peek();
        return right.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end
