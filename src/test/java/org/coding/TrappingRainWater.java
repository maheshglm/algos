package org.coding;

import org.junit.Test;

//https://www.youtube.com/watch?v=VZpJxINSvfs&t=455s
//https://www.youtube.com/watch?v=C8UjlJZsHBw
//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {

    //concept is to calculate max blocks of each block and finding minimum block from both sides is the key
    //ex: if blocks height are 4, 3,5 -> water cannot be stored at 4 and 5, but on 3, it is depends on
    //minimum height of 4,5 -> 4. i.e. Min(4,5) - curr block height = 4-3 = 1 unit.
    //ex: if block height are 3,0,4,2,5
    //we cant store at 3, min(3,4)-0, cannot store at 4, Min(4,5)-2, cannot store at 5
    //3 + 2 = 5 units of water can be saved
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
    maintaining max left and max right on the go, we don't need to 2 arrays to maintain these variables.
     */
    public int solution1(int[] arr) {
        int len = arr.length;

        //bcoz if less than 2 blocks, we cant store water
        if (len <= 2) return 0;

        int maxLeft = arr[0];
        int maxRight = arr[len - 1];

        int totalWater = 0;

        //keep updating maxLeft and maxRight based on current block height
        //i.e. if current block height is more than temp max left, then max left = currentBlock
        //similarly from the right current block is more than max right, the max right = current block
        //3, 0, 4, 2, 5, 2
        //Assume maxLeft = 3 (0th), maxRight = 2 (len-1 block)
        //if(maxLeft < maxRight) -> start accumulating water from right -> and current block height is more than maxRight
        //set up maxRight as you can save water there coz in above example
        //maxRight 2, curr block height is 5. now juts update max right as 5.and move to next block from right
        //check again maxLeft < maxRight -> 3 < 5
        //and current block height is more than maxLeft -> 0 , 3, since its less total water = maxLeft - a[i] = 3-0=3
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

    @Test
    public void test4() {
        int[] arr = {3, 0, 4, 2, 5};
        //output 5
        System.out.println(solution(arr));
        System.out.println(solution1(arr));

    }
}
