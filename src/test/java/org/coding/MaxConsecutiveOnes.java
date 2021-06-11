package org.coding;

import org.junit.Test;

//https://www.youtube.com/watch?v=lHE1PJ8xg9I
public class MaxConsecutiveOnes {

    private int solution1(int[] nums) {
        int result = 0;
        int maxConsecutiveOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                maxConsecutiveOnes++;
                result = Math.max(maxConsecutiveOnes, result);
            } else {
                maxConsecutiveOnes = 0;
            }
        }
        return result;
    }

    @Test
    public void test1() {
        int[] nums = {1, 1, 0, 1, 1, 1, 1, 1, 0};
        System.out.println(solution1(nums));
        //Output 5
    }

    @Test
    public void test2() {
        int[] nums = {1, 1, 0, 1, 1, 1, 0};
        System.out.println(solution1(nums));
        //Output 3
    }

}
