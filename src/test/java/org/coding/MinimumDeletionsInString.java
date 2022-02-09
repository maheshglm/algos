package org.coding;

import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

//https://algorithms.tutorialhorizon.com/minimum-deletions-to-make-the-occurrence-of-each-character-unique/
//https://molchevskyi.medium.com/best-solutions-for-microsoft-interview-tasks-min-deletions-to-make-frequency-of-each-letter-unique-16adb3ec694e
public class MinimumDeletionsInString {

    private int solution(String s) {
        int count = 0;
        int[] charsCount = new int[26];
        for (char c : s.toCharArray()) {
            charsCount[c - 'a']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int value : charsCount) {
            if (value != 0) {
                maxHeap.add(value);
            }
        }

        while (!maxHeap.isEmpty()) {
            Integer mostFrequent = maxHeap.poll();
            if (maxHeap.isEmpty()) return count;
            if (mostFrequent.equals(maxHeap.peek())) {
                if (mostFrequent > 1) {
                    maxHeap.add(mostFrequent - 1);
                }
                count++;
            }
        }
        return count;
    }

    @Test
    public void test1() {
        String s = "eeeeffff";
        //Output = 1
        System.out.println(solution(s));
    }

    @Test
    public void test2() {
        String s = "abcaabbcdaab";
        //Output = 0
        System.out.println(solution(s));
    }

    @Test
    public void test3() {
        String s = "aaaabbbbccccdddd";
        //Output = 6
        System.out.println(solution(s));
    }

    @Test
    public void test4() {
        String s = "aabbffddeaee";
        //Output = 6
        System.out.println(solution(s));
    }
}
