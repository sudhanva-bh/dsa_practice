
import java.util.*;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */
// @lc code=start
class Solution {

    static int isOperator(String s) {
        switch (s) {
            case "+":
                return 1;
            case "-":
                return 2;
            case "*":
                return 3;
            case "/":
                return 4;
            default:
                throw new AssertionError();
        }
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+" -> {
                    stack.push(stack.pop() + stack.pop());
                }
                case "-" -> {
                    stack.push(-(stack.pop() + stack.pop()));
                }
                case "*" -> {
                    stack.push(stack.pop() + stack.pop());
                }
                case "/" -> {
                    int a2 = stack.pop();
                    int a1 = stack.pop();
                    stack.push(a1 / a2);
                }
                default ->
                    stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
// @lc code=end

