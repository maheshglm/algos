package org.facebook;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {

    private int[] solution(int[] nums, int k) {
        if (k == nums.length) return nums;

        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> counts.get(n2) - counts.get(n1));

        for (int n : counts.keySet()) {
            pq.add(n);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    @Test
    public void test1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(solution(nums, k)));
        //output = 1,2
    }

    @Test
    public void test2() {
        int[] nums = {1};
        int k = 1;
        System.out.println(Arrays.toString(solution(nums, k)));
        //output = 1
    }

}
