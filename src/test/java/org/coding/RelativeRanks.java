package org.coding;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/problems/relative-ranks/
public class RelativeRanks {

    String[] ranks = {"Gold Medal", "Silver Medal", "Bronze Medal"};

    private String[] solution(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> (score[b] - score[a]));

        for (int i = 0; i < n; i++) {
            if (i < 3) {
                result[indices[i]] = ranks[i];
            } else {
                result[indices[i]] = i + 1 + "";
            }
        }
        return result;
    }

    private String[] solution1(int[] score) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = score.length;
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }

        Iterator<Integer> iterator = map.descendingKeySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            int val = iterator.next();
            if (i < 3) {
                result[map.get(val)] = ranks[i];
            } else {
                result[map.get(val)] = i + 1 + "";
            }
            i++;
        }
        return result;
    }


    @Test
    public void test1() {
        int[] score = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(solution(score)));
        System.out.println(Arrays.toString(solution1(score)));
        //Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
        //Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
    }

    @Test
    public void test2() {
        int[] score = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(solution(score)));
        System.out.println(Arrays.toString(solution1(score)));
        //Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
        //Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].

//        0 = {Integer@1101} 0 -- 10
//        1 = {Integer@1102} 3 -- 3
//        2 = {Integer@1103} 2 -- 8
//        3 = {Integer@1104} 4 -- 9
//        4 = {Integer@1105} 1 -- 4
    }
}
