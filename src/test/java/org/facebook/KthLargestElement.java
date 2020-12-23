package org.facebook;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {


    //Using min heap
    private int solution(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        while (i < k) {
            pq.add(nums[i++]);
        }

        while (i < nums.length) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
            i++;
        }

        return pq.peek();
    }

    //max heap
    private int solution2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }

        while (--k > 0) {
            pq.poll();
        }

        return pq.peek();
    }

    @Test
    public void test1() {
        int[] nums = {1, 2, 9, 3, 8, 4, 6, 7};
        int k = 4;

        //System.out.println(solution1(nums, k));
        //System.out.println(solution2(nums, k));
        System.out.println(solution(nums, 3));
    }

    @Test
    public void test2() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        System.out.println(solution(nums, k)); //4
    }

    @Test
    public void test3() {
        int[] nums = {1, 2, 3};
        int k = 3;

        System.out.println(solution(nums, k)); //1
    }

}
