import java.util.*;
/*
 * @lc app=leetcode id=1356 lang=java
 *
 * [1356] Sort Integers by The Number of 1 Bits
 */

// @lc code=start
class Solution {

    // Since 0 <= arr[i] <= 10000
    int[] bitCount = new int[10001];

    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {

            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (compare(L[i], R[j]) <= 0) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    int compare(int a, int b) {
        if (bitCount[a] == bitCount[b])
            return a - b;
        return bitCount[a] - bitCount[b];
    }

    public int[] sortByBits(int[] arr) {

        // Precompute bit counts
        for (int num : arr) {
            bitCount[num] = Integer.bitCount(num);
        }

        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }
}
// @lc code=end

