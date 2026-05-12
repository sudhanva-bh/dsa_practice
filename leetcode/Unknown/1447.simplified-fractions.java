/*
 * @lc app=leetcode id=1447 lang=java
 *
 * [1447] Simplified Fractions
 */

// @lc code=start
import java.util.*;

class Solution {
    public static boolean isCoprime(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a == 1;
    }

    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>(n * (n - 1) / 2);
        for (int den = 2; den <= n; den++) {
            for (int num = 1; num < den; num++) {
                if(isCoprime(num, den)) res.add(num + "/" + den);
            }
        }

        return res;
    }
}
// @lc code=end
