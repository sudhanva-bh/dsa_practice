
import java.util.*;

/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */

// @lc code=start
class Solution {

    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        
        for(int i = n - 1; i >= 0; i--){
            stack.push(arr[i]);
        }

        int[] res = new int[n];

        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[i] >= stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()){
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{1,2,3,4,3};
        System.out.println(Arrays.toString(sol.nextGreaterElements(arr)));
    }
}
// @lc code=end

