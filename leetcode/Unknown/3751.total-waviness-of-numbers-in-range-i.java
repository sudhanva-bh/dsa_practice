/*
 * @lc app=leetcode id=3751 lang=java
 *
 * [3751] Total Waviness of Numbers in Range I
 */

// @lc code=start
class Solution {
    int count, n1, n2, n3;

    int calc(int num) {
        count = 0;

        n1 = num % 10;
        num /= 10;
        n2 = num % 10;
        num /= 10;
        n3 = num % 10;
        num /= 10;

        if ((n2 > n1 && n2 > n3) || (n2 < n1 && n2 < n3))
            count++;

        while (num != 0) {
            n1 = n2;
            n2 = n3;
            n3 = num % 10;
            num /= 10;

            if ((n2 > n1 && n2 > n3) || (n2 < n1 && n2 < n3))
                count++;
        }

        return count;
    }

    public int totalWaviness(int num1, int num2) {
        num1 = Math.max(num1, 100);
        int res = 0;
        for (int i = num1; i <= num2; i++) {
            res += calc(i);
        }

        return res;
    }
}
// @lc code=end
