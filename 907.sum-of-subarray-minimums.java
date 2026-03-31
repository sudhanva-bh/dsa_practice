/*
 * @lc app=leetcode id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 */

// @lc code=start
class Solution {

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] stack = new int[n];
        int top = -1;

        int[] nextLesserElement = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (top != -1 && arr[i] < arr[stack[top]]) {
                top--;
            }

            if (top == -1) {
                nextLesserElement[i] = n;
            } else {
                nextLesserElement[i] = stack[top];
            }

            stack[++top] = i;
        }

        top = -1;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            while (top != -1 && arr[i] <= arr[stack[top]]) {
                top--;
            }

            int curr;
            if (top == -1) {
                curr = -1;
            } else {
                curr = stack[top];
            }

            long MOD = 1000000007;

            long left = i - curr;
            long right = nextLesserElement[i] - i;

            long contribution = ((arr[i] % MOD) * (left % MOD)) % MOD;
            contribution = (contribution * (right % MOD)) % MOD;

            ans = (ans + contribution) % MOD;

            stack[++top] = i;
        }

        return (int) (ans % 1000000007);
    }
}
// @lc code=end

