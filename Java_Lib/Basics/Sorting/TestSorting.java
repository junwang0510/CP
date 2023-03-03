// Author: MJUNM

package Java_Lib.Basics.Sorting;

public class TestSorting extends InsertionSort { // Change the extended class for different sorting algorithms
    public static void main(String[] args) {
        int[] arr = {4, -1, 0, 13, 107, -41, -23, 20, 8, -9, 0, 0, 20, 9};
        System.out.println("Before Sorting:");
        printArr(arr);
        sort(arr);
        System.out.println("After Sorting:");
        printArr(arr);
        verifySort(arr);
    }

    public static void printArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void verifySort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                System.out.println("\nVerify Sort: Not Sorted!");
                return;
            }
        }
        System.out.println("\nVerify Sort: Sorted!");
    }
}
