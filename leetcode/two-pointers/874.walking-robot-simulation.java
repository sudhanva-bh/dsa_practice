/*
 * @lc app=leetcode id=874 lang=java
 *
 * [874] Walking Robot Simulation
 */

// @lc code=start
import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        //          N  E  S   W

        Set<Long> obs = new HashSet<>();

        for (int[] ob : obstacles) {
            long key = ((long) ob[0] << 32) | (ob[1] & 0xffffffffL);
            obs.add(key);
        }

        int x = 0, y = 0, dir = 0;
        int maxDist = 0;

        for(int i : commands) {
            switch (i) {
                case -1 -> dir = (dir + 1) % 4;
                case -2 -> dir = (dir + 3) % 4;
                default -> {
                    for(int j = 0; j < i; j++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        
                        if(obs.contains(((long) nx << 32) | ny & 0xffffffffL)){
                            break;
                        }
                        x = nx;
                        y = ny;
                        
                        maxDist = Math.max(maxDist, x*x + y*y);
                    }
                }
            }
        }

        return maxDist;
    }
}
// @lc code=end



/*
  y
  N
W   E x
  S


*/