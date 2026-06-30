/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
import java.util.*;

class Solution {
    int[] queens = new int[20];
    int n;

    List<List<String>> res = new ArrayList<>();

    static final String[][] ROWS = new String[20][];

    static {
        for (int n = 1; n <= 19; n++) {
            ROWS[n] = buildRows(n);
        }
    }

    static String[] buildRows(int n) {
        String[] rows = new String[n];

        char[] arr = new char[n];
        Arrays.fill(arr, '.');

        for (int i = 0; i < n; i++) {
            arr[i] = 'Q';
            rows[i] = new String(arr);
            arr[i] = '.';
        }

        return rows;
    }

    List<String> genStringForAll() {
        List<String> curr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            curr.add(ROWS[n][queens[i]]);
        }

        return curr;
    }

    boolean check(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(row - i) == Math.abs(col - queens[i]))
                return false;
        }

        return true;
    }

    void recurse(int row) {
        if (row == n)
            return;

        for (int col = 0; col < n; col++) {
            if (check(row, col)) {
                queens[row] = col;
                if (row == n - 1)
                    res.add(genStringForAll());
                else
                    recurse(row + 1);
                queens[row] = -1;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        Arrays.fill(queens, -1);

        recurse(0);

        return res;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();

        System.out.println("Start: " + java.time.LocalDateTime.now());

        new Solution().solveNQueens(14);

        long end = System.nanoTime();

        System.out.println("End:   " + java.time.LocalDateTime.now());
        System.out.printf("Time taken: %.3f seconds%n",
                (end - start) / 1_000_000_000.0);
    }
}
// @lc code=end
