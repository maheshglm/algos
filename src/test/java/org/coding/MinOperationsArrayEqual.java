package org.coding;

import org.junit.Test;

//https://www.youtube.com/watch?v=A-i2sxmBqAA
public class MinOperationsArrayEqual {


    //formula nums[i] = (2 * i) + 1
    private int solution(int n) {
        int min = 1;
        int max = (2 * (n - 1)) + 1;
        int equalNum = (min + max) / 2;

        int result = 0;
        for (int i = 0; i < n / 2; i++) {
            result += equalNum - (2 * i + 1);
        }
        return result;
    }


    @Test
    public void test1() {
        int n = 3;
        System.out.println(n);
        //array formed [1, 3, 5]
        //2 operations to make array equals [2, 3, 4] -> [3, 3, 3]
    }

    @Test
    public void test2() {
        int n = 6;
        System.out.println(n);
        //array formed [1, 3, 5, 7, 9, 11]
        //9 operations to make all equal to 6
        //(min + max)/2 which is 6
    }

}
