/*
 * @lc app=leetcode id=1758 lang=java
 *
 * [1758] Minimum Changes To Make Alternating Binary String
 */

// @lc code=start
class Solution {
    public int minOperations(String s) {
        int even1 = 0, odd1 = 0, n = s.length();
        char[] ca = s.toCharArray();
        for(int i = 0; i < n; i += 2){
            even1 += ca[i] - '0';
        }
        
        for(int i = 1; i < n; i += 2){
            odd1 += ca[i] - '0';
        }

        int even0 = (n + 1) / 2 - even1, odd0 = n / 2 - odd1;

        // num changes to make all odd 0 and all even 1: odd1 + even0
        // num changes to make all even 0 and all odd 1: even1 + odd0
        // System.out.println("even1: " + even1 + " odd1: " + odd1);
        // System.out.println("even0: " + even0 + " odd0: " + odd0);
        return Math.min(odd1 + even0, even1 + odd0);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minOperations("0100"));
    }
}
// @lc code=end

