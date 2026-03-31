
import java.util.*;

/*
 * @lc app=leetcode id=2951 lang=java
 *
 * [2951] Find the Peaks
 */
// @lc code=start
class Solution {

    public List<Integer> findPeaks(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length - 1;

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{1, 4, 3, 8, 5};
        System.out.println(sol.findPeaks(arr));
    }
}
// @lc code=end

