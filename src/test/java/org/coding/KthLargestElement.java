package org.coding;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://www.hackerearth.com/practice/notes/heaps-and-priority-queues/
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

    /*
    here adding all elements and polling kth elements is not best solution
     */
    private int solution3(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.add(n);
        }

        int polls = nums.length - k;

        while (polls-- > 0) {
            pq.poll();
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
        System.out.println(solution(nums, 3));//7
        System.out.println(solution3(nums, 3));//7
    }

    @Test
    public void test2() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        System.out.println(solution(nums, k)); //4
        System.out.println(solution3(nums, k)); //4
    }

    @Test
    public void test3() {
        int[] nums = {1, 2, 3};
        int k = 3;

        System.out.println(solution(nums, k)); //1
        System.out.println(solution3(nums, k)); //1
    }

}
