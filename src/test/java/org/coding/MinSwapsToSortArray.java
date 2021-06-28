package org.coding;

import org.junit.Test;

public class MinSwapsToSortArray {

    //selection sort
    private int solution(int[] arr) {

        int swaps = 0;
        int i = 0;
        while (i < arr.length) {
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            if (min_index != i) {
                int temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
                swaps++;
            }
            i++;
        }
        return swaps;
    }


    @Test
    public void test1() {
        int[] arr = {4, 3, 1, 2};
        //ans: 2
        System.out.println(solution(arr));
    }

    @Test
    public void test2() {
        int[] arr = {1, 5, 4, 3, 2};
        System.out.println(solution(arr));
        //ans: 2
    }
}
