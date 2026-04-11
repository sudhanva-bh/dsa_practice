/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        if(x <= 3) return 1;

        int low = 0, high = x / 2;

        int ans = 0;

        while(low < high) {
            int mid = low + (high - low) / 2;
            
            if((long) mid * mid <= (long) x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
// @lc code=end

