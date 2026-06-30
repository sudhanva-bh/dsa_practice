/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */

// @lc code=start
import java.util.*;

class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        rec(s, -1, new ArrayList<>(3));
        return res;
    }

    boolean isValidPart(String s, int start, int end) {
        int len = end - start + 1;

        if (len > 1 && s.charAt(start) == '0')
            return false;
        if (len > 3)
            return false;

        int num = 0;
        for (int i = start; i <= end; i++) {
            num = num * 10 + (s.charAt(i) - '0');
        }

        // System.out.println(num);
        return num <= 255;
    }

    String buildString(String s, List<Integer> currDots) {
        sb.setLength(0);

        sb.append(s, 0, currDots.get(0) + 1);
        sb.append('.');
        sb.append(s, currDots.get(0) + 1, currDots.get(1) + 1);
        sb.append('.');
        sb.append(s, currDots.get(1) + 1, currDots.get(2) + 1);
        sb.append('.');
        sb.append(s, currDots.get(2) + 1, s.length());

        return sb.toString();
    }

    void rec(String s, int curr, List<Integer> currDots) {
        if (currDots.size() == 3) {
            // System.out.println("currDots: " + currDots);
            // System.out.println("result: " + buildString(s, currDots));
            if (currDots.get(2) == s.length() - 1 || s.length() - currDots.get(2) > 4
                    || !isValidPart(s, currDots.get(2) + 1, s.length() - 1)) {
                // System.out.println(currDots.get(2) == s.length() - 1);
                // System.out.println(s.length() - currDots.get(2) > 4);
                // System.out.println(!isValidPart(s, curr, s.length() - 1));
                // System.out.println("Rejected\n");
                return;

            }
            // System.out.println("Accepted\n");

            res.add(buildString(s, currDots));
            return;
        }

        curr++;

        for (int i = 0; i < 3 && curr + i < s.length(); i++) {
            if (i == 2 && !isValidPart(s, curr, curr + i))
                break;
            currDots.add(curr + i);
            rec(s, curr + i, currDots);
            currDots.remove(currDots.size() - 1);
            if (i == 0 && s.charAt(curr) == '0')
                break;
        }

    }
}
// @lc code=end
