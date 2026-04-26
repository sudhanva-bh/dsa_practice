/*
 * @lc app=leetcode id=3488 lang=java
 *
 * [3488] Closest Equal Element Queries
 */

// @lc code=start
import java.util.*;

class Solution {
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    int binarySearch(Pair[] arr, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid].second == target) {
                return mid;
            } else if(target < arr[mid].second) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Pair[] pairs = new Pair[nums.length];
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            pairs[i].first = nums[i];
            pairs[i].second = i;
        }

        Arrays.sort(pairs, (a, b) -> a.first - b.first);

        HashMap<Integer, Pair> hm = new HashMap<>();

        int l = 0, r = 0;
        while(r <= n) {
            if(pairs[r].first != pairs[l].first) {
                hm.put(pairs[l].first, new Pair(l, r - 1));
                l = r;
            }
            r++;
        }
        hm.put(pairs[l].first, new Pair(l, r - 1));


        for(int q : queries) {
            int target = nums[q];
            Pair firstLast = hm.get(target);
            if(firstLast.first == firstLast.second) {
                res.add(-1);
            } else {
                int foundAt = binarySearch(pairs, q, firstLast.first, firstLast.second);
                int minDist = Integer.MAX_VALUE;

                // Check the immediate left neighbor
                if (foundAt > firstLast.first) {
                    minDist = Math.min(minDist, Math.abs(q - pairs[foundAt - 1].second));
                }
                // Check the immediate right neighbor
                if (foundAt < firstLast.second) {
                    minDist = Math.min(minDist, Math.abs(pairs[foundAt + 1].second - q));
                }

                res.add(minDist);
            }
        }

        return res;
    }
}
// @lc code=end

