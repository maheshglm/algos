package org.facebook;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://algorithms.tutorialhorizon.com/sort-0s-the-1s-and-2s-in-the-given-array-dutch-national-flag-algorithm-set-2/
public class Sort012Numbers {

    private int[] solution(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.add(n);
        }
        int index = 0;
        while (!pq.isEmpty()) {
            nums[index++] = pq.poll();
        }
        return nums;
    }

    private int[] solution1(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    nums[mid] = nums[low];
                    nums[low] = 0;
                    mid++;
                    low++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    nums[mid] = nums[high];
                    nums[high] = 2;
                    high--;
                    break;
            }
        }
        return nums;
    }


    @Test
    public void test1() {
        int[] nums = {2, 1, 2, 0, 1, 0};
        //output = 0, 0, 1, 1, 2, 2
        System.out.println(Arrays.toString(solution(nums)));
        System.out.println(Arrays.toString(solution1(nums)));
    }

    @Test
    public void test2() {
        int[] nums = {0, 0, 2, 0, 2, 1, 0, 1, 2};
        //output = 0, 0, 0, 0, 1, 1, 2, 2, 2
        System.out.println(Arrays.toString(solution(nums)));
        System.out.println(Arrays.toString(solution1(nums)));

    }
}
