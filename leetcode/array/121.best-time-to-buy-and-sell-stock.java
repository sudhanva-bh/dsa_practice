/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {

    public int maxProfit(int[] prices) {
        int minPrice = prices[0], maxProfit = 0;
        for (int i : prices) {
            minPrice = Math.min(i, minPrice);
            maxProfit = Math.max(i - minPrice, maxProfit);
        }
        return maxProfit;
    }
}
// @lc code=end

