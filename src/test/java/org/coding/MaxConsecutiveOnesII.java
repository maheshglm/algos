package org.coding;

import org.junit.Test;

//https://www.youtube.com/watch?v=OaMbeeSSv7Y
public class MaxConsecutiveOnesII {

    //max consecutive of ones, if we can flip at most one zero to 1
    private int solution(int[] nums, int k) {
        int windowStart = 0;
        int windowEnd = 0;

        while (windowEnd < nums.length) {
            if (nums[windowEnd] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[windowStart] == 0) {
                    k++;
                }
                windowStart++;
            }
            windowEnd++;
        }
        return windowEnd - windowStart;
    }

    public int solution1(int[] nums, int k) {
        int maxConsecutiveOnes = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int zerosCount = 0;

        while (windowEnd < nums.length) {
            if (nums[windowEnd] == 0) {
                zerosCount++;
            }

            while (zerosCount > k) {
                if (nums[windowStart] == 0) {
                    zerosCount--;
                }
                windowStart++;
            }
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, windowEnd - windowStart + 1);
            windowEnd++;
        }
        return maxConsecutiveOnes;
    }


    @Test
    public void test0() {
        int[] nums = {1, 0, 0, 1, 1, 0};
        //System.out.println(solution(nums, 1)); //output 3
        //System.out.println(solution(nums, 2)); //output 5
        System.out.println(solution(nums, 1)); //output 3
        System.out.println(solution1(nums, 1)); //output 3
    }

    @Test
    public void test1() {
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 1, 1};
        System.out.println(solution(nums, 1)); //output 6
        System.out.println(solution1(nums, 1)); //output 6
    }

    @Test
    public void test2() {
        int[] nums = {0, 1, 0, 1, 0, 0, 1, 1, 1, 1};
        System.out.println(solution(nums, 1)); //output 5
        System.out.println(solution1(nums, 1)); //output 5
    }

    @Test
    public void test3() {
        int[] nums = {0, 1, 0, 1, 0, 0, 1, 1, 1, 1};
        System.out.println(solution(nums, 2)); //output 7
        System.out.println(solution1(nums, 2)); //output 7
    }

    @Test
    public void test4() {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(solution(nums, 2)); //output 6
        System.out.println(solution(nums, 2)); //output 6
    }

}
