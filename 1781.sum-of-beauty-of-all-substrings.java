
import java.util.HashMap;

/*
 * @lc app=leetcode id=1781 lang=java
 *
 * [1781] Sum of Beauty of All Substrings
 */

// @lc code=start
class Solution {
    public int beautySum(String s) {
        int result = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            HashMap<Character, Integer> freq = new HashMap<>();
            for(int j = i; j < n; j++){
                freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                for (int val : freq.values()) {
                    min = Math.min(min, val);
                    max = Math.max(max, val);
                }
                
                result += (max - min);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.beautySum("aabcbaa"));
    }
}
// @lc code=end

