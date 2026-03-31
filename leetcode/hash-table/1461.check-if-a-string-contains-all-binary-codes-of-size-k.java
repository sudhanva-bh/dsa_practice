
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=1461 lang=java
 *
 * [1461] Check If a String Contains All Binary Codes of Size K
 */
// @lc code=start
class Solution {

    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if (n < (1 << k) + (k - 1)) {
            return false;
        }
        Set<String> set = new HashSet<>();
        int i = 0;
        while (i <= n - k) {
            set.add(s.substring(i, i + k));
            System.out.println(set);
            i++;
        }
        return set.size() == (1 << k);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001";
        int k = 1;
        System.out.println(sol.hasAllCodes(s, k));
    }
}

class Solution {

    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        int n = s.length();

        if (n < k || n - k + 1 < need) {
            return false;
        }

        boolean[] seen = new boolean[need];
        int hash = 0;
        int allOnes = need - 1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            hash = ((hash << 1) & allOnes) | (s.charAt(i) - '0');
            if (i >= k - 1) {
                if (!seen[hash]) {
                    seen[hash] = true;
                    count++;
                    if (count == need) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
// @lc code=end

