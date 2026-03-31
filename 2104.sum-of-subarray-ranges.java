/*
 * @lc app=leetcode id=2104 lang=java
 *
 * [2104] Sum of Subarray Ranges
 */

// @lc code=start
class Solution {

    public long subArrayRanges(int[] arr) {
        int n = arr.length;

        int[] nle = new int[n];
        int[] nge = new int[n];

        int[] stack1 = new int[n];
        int top1 = -1;

        int[] stack2 = new int[n];
        int top2 = -1;

        for (int i = n - 1; i >= 0; i--) {
            while (top1 != -1 && arr[i] <= arr[stack1[top1]]) {
                top1--;
            }

            nle[i] = (top1 == -1) ? n : stack1[top1];
            stack1[++top1] = i;

            while (top2 != -1 && arr[i] >= arr[stack2[top2]]) {
                top2--;
            }

            nge[i] = (top2 == -1) ? n : stack2[top2];
            stack2[++top2] = i;
        }

        long sum = 0;
        top1 = -1;
        top2 = -1;

        for (int i = 0; i < n; i++) {
            while (top1 != -1 && arr[i] < arr[stack1[top1]]) {
                top1--;
            }
            int curr1 = (top1 == -1) ? -1 : stack1[top1];

            sum -= (long) arr[i] * (nle[i] - i) * (i - curr1);
            stack1[++top1] = i;

            while (top2 != -1 && arr[i] > arr[stack2[top2]]) {
                top2--; 
            }
            int curr2 = (top2 == -1) ? -1 : stack2[top2];

            sum += (long) arr[i] * (nge[i] - i) * (i - curr2);
            stack2[++top2] = i;
        }

        return sum;
    }
}
// @lc code=end

