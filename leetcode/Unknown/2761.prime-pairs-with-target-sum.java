/*
 * @lc app=leetcode id=2761 lang=java
 *
 * [2761] Prime Pairs With Target Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

import java.util.*;

class Solution {

    static final int MAX = 1_000_001;

    static boolean[] isComposite = new boolean[MAX + 1];
    static List<Integer> primes = new ArrayList<>();

    static {

        isComposite[0] = true;
        isComposite[1] = true;

        // Build sieve
        for (int p = 2; p <= MAX / p; p++) {
            if (!isComposite[p]) {

                for (int i = p * p; i <= MAX; i += p) {
                    isComposite[i] = true;
                }
            }
        }

        // Collect all primes
        for (int i = 2; i <= MAX; i++) {
            if (!isComposite[i]) {
                primes.add(i);
            }
        }
    }

    public List<List<Integer>> findPrimePairs(int n) {

        List<List<Integer>> res = new ArrayList<>();

        for (int p : primes) {

            if (p > n / 2) break;

            int m = n - p;

            if (!isComposite[m]) {

                List<Integer> temp = new ArrayList<>(2);

                temp.add(p);
                temp.add(m);

                res.add(temp);
            }
        }

        return res;
    }
}
// @lc code=end
