/*
 * @lc app=leetcode id=2553 lang=java
 *
 * [2553] Separate the Digits in an Array
 */

// @lc code=start
class Solution {

    void reverseAndNumDigits(int[] nums, int[] digits, int i) {
        if (nums[i] == 0) {
            digits[i] = 1;
            return;
        }

        int count = 0;
        int rev = 0;
        int num = nums[i];

        while (num != 0) {
            count++;
            rev = (rev * 10) + (num % 10);
            num /= 10;
        }

        digits[i] = count;
        nums[i] = rev;
    }

    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        int[] digits = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            reverseAndNumDigits(nums, digits, i);
            sum += digits[i];
        }

        int[] res = new int[sum];
        int p = 0;

        for (int i = 0; i < n; i++) {
            int j = digits[i];

            if (nums[i] == 0) {
                res[p++] = 0;
                continue;
            }

            while (j-- > 0) {
                res[p++] = nums[i] % 10;
                nums[i] /= 10;
            }
        }

        return res;
    }
}
// @lc code=end
