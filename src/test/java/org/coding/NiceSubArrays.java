package org.coding;

import org.junit.Test;

//https://www.youtube.com/watch?v=lBDSyHPYBGE
//https://leetcode.com/problems/count-number-of-nice-subarrays/
public class NiceSubArrays {

    private int solution(int[] nums, int k) {

        int i = 0;
        int j = 0;
        int count = 0;
        int oddCount = 0;

        while (j < nums.length) {
            if (nums[j] % 2 == 1) {
                oddCount++;
                if (oddCount % k == 0) {
                    count++;
                }
            }

            if (oddCount >= k) {
                if (nums[i] % 2 == 1) {
                    oddCount--;
                }
                i++;
            }

            j++;
        }
        return count;
    }

    @Test
    public void test1() {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(solution(nums, k));
        //2
        /*
        Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
         */
    }

    @Test
    public void test2() {
        int[] nums = {2, 4, 6};
        int k = 1;
        System.out.println(solution(nums, k));
        //0
        /*
        Explanation: There is no odd numbers in the array.
         */
    }

    @Test
    public void test3() {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        //16
        System.out.println(solution(nums, k));

    }

}
