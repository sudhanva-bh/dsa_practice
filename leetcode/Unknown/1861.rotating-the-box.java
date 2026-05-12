/*
 * @lc app=leetcode id=1861 lang=java
 *
 * [1861] Rotating the Box
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int w = boxGrid.length, h = boxGrid[0].length;

        char[][] res = new char[h][w];

        for(int i = 0; i < w; i++) {
            for(int j = 0; j < h; j++) {
                res[j][w - i - 1] = boxGrid[i][j];
            }
        }

        int bottom, top, count = 0;

        for(int i = 0; i < w; i++) {
            bottom = h - 1;
            top = h - 1;
            count = 0;

            while(top >= 0) {
                while(top >= 0 && res[top][i] != '*') {
                    if(res[top][i] == '#') {
                        count++;
                    }
                    top--;
                }

                if(count > 0) {
                    while(count > 0) {
                        res[bottom--][i] = '#';
                        count--;
                    }

                    while(bottom > top) {
                        res[bottom--][i] = '.';
                    }
                }

                top--;
                bottom = top;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        char[][] s = new char[][]{{'#','.','*','.'},
              {'#','#','*','.'}};
        // System.out.println(Arrays.deepToString(new Solution().rotateTheBox(s)));
    }
}

// 0,0 -> 1,0
// 0,1 -> 1,1
// 
// @lc code=end

