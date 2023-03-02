// Author: MJUNM

package Lib.Basics.Sorting;

/**
 * Worst-case runtime: n^2
 * In-practice runtime: nlogn
 * Best-case runtime: nlogn
 * In-place: yes
 * Stable: no
 */
public class QuickSort extends Swap{
    public static void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int l, int r) {
        if (l >= r) return;
        int pivot = arr[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (arr[i] < pivot);
            do j--; while (arr[j] > pivot);
            if (i < j) swap(arr, i, j);
        }
        quicksort(arr, l, j);
        quicksort(arr, j + 1, r);
    }
}
