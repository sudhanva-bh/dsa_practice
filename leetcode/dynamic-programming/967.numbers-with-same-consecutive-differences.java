/*
 * @lc app=leetcode id=967 lang=java
 *
 * [967] Numbers With Same Consecutive Differences
 */

// @lc code=start
import java.util.*;

class Solution {
    List<Integer> res;

    public int[] numsSameConsecDiff(int n, int k) {
        if (k == 0) {
            int[] res = new int[9];
            for (int i = 1; i < 10; i++) {
                int num = 0;
                for (int j = 0; j < n; j++) {
                    num = num * 10 + i;
                }
                res[i - 1] = num;
            }

            return res;
        }

        res = new ArrayList<>();
        rec(n, k, 0, 0);
        
        int[] resArr = new int[res.size()];
        for(int i = 0; i < resArr.length; i++) {
            resArr[i] = res.get(i);
        }

        return resArr;
    }

    void rec(int n, int k, int curr, int currNum) {
        if (curr == n) {
            res.add(currNum);
            return;
        }

        if (curr == 0) {
            curr++;
            for (int i = 1; i < 10; i++) {
                currNum = i;
                rec(n, k, curr, currNum);
                currNum = 0;
            }
        } else {
            if((currNum % 10) + k <= 9) rec(n, k, curr + 1, (currNum * 10) + (currNum % 10) + k); 
            if((currNum % 10) - k >= 0) rec(n, k, curr + 1, (currNum * 10) + (currNum % 10) - k); 
        }
    }
}
// @lc code=end
