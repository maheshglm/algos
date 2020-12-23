package org.facebook;

import org.junit.Test;

import java.util.PriorityQueue;

//https://algorithms.tutorialhorizon.com/construct-the-largest-number-from-the-given-array/
public class ConstructLargeNumber {

    private long solution(int[] nums) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> {
            String o1o2 = o1 + String.valueOf(o2);
            String o2o1 = o2 + String.valueOf(o1);
            return o2o1.compareTo(o1o2);
        });

        for (int num : nums) {
            maxHeap.add(num);
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            sb.append(maxHeap.poll());
        }
        return Long.parseLong(sb.toString());
    }

    @Test
    public void test1() {
        int[] nums = {7, 78};
        System.out.println(solution(nums)); //787
    }

    @Test
    public void test3() {
        int[] nums = {8, 71};
        System.out.println(solution(nums)); //871
    }

    @Test
    public void test2() {
        int[] nums = {25, 42, 39};
        System.out.println(solution(nums)); //423925
    }
}
