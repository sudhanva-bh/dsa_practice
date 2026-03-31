
import java.util.Stack;

// User function Template for Java
class Solution {

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '^' || c == '/' || c == '*';
    }

    static String preToInfix(String pre_exp) {
        Stack<String> stack = new Stack<>();

        char[] ca = pre_exp.toCharArray();
        int n = pre_exp.length();

        for (int i = n - 1; i >= 0; i--) {
            if (ca[i] == ' ') {

            } else if (isOperator(ca[i])) {
                stack.push(Character.toString(ca[i]));
            } else {
                String s1 = stack.pop();
                String s2 = stack.pop();

                String res = s1 + ca[i] + s1;
                stack.push(res);
            }
        }
        return stack.pop();
    }
}
