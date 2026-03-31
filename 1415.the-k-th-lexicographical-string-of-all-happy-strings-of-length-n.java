import java.util.*;
/*
 * @lc app=leetcode id=1415 lang=java
 *
 * [1415] The k-th Lexicographical String of All Happy Strings of Length n
 */

// @lc code=start
class Solution {
    List<String> nthHappyString(int n, int target, List<String> prevList) {
        int strLen = prevList.get(0).length();
        List<String> newList = new ArrayList<String>(prevList.size() * 2);

        for (String s : prevList) {
            char c = s.charAt(strLen - 1);
            if (c != 'a') {
                newList.add(s + "a");
            }
            if (c != 'b') {
                newList.add(s + "b");
            }
            if (c != 'c') {
                newList.add(s + "c");
            }
        }
        System.out.println("n: " + n);
        System.out.println("target: " + target);
        System.out.println(prevList);

        System.out.println(newList + "\n");

        if (n == target)
            return newList;
        return nthHappyString(n + 1, target, newList);
    }

    public String getHappyString(int n, int k) {
        if (k > 3 * Math.pow(2, n - 1))
            return "";
        List<String> ls = new ArrayList<>(List.of("a", "b", "c"));
        if (n == 1)
            return ls.get(k - 1);
        List<String> res = nthHappyString(2, n, ls);
        System.out.println(res);

        return res.get(k - 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getHappyString(3, 9));
    }
}
// @lc code=end
