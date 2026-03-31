
import java.util.Random;

/*
 * @lc app=leetcode id=696 lang=java
 *
 * [696] Count Binary Substrings
 */

// @lc code=start
class Solution {

    public int countBinarySubstrings(String s) {
        int n = s.length();
        char[] ca = s.toCharArray();

        int c0 = 0, c1 = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (ca[i] == '0') {
                c0++;
                if(i + 1 == n || ca[i + 1] == '1'){
                    ans += Math.min(c0, c1);
                    c1 = 0;
                }
            } else {
                c1++;
                if(i + 1 == n || ca[i + 1] == '0'){
                    ans += Math.min(c0, c1);
                    c0 = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 100000 - 1;   // 10^5 - 1
        Random random = new Random();
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            sb.append(random.nextBoolean() ? '1' : '0');
        }

        String binaryString = sb.toString();
        System.out.println(binaryString);
    }
}
// @lc code=end

