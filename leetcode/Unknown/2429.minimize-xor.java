/*
 * @lc app=leetcode id=2429 lang=java
 *
 * [2429] Minimize XOR
 */

// @lc code=start
import java.util.*;

import java.util.*;

class Solution {
    public int minimizeXor(int num1, int num2) {
        int x = Integer.bitCount(num2);

        int res = 0;
        int currPos = 1 << 31 - Integer.numberOfLeadingZeros(num1);

        while (x > 0 && currPos > 0) {
            if ((num1 & currPos) != 0) {
                res |= currPos;
                x--;
            }
            currPos >>= 1;
        }
        
        currPos = 1;

        while (x > 0) {
            if ((res & currPos) == 0) {
                res |= currPos;
                x--;
            }
            currPos <<= 1;
        }

        return res;
    }
}
// @lc code=end
