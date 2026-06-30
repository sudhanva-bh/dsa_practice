/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] bicolor = new int[n];
        int curr;

        for(int i = 0; i < n; i++) {
            if(bicolor[i] != 0) {
                curr = bicolor[i];

                for(int j : graph[i]) {
                    if(bicolor[j] == 0) {
                        bicolor[j] = curr == 1 ? 2 : 1;
                    } else if(bicolor[j] == curr) return false;
                }
            } else {
                curr = 0;
                for(int j : graph[i]) {
                    if(bicolor[j] != 0) {
                        if(curr != 0) {
                            curr = bicolor[j];
                        } else {
                            if(curr != bicolor[j]) return false;
                        }
                    } else {
                        bicolor[i] = curr;
                    }
                }

                if(curr == 0) curr = 1;

                for(int j : graph[i]) {
                    bicolor[j] = curr;
                }

                bicolor[i] = curr == 1 ? 2 : 1;
            }
        }
        
        return true;
    }
}
// @lc code=end

