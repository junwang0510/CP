// Author: MJUNM

package Lib;

/**
 * For range queries with frequent updates.
 * 
 * build() - O(n)
 * query() - O(log n)
 * update() - O(log n)
 */
public class SegmentTree {
    // Segment Tree Nodes
    private int[] tree;

    /**
     * Construct and fill the segment tree
     *
     * @param arr input array for building
     */
    SegmentTree(int[] arr) {
        // Number of elements in the tree
        int n = arr.length;

        // Height of the tree
        int h = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        // Size of the array for storing the tree
        int size = 2 * (int) Math.pow(2, h) - 1;
        tree = new int[size];

        // Recursively build the tree
        buildHelper(arr, 0, n - 1, 0);
    }

    // helper function for building the tree
    private int buildHelper(int[] arr, int start, int end, int curr) {
        // Base case: At leaf node -> store the value
        if (start == end) {
            tree[curr] = arr[start];
            return arr[start];
        }

        // Not at leaf node -> Recursively build left and right subtrees
        int mid = start + (end - start) / 2;
        tree[curr] = buildHelper(arr, start, mid, curr * 2 + 1) +
                buildHelper(arr, mid + 1, end, curr * 2 + 2);

        return tree[curr];
    }

    /**
     * Update the given index of the array with the new value.
     * Update segment tree values as appropriate.
     *
     * @param arr    array for replacing the value
     * @param i      index to replace in the array
     * @param newVal value for replacement
     */
    void update(int[] arr, int i, int newVal) {
        int n = arr.length;

        // Invalid index input
        if (i < 0 || i > n - 1) {
            throw new IllegalArgumentException("update(): Invalid index");
        }

        // Update array and tree
        int diff = newVal - arr[i];
        arr[i] = newVal;
        updateHelper(0, n - 1, i, diff, 0);
    }

    // helper function for updating the values in the tree
    private void updateHelper(int start, int end, int i, int diff, int curr) {
        // Base case: Range is outside the segment
        if (i < start || i > end) return;

        // Recursively update left and right subtrees
        tree[curr] = tree[curr] + diff;
        if (start != end) {
            int mid = start + (end - start) / 2;
            updateHelper(start, mid, i, diff, curr * 2 + 1);
            updateHelper(mid + 1, end, i, diff, curr * 2 + 2);
        }
    }

    /**
     * Query the sum of a given range in the tree
     *
     * @param n     number of elements
     * @param start start of the range
     * @param end   end of the range
     * @return the sum of the given range
     */
    int getSum(int n, int start, int end) {
        // Invalid range inputs
        if (start < 0 || end > n - 1 || start > end) {
            throw new IllegalArgumentException("getSum(): Invalid range");
        }

        return getSumHelper(0, n - 1, start, end, 0);
    }

    // helper function for querying the sum of a given range in the tree
    private int getSumHelper(int start, int end, int queryStart, int queryEnd, int curr) {
        // Segment is part of given range -> return the sum of the segment
        if (queryStart <= start && queryEnd >= end) return tree[curr];

        // Segment is outside the given range
        if (end < queryStart || start > queryEnd) return 0;

        // Segment overlaps with the given range
        int mid = start + (end - start) / 2;
        return getSumHelper(start, mid, queryStart, queryEnd, curr * 2 + 1) +
                getSumHelper(mid + 1, end, queryStart, queryEnd, curr * 2 + 2);
    }


    // Sample Usage
    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 4, 1, 0, 9, 18};
        int n = arr.length;
        SegmentTree st = new SegmentTree(arr);
        System.out.println("Before update: Sum of values from index 1 to 5 = " + st.getSum(n, 1, 5));
        System.out.println("Update: set arr[2] = 11");
        st.update(arr, 2, 11);
        System.out.println("After update: Sum of values from index 1 to 5 = " + st.getSum(n, 1, 5));
    }
}
