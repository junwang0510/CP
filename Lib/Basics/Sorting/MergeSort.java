// Author: MJUNM

package Lib.Basics.Sorting;

/**
 * Runtime: nlogn
 * In-place: no
 * Stable: yes
 */
public class MergeSort {
    public static void sort(int[] arr) {
        mergesort(arr, 0, arr.length - 1);
    }

    public static void mergesort(int[] arr, int l, int r) {
        if (l >= r) return;

        int mid = l + r >> 1;
        mergesort(arr, l, mid);
        mergesort(arr, mid + 1, r);

        int[] temp = new int[arr.length];
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];
        for (i = l, j = 0; i <= r; i++, j++) arr[i] = temp[j];
    }
}
