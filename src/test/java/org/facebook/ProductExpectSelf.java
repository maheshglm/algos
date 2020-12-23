package org.facebook;

import org.junit.Test;

import java.util.Arrays;

//https://www.youtube.com/watch?v=tSRFtR3pv74
public class ProductExpectSelf {

    //please solve it without division

    private static int[] solution2(int[] nums) {
        int N = nums.length;
        int[] leftProducts = new int[N];
        int[] rightProducts = new int[N];

        int[] output = new int[N];

        leftProducts[0] = 1;
        rightProducts[N - 1] = 1;

        for (int i = 1; i < N; i++) {
            leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
        }

        for (int i = N - 2; i >= 0; i--) {
            rightProducts[i] = nums[i + 1] * rightProducts[i + 1];
        }

        for (int i = 0; i < N; i++) {
            output[i] = leftProducts[i] * rightProducts[i];
        }
        return output;
    }

    private static int[] solution3(int[] nums) {
        int N = nums.length;

        int[] output = new int[N];

        output[0] = 1;
        for (int i = 1; i < N; i++) {
            output[i] = nums[i - 1] * output[i - 1];
        }

        int R = 1;
        for (int i = N - 1; i >= 0; i--) {
            output[i] = output[i] * R;
            R = R * nums[i];
        }

        return output;
    }

    //not efficient
    private static int[] solution1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = productOfLeft(nums, i) * productOfRight(nums, i);
        }
        return result;
    }

    private static int productOfLeft(int[] nums, int index) {
        int result = nums[0];
        for (int i = 1; i < index; i++) {
            result = result * nums[i];
        }
        return result;
    }

    private static int productOfRight(int[] nums, int index) {
        int result = 1;
        for (int i = nums.length - 1; i > index; i--) {
            result = result * nums[i];
        }
        return result;
    }

    @Test
    public void test1() {
        int[] a = {1, 2, 3, 4};
        int[] output = {24, 12, 8, 6};
        System.out.println(Arrays.toString(solution3(a)));
    }

    @Test
    public void test2() {
        int[] a = {2, 3, 4};
        int[] output = {12, 8, 6};

        //in fact left array
        int[] result = new int[a.length];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = a[i - 1] * result[i - 1];
        }

        int r = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            result[i] = r * result[i];
            r = r * a[i];
        }


        int debug = 1;

    }

}
