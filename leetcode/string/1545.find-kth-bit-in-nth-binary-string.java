import java.util.*;

/*
 * @lc app=leetcode id=1545 lang=java
 *
 * [1545] Find Kth Bit in Nth Binary String
 */

// @lc code=start
class Solution {
    String reverseAndInverse(String s){
        int n = s.length();
        StringBuilder sb = new StringBuilder(n);
        for(int i = n - 1; i >= 0; i--){
            sb.append((s.charAt(i) == '0') ? '1' : '0');
        }
        return sb.toString();
    }
    String sn(int n){
        if(n == 1) return "0";
        String snm1 = sn(n - 1);
        return snm1 + "1" + reverseAndInverse(snm1); 
    }
    public char findKthBit(int n, int k) {
        String res = sn(n);
        return res.charAt(k - 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4, k = 11;
        System.out.println(sol.findKthBit(n, k));
    }
}
// @lc code=end

