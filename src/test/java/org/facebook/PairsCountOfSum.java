package org.facebook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=bvKMZXc0jQU
//https://algorithms.tutorialhorizon.com/given-an-array-count-the-number-of-pairs-with-a-given-sum/
public class PairsCountOfSum {

    private int solution(int[] nums, int targetSum) {
        int count = 0;

        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }

        for (int n : nums) {
            int diff = targetSum - n;
            if (list.contains(diff)) {
                count++;
                list.remove((Integer) n);
                list.remove((Integer) diff);
                System.out.println("pair => (" + n + "," + diff + ")");
            }
        }
        return count;
    }

    @Test
    public void test1() {
        int[] nums = {1, 5, 7, -1};
        int targetSum = 6;
        System.out.println(solution(nums, targetSum)); //2
    }

    @Test
    public void test2() {
        int[] nums = {4, 5, 1, 2, 9, -2, -4};
        int targetSum = 5;
        System.out.println(solution(nums, targetSum)); //2
    }

    @Test
    public void test3() {
        int[] nums = {3, 3, 3, 3};
        int targetSum = 6;
        System.out.println(solution(nums, targetSum)); //2
    }

    @Test
    public void test4() {
        int[] nums = {1, 1, 2, 45, 46, 46};
        int targetSum = 47;
        System.out.println(solution(nums, targetSum)); //3

        /* to get unique pairs we need to add map.remove(diff)
        pair => (1,46)
        pair => (1,46)
        pair => (2,45)
         */
    }

    @Test
    public void test5() {
        int[] nums = {1, 1};
        int targetSum = 2;
        System.out.println(solution(nums, targetSum)); //1
    }

    @Test
    public void test6() {
        int[] nums = {1, 5, 1, 5};
        int targetSum = 6;
        System.out.println(solution(nums, targetSum)); //2
    }
}
