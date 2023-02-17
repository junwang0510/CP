// Author: MJUNM

package Lib.Basics.Sorting;

/**
 * Runtime: n^2
 * In-place: yes
 * Stable: no
 */
public class SelectionSort extends Swap {
    public static void sort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
}
