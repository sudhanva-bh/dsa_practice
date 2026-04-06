/*
 * @lc app=leetcode id=2751 lang=java
 *
 * [2751] Robot Collisions
 */

// @lc code=start

import java.util.*;
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indexArray = new Integer[n];
        for(int i = 0; i < n; i++) indexArray[i] = i;

        Arrays.sort(indexArray, (a, b) -> positions[a] - positions[b]);

        
    }
}
// @lc code=end

