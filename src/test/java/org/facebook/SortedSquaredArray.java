package org.facebook;

import org.junit.Test;

import java.util.Arrays;

public class SortedSquaredArray {

    public static int[] solution1(int[] a) {
        int[] result = new int[a.length];
        int left = 0;
        int right = a.length - 1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (Math.abs(a[left]) > Math.abs(a[right])) {
                result[i] = a[left] * a[left];
                left++;
            } else {
                result[i] = a[right] * a[right];
                right--;
            }
        }
        return result;
    }

    @Test
    public void test1() {
        int[] a = {-5, -4, 1, 2, 3};
        int[] solution = solution1(a);
        //Assert [1, 4, 9, 16, 25]
        System.out.println(Arrays.toString(solution));
    }
}
