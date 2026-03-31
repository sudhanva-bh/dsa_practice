
import java.util.*;

/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */

// @lc code=start
class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {}
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        int s = queue.size();

        for(int i = 1; i < s; i++){
            queue.add(queue.poll());
        }

        return queue.poll();
    }
    
    public int top() {
        int s = queue.size();

        for(int i = 1; i < s; i++){
            queue.add(queue.poll());
        }

        int ans = queue.peek();
        queue.add(queue.poll());

        return ans;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

