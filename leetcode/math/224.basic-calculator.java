/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
import java.util.*;

class Solution {
    List<Integer> convertToPostfix(String s) {
        Stack<Integer> st = new Stack<>();

        List<Integer> al = new ArrayList<>();

        char c;
        int curr = 0;

        // + or - -1, -2
        // ( = -2

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                curr = (curr * 10) + (c - '0');
            } else {
                if (curr != 0) {
                    al.add(curr);
                    curr = 0;
                }

                if (c == ' ')
                    continue;
                if (c == '(') {
                    st.push(-3);
                } else if (c == ')') {
                    while (!st.isEmpty() && st.peek() != -3) {
                        al.add(st.pop());
                    }
                    
                    if (!st.isEmpty())
                        st.pop();
                } else {
                    while (!st.isEmpty()) {
                        al.add(st.pop());
                    }
                    st.push(c == '+' ? -1 : -2);
                }
            }
        }

        while (!st.isEmpty()) {
            al.add(st.pop());
        }

        return al;
    }

    public int calculate(String s) {
        s = s.trim();
        if (s.charAt(0) == '-')
            return calculate("0" + s);
        List<Integer> al = convertToPostfix(s);

        Stack<Integer> st = new Stack<>();

        int num1, num2;

        for (int i : al) {
            if (i >= 0)
                st.push(i);
            else {
                num2 = st.pop();
                num1 = st.pop();
                if (i == -1) {
                    st.push(num1 + num2);
                } else {
                    st.push(num1 - num2);
                }
            }
        }

        return st.peek();
    }
}
// @lc code=end
