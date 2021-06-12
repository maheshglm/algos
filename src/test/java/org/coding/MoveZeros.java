package org.coding;

import org.junit.Test;

import java.util.Arrays;

public class MoveZeros {

    private static int[] moveToRight(int[] arr) {
        int i = 0;
        int j = 0;
        int temp;

        while (i < arr.length) {
            if (arr[i] != 0) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        return arr;
    }

    private static int[] moveToLeft(int[] arr) {
        int i = arr.length - 1;
        int j = arr.length - 1;
        int temp;
        while (i >= 0) {
            if (arr[i] != 0) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
            i--;
        }
        return arr;
    }


    @Test
    public void test1() {
        int[] arr = {1, 10, 20, 0, 59, 63, 0, 88, 0};

        int[] solution = moveToLeft(arr);
        System.out.println(Arrays.toString(solution));
    }

    @Test
    public void test2() {
        int[] arr = {1, 0, 2, 0, 0, 3, 0, 4};

        int[] solution = moveToLeft(arr);

        System.out.println(Arrays.toString(solution));
    }

    @Test
    public void test3() {
        int[] arr = {0, 1, 0, 3, 12};

        System.out.println(Arrays.toString(moveToLeft(arr)));
        System.out.println(Arrays.toString(moveToRight(arr)));
    }

}
