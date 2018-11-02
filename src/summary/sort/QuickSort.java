package summary.sort;

import org.junit.Test;

public class QuickSort implements BaseSort {
//    三种特殊情况:元素一样，升序，逆序
//    三种快排


    @Override
    public void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition2(arr, lo, hi);
        sort(arr, lo, p - 1);
        sort(arr, p + 1, hi);
    }

    private int partition(int[] arr, int lo, int hi) {
        int m = lo, t = arr[lo];
        for (int i = lo + 1; i <= hi; i++) {
            if (arr[i] < t) {
                swap(arr, ++m, i);
            }
        }
        swap(arr, m, lo);
        return m;
    }

    private int partition2(int[] arr, int lo, int hi) {
        int i = lo + 1, j = hi, m = lo, t = arr[lo];
        while (true) {
            while (i <= hi && arr[i] < t) i++;
            while (arr[j] > t) j--;
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, m, j);
        return j;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    @Test
    public void test() {
        int[] arr = new int[]{3,2,1,1,2,3};
        sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
