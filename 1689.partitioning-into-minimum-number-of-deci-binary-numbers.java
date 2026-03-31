/*
 * @lc app=leetcode id=1689 lang=java
 *
 * [1689] Partitioning Into Minimum Number Of Deci-Binary Numbers
 */

// @lc code=start
class Solution {

    public int minPartitions(String n) {
        char max = '0';
        for (char c : n.toCharArray()) {
            System.out.println("c: " + c + " max: " + max);
            if (c > max) {
                max = c;
                System.out.println("update max: " + max);
            }
        }
        return max - '0';
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String n = "1109810937501891092348012";
        System.out.println(sol.minPartitions(n));
    }
}
// @lc code=end

