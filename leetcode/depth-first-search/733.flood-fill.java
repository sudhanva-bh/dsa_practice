/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    final static int[] dx = new int[]{0, 1, 0, -1};
    final static int[] dy = new int[]{1, 0, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;

        dfs(image, sr, sc, color);

        return image;
    }

    void dfs(int[][] image, int x, int y, int color) {
        int original = image[x][y];

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dx[i];

            if(nx >= 0 && nx < image.length && ny >= 0 && ny < image[0].length && image[nx][ny] == original) {
                dfs(image, nx, ny, color);
            }
        }
    }
}
// @lc code=end

