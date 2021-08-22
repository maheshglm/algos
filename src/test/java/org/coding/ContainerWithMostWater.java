package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/container-with-most-water/
//https://www.youtube.com/watch?v=UuiTKBwPgAo
public class ContainerWithMostWater {

    //area of rectangle is maxHeight * width, width is basically difference between indices

    //brute force having 2 loops
    private int solution(int[] heights) {
        int max = Integer.MIN_VALUE;
        int area = 0;
        for (int left = 0; left < heights.length; left++) {
            for (int right = left + 1; right < heights.length; right++) {
                //min of 2 blocks
                area = (right - left) * Math.min(heights[left], heights[right]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    private int solution1(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int max = 0;
        int area;

        while (left < right) {
            area = Math.min(heights[left], heights[right]) * (right - left);
            max = Math.max(area, max);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    @Test
    public void test1() {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        //49
    }

    @Test
    public void test2() {
        int[] heights = {1, 1};
        //1
    }

    @Test
    public void test3() {
        int[] heights = {4, 3, 2, 1, 4};
        //16
    }

    @Test
    public void test4() {
        int[] heights = {1, 2, 1};
        //2
    }


}
