/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
import java.util.*;

class Node {
    private Node[] next = new Node[26];
    private String str = null;

    Node getNext(char c) {
        c -= 'a';
        return next[c];
    }

    Node getOrInsertNext(char c) {
        c -= 'a';

        if (next[c] == null)
            next[c] = new Node();

        return next[c];
    }

    boolean checkNext(char c) {
        return next[c - 'a'] != null;
    }

    void setString(String s) {
        str = s;
    }

    void removeString() {
        str = null;
    }

    String getString() {
        return str;
    }
}

class Solution {
    Node head = new Node();
    List<String> res = new ArrayList<>();
    char[][] board;
    int n, m;

    final static int[] dx = new int[] { 0, 1, 0, -1 };
    final static int[] dy = new int[] { 1, 0, -1, 0 };

    public List<String> findWords(char[][] board, String[] words) {
        for (String s : words) {
            insertString(s);
        }

        this.board = board;
        this.m = board.length;
        this.n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!head.checkNext(board[i][j]))
                    continue;

                visited[i][j] = true;
                dfs(i, j, head, visited);
                visited[i][j] = false;
            }
        }

        return res;
    }

    void insertString(String s) {
        Node curr = head;

        for (char c : s.toCharArray()) {
            curr = curr.getOrInsertNext(c);
        }

        curr.setString(s);
    }

    void dfs(int x, int y, Node curr, boolean[][] visited) {
        curr = curr.getNext(board[x][y]);
        if (curr == null)
            return;

        String s = curr.getString();

        if (s != null) {
            res.add(s);
            curr.removeString();
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < m &&
                    ny < n && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, curr, visited);
                visited[nx][ny] = false;
            }
        }
    }
}
// @lc code=end