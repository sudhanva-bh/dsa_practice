/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// @lc code=start
import java.util.*;

class Solution {
    int[][] graph;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        List<Integer> al = new ArrayList<>();
        al.add(0);
        rec(0, al);

        return res;
    }

    void rec(int curr, List<Integer> path) {
        if (curr == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        int lenCache = path.size();

        for (int i : graph[curr]) {
            path.add(i);
            rec(i, path);
            path.remove(lenCache);
        }
    }
}
// @lc code=end
