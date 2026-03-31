
import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */
// @lc code=start
class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        System.out.println("Input string: " + s);

        for (char c : s.toCharArray()) {
            System.out.println("\nProcessing character: " + c);

            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
                System.out.println("Opening bracket found. Pushed to stack: " + c);
                System.out.println("Current stack: " + stack);
            } else {
                System.out.println("Closing bracket found: " + c);
                char top = stack.pop();
                System.out.println("Popped from stack: " + top);

                System.out.println("c - top :" + (c - top));
                if (Math.abs(c - top) > 2) {
                    System.out.println("Mismatch detected! '" + top + "' does not match '" + c + "'");
                    return false;
                }

                System.out.println("Brackets matched successfully.");
                System.out.println("Current stack: " + stack);
            }
        }

        System.out.println("\nFinished processing all characters.");
        System.out.println("Is stack empty? " + stack.isEmpty());

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid("({{{{}}}))"));
    }
}
// @lc code=end

