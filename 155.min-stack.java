
import java.util.*;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */
// @lc code=start
class Element {

    int value;
    int min;

    Element(int value, int min) {
        this.value = value;
        this.min = min;
    }
}

class MinStack {

    int min;
    Stack<Element> stack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<Element>();
    }

    public void push(int val) {
        min = Math.min(min, val);
        stack.add(new Element(val, min));
    }

    public void pop() {
        stack.pop();
        if (!stack.isEmpty()) {
            min = stack.peek().min;
        } else {
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return min;
    }
}

class Solution {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        System.out.println(minStack.stack.toString() + " " + minStack.min);

        minStack.push(0);
        System.out.println(minStack.stack.toString() + " " + minStack.min);

        minStack.push(-3);
        System.out.println(minStack.stack.toString() + " " + minStack.min);

        System.out.println("getMin(): " + minStack.getMin());

        minStack.pop();
        System.out.println(minStack.stack.toString() + " " + minStack.min);

        System.out.println("top(): " + minStack.top());

        System.out.println("getMin(): " + minStack.getMin());

    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
 * param_4 = obj.getMin();
 */
// @lc code=end

