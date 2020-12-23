package org.facebook;

import org.junit.Test;

import java.util.Arrays;

//https://www.youtube.com/watch?v=XFPHg5KjHoo
public class LongestSubArrayBySum {

    //Sliding window approach
    public static int[] solution(int[] a, int s) {

        int[] result = new int[]{-1};
        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < a.length) {
            sum += a[right];

            if (left < right && sum > s) {
                sum -= a[left++];
            }

            if (sum == s) {
                if (result.length == 1 || result[1] - result[0] < right - left) {
                    result = new int[]{left + 1, right + 1};
                }
            }

            if (sum < s) {
                right++;
            }

        }
        return result;
    }

    public static int[] solution2(int[] a, int s) {
        int[] result = {-1, -1};
        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < a.length) {
            sum += a[right];

            while (left < right && sum > s) {
                sum -= a[left++];
            }

            if (sum == s && result[1] - result[0] < right - left) {
                result = new int[]{left + 1, right + 1};
            }

            right++;
        }

        return result;
    }

    @Test
    public void test1() {
        int[] a = {1, 2, 3, 7, 5};
        int sum = 12;
        System.out.println(Arrays.toString(solution(a, sum)));
        System.out.println(Arrays.toString(solution2(a, sum)));
        //Assert [2, 4] - which indices of longest sub array of 12 i.e. 2 + 3 + 7
    }

    @Test
    public void test2() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 15;
        //Assert [1, 5] - which indices of longest sub array of 15
        System.out.println(Arrays.toString(solution(a, sum)));
        System.out.println(Arrays.toString(solution2(a, sum)));
    }
}
