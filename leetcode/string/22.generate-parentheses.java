/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
import java.util.*;

class Solution {
    public static boolean validParanthesis(int par, int n) {
        int closing = 0;

        for(int i = n - 1; i >= 0; i--) {
            int bit = (par >> i) & 1;

            if(bit == 0) closing++;   // '('
            else closing--;           // ')'

            if(closing < 0) return false;
        }

        return closing == 0;
    }

    public static String generateParan(int par, int n) {
        char[] ca = new char[n];

        int cp = 0;
        for(int i = n - 1; i >= 0; i--) {
            int bit = (par >> i) & 1;

            if(bit == 0) ca[cp++] = '(';
            else ca[cp++] = ')';
        }

        return new String(ca);
    }

    public List<String> generateParenthesis(int n) {
        int parenLen = 2 * n;
        int max = (1 << parenLen);

        List<String> res = new ArrayList<>();

        for(int currPar = 0; currPar < max; currPar++) {
            if(Integer.bitCount(currPar) == n) {
                int closing = 0;
                int par = currPar;

                for(int i = parenLen - 1; i >= 0; i--) {
                    int bit = (par >> i) & 1;

                    if(bit == 0) closing++;   // '('
                    else closing--;           // ')'

                    if(closing < 0) break;
                }
                
                if(closing == 0) {
                    par = currPar;
                    char[] ca = new char[parenLen];

                    int cp = 0;
                    for(int i = parenLen - 1; i >= 0; i--) {
                        int bit = (par >> i) & 1;

                        if(bit == 0) ca[cp++] = '(';
                        else ca[cp++] = ')';
                    }

                    res.add(new String(ca));
                }
            }
        }

        return res;
    }
}
// @lc code=end

