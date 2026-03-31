/*
 * @lc app=leetcode id=1423 lang=java
 *
 * [1423] Maximum Points You Can Obtain from Cards
 */

// @lc code=start
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lenSA = n - k;
        int sum = 0, totalSum, min;

        int left = 0, right = 0;

        while(right < lenSA){
            sum += cardPoints[right++];
        }

        // sum = sum of all elements [0, lenSA - 1]
        // right = n - k

        min = sum;
        totalSum = sum;

        while(right <= n){
            totalSum += cardPoints[right];
            sum += cardPoints[right++];
            sum -= cardPoints[left++];

            if(sum < min) min = sum;
        }

        return totalSum - min;
    }
}
// @lc code=end

