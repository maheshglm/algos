package org.facebook;

import org.junit.Test;

import java.util.Arrays;

//https://www.youtube.com/watch?v=bICaIGR1xLQ&list=RDCMUCPZ473Q4kbG98JmL71PgXTA&index=4
public class RemoveElementInPlace {

    public int solution(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (nums[i] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
            i++;
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }

    @Test
    public void test1() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        //output 2 2 - 2
        int result = solution(nums, 3);
        System.out.println(result);
    }

    @Test
    public void test2() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        //output 0, 1, 3, 0, 4 2 2 2
        int solution = solution(nums, 2);
        System.out.println(solution);

    }
}
