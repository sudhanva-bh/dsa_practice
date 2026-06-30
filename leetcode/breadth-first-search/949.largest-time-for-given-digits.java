/*
 * @lc app=leetcode id=949 lang=java
 *
 * [949] Largest Time for Given Digits
 */

// @lc code=start
import java.util.*;


class Solution {
    int max = -1;

    public String largestTimeFromDigits(int[] arr) {
        sortDesc(arr);

        if(arr[3] > 2) return "";
        if(arr[2] > 5) return "";

        rec(arr, 0, 0, new boolean[4]);

        return max != -1 ? buildTime(max) : "";
    }

    void sortDesc(int[] a) {
        if (a[0] < a[1])
            swap(a, 0, 1);
        if (a[2] < a[3])
            swap(a, 2, 3);
        if (a[0] < a[2])
            swap(a, 0, 2);
        if (a[1] < a[3])
            swap(a, 1, 3);
        if (a[1] < a[2])
            swap(a, 1, 2);
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    void rec(int[] arr, int curr, int currTime, boolean[] taken) {
        if (curr == arr.length) {
            if (isValid(currTime)) {
                max = currTime;
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!taken[i]) {
                if (curr == 0 && arr[i] > 2)
                    continue;
                if (curr == 2 && arr[i] > 5)
                    continue;
                taken[i] = true;
                rec(arr, curr + 1, (currTime * 10) + arr[i], taken);
                taken[i] = false;
            }
        }
    }

    boolean isValid(int time) {
        if ((time % 100) > 59 || (time / 100) > 23)
            return false;
        return time > max;
    }

    String buildTime(int n) {
        int h = n / 100;
        int m = n % 100;

        char[] t = new char[5];
        t[0] = (char) ('0' + h / 10);
        t[1] = (char) ('0' + h % 10);
        t[2] = ':';
        t[3] = (char) ('0' + m / 10);
        t[4] = (char) ('0' + m % 10);

        return new String(t);
    }
}
// @lc code=end
