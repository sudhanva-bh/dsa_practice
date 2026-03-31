
import java.util.Stack;

/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> dummy = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        stack.add(x);
    }
    
    public int pop() {
        int s = stack.size();

        for(int i = 1; i < s; i++){
            dummy.add(stack.pop());
        }

        int ans = stack.pop();

        for(int i = 1; i < s; i++){
            stack.add(dummy.pop());
        }

        return ans;
    }
    
    public int peek() {
        int s = stack.size();

        for(int i = 1; i < s; i++){
            dummy.add(stack.pop());
        }

        int ans = stack.peek();

        for(int i = 1; i < s; i++){
            stack.add(dummy.pop());
        }

        return ans;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

