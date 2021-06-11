package org.coding;

import org.junit.Test;

import java.util.Arrays;

//https://www.youtube.com/watch?v=x3UclQq_EVk
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
public class ShipWithinDays {


    //Using Binary search
    private int solution2(int[] weights, int maxDays) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canBeTransferred(weights, maxDays, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    //Brute force solution
    private int solution1(int[] weights, int maxDays) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        for (int i = low; i <= high; i++) {
            if (canBeTransferred(weights, maxDays, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean canBeTransferred(int[] weights, int maxDays, int shipCapacity) {
        int sum = 0;
        int days = 1;
        for (int wt : weights) {
            if (sum + wt <= shipCapacity) {
                sum += wt;
            } else {
                days++;
                sum = wt;
            }
        }
        return days <= maxDays;
    }


    @Test
    public void test1() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int maxDays = 5;
        System.out.println(solution1(weights, maxDays)); //15
        System.out.println(solution2(weights, maxDays)); //15
    }

    @Test
    public void test2() {
        int[] weights = {3, 2, 2, 4, 1, 4};
        int maxDays = 3;
        System.out.println(solution1(weights, maxDays)); //6
        System.out.println(solution2(weights, maxDays)); //6

    }

    @Test
    public void test3() {
        int[] weights = {1, 2, 3, 1, 1};
        int maxDays = 4;
        System.out.println(solution1(weights, maxDays)); //3
        System.out.println(solution2(weights, maxDays)); //3

    }


}
