/*
 * @lc app=leetcode id=3534 lang=java
 *
 * [3534] Path Existence Queries in a Graph II
 */

// @lc code=start
import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        // indexes[k] = original index of the k-th smallest value (sorted order)
        Arrays.sort(indexes, (a, b) -> nums[a] - nums[b]);

        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[indexes[i]] = i;
        }

        int[] parent = new int[n];

        int left = 0;

        for (int right = 0; right < n; right++) {
            while (left < right && nums[indexes[right]] - nums[indexes[left]] > maxDiff) {
                left++;
            }

            if (left == right)
                parent[right] = right;
            else
                parent[right] = parent[left];
        }

        int[] farthest = new int[n];
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (right < i)
                right = i;
            while (right + 1 < n && nums[indexes[right + 1]] - nums[indexes[i]] <= maxDiff) {
                right++;
            }
            farthest[i] = right;
        }

        int LOG = 1;
        while ((1 << LOG) < n)
            LOG++;
        LOG++;

        int[][] binaryLift = new int[LOG][];

        binaryLift[0] = farthest;

        for (int i = 1; i < LOG; i++) {
            binaryLift[i] = new int[n];

            for (int j = 0; j < n; j++) {
                binaryLift[i][j] = binaryLift[i - 1][binaryLift[i - 1][j]];
            }
        }

        int m = queries.length;
        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            int[] q = queries[i];

            int low = rank[q[0]];
            int high = rank[q[1]];

            if (low == high) {
                res[i] = 0;
                continue;
            }

            if (low > high) {
                int temp = low;
                low = high;
                high = temp;
            }

            if (parent[low] != parent[high]) {
                res[i] = -1;
                continue;
            }

            int curr = low;
            int count = 0;
            for (int j = LOG - 1; j >= 0; j--) {
                int lift = binaryLift[j][curr];
                if (lift < high) {
                    curr = lift;
                    count += (1 << j);
                }
            }
            res[i] = count + 1;
        }

        return res;
    }
}
// @lc code=end
