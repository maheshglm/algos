package org.facebook;

import org.junit.Test;

//https://www.youtube.com/watch?v=MK-NZ4hN7rs
public class SmallestSubArrayWithSum {


    public int solution(int[] nums, int targetSum) {
        int minLength = Integer.MAX_VALUE;
        int currentWindowSum = 0;

        int windowEnd = 0;
        int windowStart = 0;

        while (windowEnd < nums.length) {
            currentWindowSum += nums[windowEnd];
            while (currentWindowSum >= targetSum) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                currentWindowSum -= nums[windowStart];
                windowStart++;
            }
            windowEnd++;
        }

        return minLength;
    }

    @Test
    public void test1() {
        int[] nums = {4, 2, 2, 7, 1, 2, 5};
        int targetSum = 8;
        System.out.println(solution(nums, targetSum)); //Output 2
    }
}
