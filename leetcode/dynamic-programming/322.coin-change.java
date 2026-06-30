/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
import java.util.*;

class Solution {
    // public int coinChange(int[] coins, int amount) {
    // if(amount == 0) return 0;
    // boolean[] visited = new boolean[amount + 1];

    // Queue<Integer> queue = new ArrayDeque<>();

    // queue.add(amount);
    // int size, len = 0, curr, cmi;

    // while (!queue.isEmpty()) {
    // size = queue.size();
    // len++;

    // while (size-- != 0) {
    // curr = queue.remove();
    // for (int i : coins) {
    // cmi = curr - i;
    // if (cmi == 0)
    // return len;
    // if (cmi > 0 && !visited[cmi]) {
    // visited[cmi] = true;
    // queue.add(cmi);
    // }
    // }
    // }
    // }

    // return -1;
    // }

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        sort(coins);
        Arrays.fill(dp, -1);

        dp[0] = 0;

        int next;

        for (int i = 0; i <= amount; i++) {
            if (dp[i] != -1)
                for (int coin : coins) {
                    if (i + coin > amount)
                        break;

                    next = dp[i] + 1;
                    if (dp[i + coin] == -1)
                        dp[i + coin] = next;

                    else if(dp[i + coin] > next) 
                        dp[i + coin] = next;

                }
        }

        return dp[amount];
    }
}
// @lc code=end
