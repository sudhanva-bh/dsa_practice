import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    List<Integer>[][] dp;

    List<Integer> empty = new ArrayList<>();

    List<Integer> rec(int[] nums, int curr, int target) {
        if (dp[curr][target] != empty)
            return dp[curr][target];

        if (target == 0) {
            dp[curr][target] = new ArrayList<>();
            return dp[curr][target];
        }

        if (target < 0) {
            dp[curr][target] = null;
            return dp[curr][target];
        }

        // dont take
        List<Integer> next = rec(nums, curr + 1, target);
        if (next != null) {
            dp[curr][target] = new ArrayList<>(next);
            return dp[curr][target];
        }

        // take
        next = rec(nums, curr + 1, target - nums[curr]);
        if (next != null) {
            dp[curr][target] = new ArrayList<>(next);
            dp[curr][target].add(nums[curr]);
            return dp[curr][target];
        }

        // not possible
        dp[curr][target] = null;
        return dp[curr][target];
    }

    public List<List<Integer>> getSubsetSums(int[] nums, int[] queries) {
        int max = 0;
        for (int i : queries)
            max = Math.max(max, i);

        dp = new List[nums.length][max];

        for (List<Integer>[] l : dp) {
            Arrays.fill(l, empty);
        }

        for (int q : queries) {
            res.add(rec(nums, 0, q));
        }

        return res;
    }
}