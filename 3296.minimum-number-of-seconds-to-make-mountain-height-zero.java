
import java.util.*;

/*
 * @lc app=leetcode id=3296 lang=java
 *
 * [3296] Minimum Number of Seconds to Make Mountain Height Zero
 */
// @lc code=start
class Solution {

    int maxHeight(long t, int w) {
        long k = 2 * t / w;
        return (int) ((-1 + Math.sqrt(1 + 4.0 * k)) / 2);
    }

    boolean canMineIn(int mountainHeight, int[] workerTimes, long t) {
        long total = 0;

        for (int w : workerTimes) {
            if (t < w) {
                continue;
            }

            total += maxHeight(t, w);

            if (total >= mountainHeight) {
                return true;
            }
        }

        return false;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        int maxW = 0;
        for (int w : workerTimes) {
            maxW = Math.max(maxW, w);
        }

        long low = 0;
        long high = (long) maxW * mountainHeight * (mountainHeight + 1) / 2;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canMineIn(mountainHeight, workerTimes, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
// @lc code=end

