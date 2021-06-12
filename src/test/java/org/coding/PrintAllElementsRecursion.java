package org.coding;

import org.junit.Test;

import java.util.Arrays;

public class PrintAllElementsRecursion {

    private void solution1(int[] arr, int start) {
        if (start >= arr.length) {
            return;
        }
        System.out.print(arr[start]);
        solution1(arr, start + 1);
    }

    private void solution2(int[] arr, int end) {
        if(end < 0){
            return;
        }
        System.out.print(arr[end]);
        solution2(arr, end - 1);

    }

    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 4, 5};
        solution1(arr, 0);
    }

    //reverse print
    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 4, 5};
        solution2(arr, arr.length - 1);
    }
}
