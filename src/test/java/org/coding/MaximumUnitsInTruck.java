package org.coding;

import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-units-on-a-truck/
public class MaximumUnitsInTruck {

    public int solution(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int boxes = 0;
        for (int[] box : boxTypes) {
            if (box[0] <= truckSize) {
                boxes += box[0] * box[1];
                truckSize -= box[0];
            } else {
                boxes += truckSize * box[1];
                break;
            }
        }
        return boxes;
    }

    @Test
    public void test1() {
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        System.out.println(solution(boxTypes, truckSize)); //8

    }

    @Test
    public void test2() {
        int[][] boxTypes = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int truckSize = 10;
        // 5,10 -> 3,9 -> 4,7 -> 2,5

        System.out.println(solution(boxTypes, truckSize)); //91

    }

}
