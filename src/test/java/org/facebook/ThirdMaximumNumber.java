package org.facebook;

import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//https://www.youtube.com/watch?v=7hbaFYuJY5Y
//https://leetcode.com/problems/third-maximum-number/
public class ThirdMaximumNumber {

    private int solution(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : set) {
            heap.add(num);
            if (heap.size() > 3) {
                heap.poll();
            }
        }

        if (heap.size() == 3) {
            return heap.peek();
        } else {
            int res = 0;
            while (!heap.isEmpty()) {
                res = heap.poll();
            }
            return res;
        }
    }

    @Test
    public void test1() {
        int[] nums = {3, 2, 1, 4};
        //output 2
        System.out.println(solution(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2};
        //output 2
        System.out.println(solution(nums));
    }

    @Test
    public void test3() {
        int[] nums = {2, 2, 3, 1};
        //output 1
        //Explanation: Note that the third maximum here means the third maximum distinct number.
        //Both numbers with value 2 are both considered as second maximum.
        System.out.println(solution(nums));
    }

    @Test
    public void test4() {
        int[] nums = {1, 1, 2};
        //output 2
        System.out.println(solution(nums));
    }

    @Test
    public void test5() {
        int[] nums = {-2147483648, 1, 1};
        //output -2147483648
        System.out.println(solution(nums));
    }
}
