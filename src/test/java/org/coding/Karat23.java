package org.coding;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/discuss/interview-question/786821/Indeed-or-OA-2020-or-Parents-and-Children-(Graph)
public class Karat23 {

    private boolean solution(int[][] parentChildPairs, int c1, int c2) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : parentChildPairs) {
            int parent = pair[0];
            int child = pair[1];

            map.putIfAbsent(parent, new ArrayList<>());
            map.putIfAbsent(child, new ArrayList<>());
            map.get(child).add(parent);
        }

        if (map.get(c1).size() == 0 || map.get(c2).size() == 0) return false;

        List<Integer> c1Parents = getParents(map, c1);
        List<Integer> c2Parents = getParents(map, c2);

        System.out.println(getCommonAncestor(c1Parents, c2Parents));

        return hasCommon(c1Parents, c2Parents);
    }

    private boolean hasCommon(List<Integer> list1, List<Integer> list2) {
        for (int l1 : list1) {
            if (list2.contains(l1)) {
                return true;
            }
        }
        return false;
    }

    private int getCommonAncestor(List<Integer> list1, List<Integer> list2) {
        for (int l1 : list1) {
            if (list2.contains(l1)) {
                return l1;
            }
        }
        return -1;
    }


    private List<Integer> getParents(Map<Integer, List<Integer>> map, int c1) {
        List<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(c1);
        while (!queue.isEmpty()) {
            List<Integer> curr = map.get(queue.poll());
            for (int p : curr) {
                queue.add(p);
                result.add(p);
            }
        }
        return result;
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
                {9, 11},
                {14, 4},
                {13, 12},
                {12, 9}
        };

        //has common ancestor
        System.out.println(solution(parentChildPairs, 3, 8)); //false
        System.out.println(solution(parentChildPairs, 5, 8)); //true
        System.out.println(solution(parentChildPairs, 6, 8)); //true
        System.out.println(solution(parentChildPairs, 6, 9)); //true
        System.out.println(solution(parentChildPairs, 1, 3)); //false
        System.out.println(solution(parentChildPairs, 3, 1)); //false
        System.out.println(solution(parentChildPairs, 7, 11)); //true
        System.out.println(solution(parentChildPairs, 6, 5)); //true
        System.out.println(solution(parentChildPairs, 5, 6)); //true
    }

}
