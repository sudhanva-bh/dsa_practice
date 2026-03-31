
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */
// @lc code=start
class Solution {

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int curr = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while (curr < n) {
            int start = intervals[curr][0];
            int end = intervals[curr][1];
            int next = curr + 1;

            while (next < n && intervals[next][0] <= end) {
                end = Math.max(end, intervals[next][1]);
                next++;
            }

            ans.add(Arrays.asList(start, end));
            curr = next;
        }

        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }

        return res;
    }
}
// @lc code=end

