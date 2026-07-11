/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        byte[] color = new byte[n]; // 0 = unvisited, 1, 2 two different colors

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                queue.add(i);

                color[i] = 1;
                byte currColor = 1;
                byte nextColor = -1;

                while (!queue.isEmpty()) {
                    int size = queue.size();

                    while (size-- > 0) {
                        int curr = queue.remove();

                        for (int next : graph[curr]) {
                            if (color[next] == currColor)
                                return false;
                            if (color[next] == 0) {
                                color[next] = nextColor;
                                queue.add(next);
                            }
                        }
                    }

                    byte temp = currColor;
                    currColor = nextColor;
                    nextColor = temp;
                }
            }
        }

        return true;
    }
}
// @lc code=end
