/*
 * @lc app=leetcode id=2685 lang=java
 *
 * [2685] Count the Number of Complete Components
 */

// @lc code=start
import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] degree = new int[n];

        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        int[][] adj = new int[n][];
        for(int i = 0; i < n; i++) {
            adj[i] = new int[degree[i]];
        }

        int[] ptr = new int[n];

        for(int[] edge : edges) {
            adj[edge[0]][ptr[edge[0]]++] = edge[1];
            adj[edge[1]][ptr[edge[1]]++] = edge[0];
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                queue.add(i);
                visited[i] = true;

                int numVertices = 1;
                int numOfEdges = adj[i].length;
                boolean isComplete = true;

                while(!queue.isEmpty()) {
                    int curr = queue.remove();

                    for(int next : adj[curr]) {
                        if(!visited[next]) {
                            if(adj[next].length != numOfEdges) {
                                isComplete = false;
                            }
                            numVertices++;
                            visited[next] = true;
                            queue.add(next);
                        }
                    }
                }

                if(isComplete && numOfEdges == numVertices - 1) count++;
            }
        }

        return count;
    }
}
// @lc code=end
