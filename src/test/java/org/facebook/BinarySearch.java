package org.facebook;

import org.junit.Test;

public class BinarySearch {

    private int solution(int[] a, int search) {
        int start = 0;
        int end = a.length - 1;
        int notFound = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == search) {
                return mid;
            }
            if (a[mid] > search) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return notFound;
    }

    @Test
    public void test1() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int search = 8;
        System.out.println(solution(a, search));
    }
}
