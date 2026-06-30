/*
 * @lc app=leetcode id=1483 lang=java
 *
 * [1483] Kth Ancestor of a Tree Node
 */

// @lc code=start
class TreeAncestor {
    int[][] lookup;
    public TreeAncestor(int n, int[] parent) {
        int par;

        lookup = new int[17][];
        lookup[0] = parent;

        for(int i = 1; i < 17; i++) {
            lookup[i] = new int[n];
            for(int j = 0; j < n; j++) {
                par = lookup[i-1][j];

                if(par != -1) {
                    par = lookup[i-1][par];
                }

                lookup[i][j] = par;
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int currLevel = 0, currDigit;
        while(k != 0) {
            currDigit = k & 1;
            k >>= 1;

            if(currDigit == 1) {
                node = lookup[currLevel][node];
                if(node == -1) return -1;
            }


            currLevel++;
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
// @lc code=end

