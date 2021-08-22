package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
public class MaximumPointsFromCards {

    //O(k)
    //space O(1)
    private int solution(int[] points, int k) {
        int n = points.length;
        int leftSum = 0;

        for (int i = 0; i < k; i++) {
            leftSum += points[i];
        }

        //early return
        if (k == n) return leftSum;

        int maxSum = leftSum;
        int rightSum = 0;
        for (int i = 0; i < k; i++) {
            rightSum += points[n - 1 - i];
            leftSum -= points[k - 1 - i];
            maxSum = Math.max(maxSum, rightSum + leftSum);
        }

        return maxSum;
    }

    @Test
    public void test0() {
        int[] points = {100, 40, 17, 9, 73, 75};
        int k = 3;
        System.out.println(solution(points, k));
        /*
        Output: 248
         */
    }


    @Test
    public void test1() {
        int[] points = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(solution(points, k));
        /*
        Output: 12
        Explanation: After the first step, your score will always be 1.
        However, choosing the rightmost card first will maximize your total score.
        The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
         */
    }

    @Test
    public void test2() {
        int[] points = {2, 2, 2};
        int k = 2;
        System.out.println(solution(points, k));
        /*
        4
        Explanation: Regardless of which two cards you take, your score will always be 4.
         */
    }

    @Test
    public void test3() {
        int[] points = {9, 7, 7, 9, 7, 7, 9};
        int k = 7;
        System.out.println(solution(points, k));
        /*
        Output: 55
        Explanation: You have to take all the cards. Your score is the sum of points of all cards.
         */
    }

    @Test
    public void test4() {
        int[] points = {1, 1000, 1};
        int k = 1;
        System.out.println(solution(points, k));

        /*
        Output: 1
        Explanation: You cannot take the card in the middle. Your best score is 1.
         */
    }

    @Test
    public void test5() {
        int[] points = {1, 79, 80, 1, 1, 1, 200, 1};
        int k = 3;
        System.out.println(solution(points, k));

        /*
        Output: 202
         */
    }

}
