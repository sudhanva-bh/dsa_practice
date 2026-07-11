/*
 * @lc app=leetcode id=1473 lang=java
 *
 * [1473] Paint House III
 */

// @lc code=start
import java.util.*;

class Solution {
    int[][][] memo;
    final int MAX_COST = 1000000; 

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        memo = new int[m][n + 1][target + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        
        int result = solve(houses, cost, m, n, target, 0, 0, 0);
        return result >= MAX_COST ? -1 : result;
    }

    private int solve(int[] houses, int[][] cost, int m, int n, int target, 
                      int currHouse, int prevColor, int neighborhoods) {
        
        if (neighborhoods > target) {
            return MAX_COST;
        }

        if (currHouse == m) {
            return neighborhoods == target ? 0 : MAX_COST;
        }

        if (memo[currHouse][prevColor][neighborhoods] != -1) {
            return memo[currHouse][prevColor][neighborhoods];
        }

        int minCostToPaint = MAX_COST;

        if (houses[currHouse] != 0) {
            int currentColor = houses[currHouse];
            int newNeighborhoods = neighborhoods + (currentColor != prevColor ? 1 : 0);
            minCostToPaint = solve(houses, cost, m, n, target, currHouse + 1, currentColor, newNeighborhoods);
        } else {
            for (int color = 1; color <= n; color++) {
                int newNeighborhoods = neighborhoods + (color != prevColor ? 1 : 0);
                int currentPaintCost = cost[currHouse][color - 1]; 
                
                int totalCost = currentPaintCost + solve(houses, cost, m, n, target, currHouse + 1, color, newNeighborhoods);
                minCostToPaint = Math.min(minCostToPaint, totalCost);
            }
        }

        return memo[currHouse][prevColor][neighborhoods] = minCostToPaint;
    }
}
// @lc code=end
