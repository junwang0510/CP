// Author: MJUNM

package Java_Lib.Basics.Sorting;

public class Swap {
    /**
     * Swap two elements in the array
     * @param arr input array
     * @param a index of the first element
     * @param b index of the second element
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
