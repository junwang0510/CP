// Author: MJUNM

package Lib.Basics.Sorting;

/**
 * Runtime: nlogn
 * In-place: yes
 * Stable: no
 */
public class HeapSort extends Swap {
    public static void sort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;
        buildMaxHeap(arr);
        for (int i = n - 1; i > 0; i--) {
            // Move the largest value to the end of the unsorted region
            swap(arr, 0, i);
            // Fix the max heap
            heapify(arr, 0, i);
        }
    }

    // Floyd's Build Heap Algorithm
    private static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    private static void heapify(int[] arr, int i, int n) {
        int maxIndex = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left < n && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }
        if (right < n && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != i) {
            swap(arr, i, maxIndex);
            heapify(arr, maxIndex, n);
        }
    }
}
