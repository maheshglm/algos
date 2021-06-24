package org.coding;

import org.junit.Test;

//https://www.youtube.com/watch?v=VZpJxINSvfs&t=455s
//https://www.youtube.com/watch?v=C8UjlJZsHBw
//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {


    //Time O(N)
    //Space O(N)
    public int solution(int[] arr) {
        int length = arr.length;
        if (length == 0) return 0;

        int[] leftMax = new int[length];
        int[] rightMax = new int[length];

        int totalTrapped = 0;

        leftMax[0] = arr[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMax[length - 1] = arr[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        for (int i = 0; i < length; i++) {
            totalTrapped += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        return totalTrapped;
    }

    //Time O(N)
    //Space O(1)
    //https://www.youtube.com/watch?v=XqTBrQYYUcc&t=25s
    //https://www.youtube.com/watch?v=AjDjQOZsxsw
    //https://www.youtube.com/watch?v=C8UjlJZsHBw
    /*
    maintaining max left and max right on the go, we dont need to 2 arrays to maintain these variables.
     */
    public int solution1(int[] arr) {
        int len = arr.length;
        //bcoz if less than 2 blocks, we cant store water

        if (len <= 2) return 0;

        int maxLeft = arr[0];
        int maxRight = arr[len - 1];

        int totalWater = 0;

        int i = 1;
        int j = len - 2;
        while (i <= j) {
            if (maxLeft < maxRight) {
                if (arr[i] > maxLeft) {
                    maxLeft = arr[i];
                } else {
                    totalWater += maxLeft - arr[i];
                }
                i++;
            } else {
                if (arr[j] > maxRight) {
                    maxRight = arr[j];
                } else {
                    totalWater += maxRight - arr[j];
                }
                j--;
            }

        }


        return totalWater;
    }


    @Test
    public void test1() {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //output 6
        /*
         Explanation: The above elevation map (black section) is represented by array
         [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
         */
        System.out.println(solution(arr));
        System.out.println(solution1(arr));
    }

    @Test
    public void test2() {
        int[] arr = {4, 2, 0, 3, 2, 5};
        //output 9
        System.out.println(solution(arr));
        System.out.println(solution1(arr));

    }

    @Test
    public void test3() {
        int[] arr = {4, 2, 0, 6, 3, 2, 5};
        //output 11
        System.out.println(solution(arr));
        System.out.println(solution1(arr));

    }
}
