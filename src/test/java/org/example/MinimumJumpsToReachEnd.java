package org.example;

import org.junit.Assert;
import org.junit.Test;

public class MinimumJumpsToReachEnd {


    private static int minimumJumps(int[] arr) {

        // we never reach end if starting position itself zero.
        if (arr[0] == 0) {
            return -1;
        }

        int jumps = 0;
        int maxReachable = 0;
        for (int i = 0; i < arr.length; i++) {
            
        }

        return jumps;

    }

    @Test
    public void test1() {
        int[] a = {1, 3, 6, 1, 0, 9};
        Assert.assertEquals(3, minimumJumps(a));
    }

    @Test
    public void test2() {
        int[] a = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        Assert.assertEquals(3, minimumJumps(a));
    }

    @Test
    public void test3() {
        int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Assert.assertEquals(10, minimumJumps(a));
    }

    @Test
    public void test4() {
        int[] a = {2, 1, 3, 7};
        Assert.assertEquals(2, minimumJumps(a));
    }

    @Test
    public void test5() {
        int[] a = {2, 3, 1, 1, 4};
        Assert.assertEquals(2, minimumJumps(a));
    }

    @Test
    public void test6() {
        int[] a = {0, 3, 1, 1, 4};
        Assert.assertEquals(-1, minimumJumps(a));
    }

}
