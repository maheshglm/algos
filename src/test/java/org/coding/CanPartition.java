package org.coding;

import org.junit.Test;

//https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3jEPRo5PDvx
public class EqualSubSetSum {

    public boolean solution(int[] arr) {
        return true;
    }

    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 4};
        //True {1,4} and {2, 3}
    }

    @Test
    public void test2() {
        int[] arr = {1, 1, 3, 4, 7};
        //True {1,3,4}, {1,7}
    }

    @Test
    public void test3() {
        int[] arr = {2, 3, 4, 6};
        //False
    }
}
