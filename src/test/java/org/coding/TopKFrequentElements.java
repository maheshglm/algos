package org.coding;

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

        //inserting in reverse order so that we can poll in opposite way
        //smaller numbers first
        Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> counts.get(n1) - counts.get(n2));

        //there are 2 options, insert into PQ in reverse order and add n elements to pq
        //but with that approach the time complexity is O(NlogN) instead of O(NlogK)
        for (int n : counts.keySet()) {
            pq.add(n);
            if (pq.size() > k) pq.poll();
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
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
