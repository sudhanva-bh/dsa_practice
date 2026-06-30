/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start

import java.util.*;

class Solution {
    List<Integer> inToPost(String s) {
        boolean building = false;
        Stack<Integer> stack = new Stack<>();
        List<Integer> al = new ArrayList<>();
        int curr = 0, op, prec, top, topPrec;

        // * -> -1
        // / -> -2
        // + -> -3
        // - -> -4

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                building = true;
                curr = (curr * 10) + (c - '0');
                continue;
            }

            if (c == ' ') {
                continue;
            }

            if (building) {
                al.add(curr);
                curr = 0;
                building = false;
            }

            if (c == '*')
                op = -1;
            else if (c == '/')
                op = -2;
            else if (c == '+')
                op = -3;
            else
                op = -4; // '-'

            prec = (op == -1 || op == -2) ? 2 : 1;

            while (!stack.isEmpty()) {
                top = stack.peek();
                topPrec = (top == -1 || top == -2) ? 2 : 1;

                if (topPrec >= prec)
                    al.add(stack.pop());
                else
                    break;
            }

            stack.push(op);
        }

        if (building)
            al.add(curr);

        while (!stack.isEmpty())
            al.add(stack.pop());

        return al;
    }

    public int calculate(String s) {
        List<Integer> al = inToPost(s);

        Stack<Integer> stack = new Stack<>();

        int num1, num2;

        for(int i : al) {
            if(i >= 0) {
                stack.push(i);
            } else {
                num2 = stack.pop();
                num1 = stack.pop();

                if(i == -1) {
                    stack.push(num1 * num2);
                } else if(i == -2) {
                    stack.push(num1 / num2);
                } else if(i == -3) {
                    stack.push(num1 + num2);
                } else {
                    stack.push(num1 - num2);
                }
            }
        }

        return stack.peek();
    }
}
// @lc code=end
