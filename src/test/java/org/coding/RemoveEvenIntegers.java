package org.coding;

import org.junit.Test;

import java.util.Arrays;

public class RemoveEvenIntegers {

    private int[] solution(int[] nums) {
        int oddElements = 0;

        for (int num : nums) {
            if (num % 2 != 0) oddElements++;
        }

        int[] new_array = new int[oddElements];
        int index = 0;
        for (int num : nums) {
            if (num % 2 != 0)
                new_array[index++] = num;
        }
        return new_array;
    }

    @Test
    public void test1() {
        int[] nums = {1, 2, 2, 5, 7, 8, 9, 11};
        //output = {1,5,7,9,11}
        System.out.println(Arrays.toString(solution(nums)));
    }

    @Test
    public void test2() {
        int[] nums = {2, 2, 8, 0, 10};
        //output = {}
        System.out.println(Arrays.toString(solution(nums)));
    }

    @Test
    public void test3() {
        int[] nums = {};
        //output = {}
        System.out.println(Arrays.toString(solution(nums)));
    }

    @Test
    public void test4() {
        int[] nums = {5};
        //output = {5}
        System.out.println(Arrays.toString(solution(nums)));
    }
}
