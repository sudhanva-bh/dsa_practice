// // User function Template for Java

// class Solution {

//     public static boolean isOperator(char c) {
//         return c == '+' || c == '-' || c == '^' || c == '/' || c == '*';
//     }

//     public static int prec(char c) {
//         if (c == '^') // Exponent operator has highest precedence
//         {
//             return 3;
//         } else if (c == '/' || c == '*') // Multiplication and division have higher precedence than addition
//         {
//             return 2;
//         } else if (c == '+' || c == '-') // Addition and subtraction have lowest precedence
//         {
//             return 1;
//         } else {
//             return -1;
//         }
//     }

//     public static String infixToPostfix(String s) {
//         Stack<Character> stack = new Stack<>();
//         StringBuilder sb = new StringBuilder(s.length());

//         for (char c : s.toCharArray()) {
//             if (isOperator(c)) {
//                 while (!stack.isEmpty()
//                         && (prec(c) < prec(stack.peek())
//                         || (prec(c) == prec(stack.peek()) && c != '^'))) {
//                     sb.append(stack.pop());
//                 }
//                 stack.push(c);
//             } else if (c == '(') {
//                 stack.add(c);
//             } else if (c == ')') {
//                 while (stack.peek() != '(') {
//                     sb.append(stack.pop());
//                 }
//                 stack.pop();
//             } else if (c == ' ') {
//             } else {
//                 sb.append(c);
//             }
//         }

//         while (!stack.isEmpty()) {
//             sb.append(stack.pop());
//         }
//         return sb.toString();
//     }

//     static String preToInfix(String pre_exp) {
//         Stack<String> stack = new Stack<>();

//         char[] ca = pre_exp.toCharArray();
//         int n = pre_exp.length();

//         for (int i = n - 1; i >= 0; i--) {
//             if (ca[i] == ' ') {

//             } else if (!isOperator(ca[i])) {
//                 stack.push(String.valueOf(ca[i]));
//             } else {
//                 String s1 = stack.pop();
//                 String s2 = stack.pop();

//                 String res = "(" + s1 + ca[i] + s2 + ")";
//                 stack.push(res);
//             }
//         }
//         return stack.peek();
//     }

//     static String preToPost(String pre_exp) {
//         // code here
//         return infixToPostfix(preToInfix(pre_exp));
//     }
// }
