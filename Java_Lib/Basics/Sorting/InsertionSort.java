// Author: MJUNM

package Java_Lib.Basics.Sorting;

/**
 * Worst-case runtime: n^2
 * In-practice runtime: n^2
 * Best-case runtime: n
 * In-place: yes
 * Stable: yes
 */
public class InsertionSort extends Swap {
    public static void sort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j - 1 >= 0 && arr[j - 1] > arr[j]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }
}
