package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharsByFrequency {

    //Using naive method
    public String solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        while (map.size() > 0) {
            Character key = map.entrySet().stream()
                    .max((o1, o2) -> o2.getValue() - o1.getValue())
                    .get()
                    .getKey();

            for (int i = 0; i < map.get(key); i++) {
                sb.append(key);
            }
            map.remove(key);
        }

        return sb.reverse().toString();
    }

    //Using MaxHeap Priority Queue
    public String solution1(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Character> maxHeap = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        maxHeap.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char key = maxHeap.poll();
            for (int i = 0; i < map.get(key); i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }

    @Test
    public void test1() {
        String s = "tree";
        System.out.println(solution(s)); //Output = eetr
        System.out.println(solution1(s)); //Output = eetr
    }

    @Test
    public void test2() {
        String s = "cccaaa";
        System.out.println(solution(s)); //Output = cccaaa
        System.out.println(solution1(s)); //Output = cccaaa
    }

    @Test
    public void test3() {
        String s = "Aabb";
        System.out.println(solution(s)); //Output = bbAa
        System.out.println(solution1(s)); //Output = bbAa
    }
}
