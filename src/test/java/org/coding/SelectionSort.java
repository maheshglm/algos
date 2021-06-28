package org.coding;

import org.junit.Test;

public class SelectionSort {

    private void solution(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }
            //swap
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
            i++;
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    @Test
    public void test1() {
        int[] arr = {64, 25, 12, 22, 11};
        solution(arr);
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 4, 5};
        solution(arr);
    }

    @Test
    public void test3() {
        int[] arr = {5, 4, 3, 2, 1};
        solution(arr);
    }
}
