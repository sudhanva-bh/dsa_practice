/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<Integer>> hm = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            char[] ca = strs[i].toCharArray();
            Arrays.sort(ca);
            String sorted = new String(ca);

            hm.putIfAbsent(sorted, new ArrayList<>());
            hm.get(sorted).add(i);
        }

        for(List<Integer> l : hm.values()) {
            List<String> resp = new ArrayList<>();
            for(int i : l) resp.add(strs[i]);

            res.add(resp);
        }

        return res;
    }
}
// @lc code=end

