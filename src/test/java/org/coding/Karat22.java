package org.coding;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/discuss/interview-question/1006763/compass-technical-assessment-karat
public class Karat22 {

    /*
    Write a function that takes this data as input and returns two collections:
    one containing all individuals with zero known parents,
    and one containing all individuals with exactly one known parent.
     */

    private List<List<Integer>> solution(int[][] pairs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : pairs) {
            int parent = pair[0];
            int child = pair[1];
            map.putIfAbsent(parent, 0);
            map.put(child, map.getOrDefault(child, 0) + 1);
        }

        List<Integer> zeroParent = new ArrayList<>();
        List<Integer> oneParent = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                zeroParent.add(entry.getKey());
            }
            if (entry.getValue() == 1) {
                oneParent.add(entry.getKey());
            }
        }

        return Arrays.asList(zeroParent, oneParent);
    }

    @Test
    public void test1() {
        int[][] parentChildPairs = {
                {1, 3},
                {2, 3},
                {3, 6},
                {5, 6},
                {5, 7},
                {4, 5},
                {4, 8},
                {4, 9},
                {9, 11}
        };

        System.out.println(solution(parentChildPairs));

        // Individuals with zero parents [1, 2, 4]
        // Individuals with exactly one parent [5, 7, 8, 9, 11]
    }

    @Test
    public void test2() {
        int[][] parentChildPairs = {
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5},
                {6, 5}
        };

        System.out.println(solution(parentChildPairs));

        // Individuals with zero parents [1, 2, 6]
        // Individuals with exactly one parent [4]
    }

}
