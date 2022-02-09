package org.coding;

import org.junit.Test;

//https://www.youtube.com/watch?v=IDeyPqApnX0
//https://leetcode.com/problems/maximum-product-subarray/
//https://leetcode.com/problems/maximum-product-subarray/solution/
public class MaxProductSubArray {

    //O(N) O(1)
    //https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity
    private int solution3(int[] nums) {
        int max = Integer.MIN_VALUE;
        int product = 1;

        for (int n : nums) {
            product *= n;
            max = Math.max(product, max);
            if (product == 0) product = 1;
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            max = Math.max(product, max);
            if (product == 0) product = 1;
        }
        return max;
    }


    //O(N^2)
    public int solution2(int[] nums) {
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int acc = 1;
            for (int j = i; j < nums.length; j++) {
                acc *= nums[j];
                result = Math.max(acc, result);
            }
        }
        return result;
    }

    public int solution1(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int maxProd = nums[0];
        int minProd = nums[0];
        int finalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = maxProd;
            maxProd = Math.max(nums[i], Math.max(maxProd * nums[i], minProd * nums[i]));
            minProd = Math.min(nums[i], Math.min(temp * nums[i], minProd * nums[i]));

            finalMax = Math.max(finalMax, maxProd);
        }
        return finalMax;
    }

    @Test
    public void test1() {
        int[] nums = {2, 3, -2, 4};
        //output = 6
        //[2,3] has the largest product 6.
        System.out.println(solution1(nums));
        System.out.println(solution3(nums));
        System.out.println(solution2(nums));

    }

    @Test
    public void test3() {
        int[] nums = {2, 3, 4, -2, 0, 25};
        //output = 25
        //[25] has the largest product 25.
        System.out.println(solution1(nums));
        System.out.println(solution2(nums));

    }

    @Test
    public void test2() {
        int[] nums = {-2, 0, -1};
        //output = 0
        //The result cannot be 2, because [-2,-1] is not a subarray.
        System.out.println(solution1(nums));
        System.out.println(solution2(nums));

    }
}
