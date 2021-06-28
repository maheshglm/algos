package org.coding;

import org.junit.Test;

import java.security.PublicKey;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/jump-game-iii/
public class JumpGameIII {


    /*
    Given an array of non-negative integers arr,
    you are initially positioned at start index of the array.
    When you are at index i, you can jump to i + arr[i] or i - arr[i],
    check if you can reach to any index with value 0.
    Notice that you can not jump outside of the array at any time.
     */

    class Pair {
        int index;
        int val;

        Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    private boolean solution(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (arr[i] == 0) return true;


            int maxIndex = i + arr[i];
            int minIndex = i - arr[i];

            if (maxIndex < n && !visited[maxIndex]) {
                queue.add(maxIndex);
                visited[maxIndex] = true;
            }

            if (minIndex >= 0 && !visited[minIndex]) {
                queue.add(minIndex);
                visited[minIndex] = true;
            }
        }
        return false;
    }


    @Test

    public void test1() {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        System.out.println(solution(arr, start));
        //output = true
        /*
        Explanation:
            All possible ways to reach at index 3 with value 0 are:
            index 5 -> index 4 -> index 1 -> index 3
            index 5 -> index 6 -> index 4 -> index 1 -> index 3
         */
    }

    @Test
    public void test2() {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 0;
        System.out.println(solution(arr, start));
        //output = true
        /*
        Explanation:
            One possible way to reach at index 3 with value 0 is:
            index 0 -> index 4 -> index 1 -> index 3
         */
    }

    @Test
    public void test3() {
        int[] arr = {3, 0, 2, 1, 2};
        int start = 2;
        System.out.println(solution(arr, start));
        //false There is no way to reach at index 1 with value 0.
    }
}
