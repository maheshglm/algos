package org.coding;

import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/discuss/1140197/Java-Simple-Explanation-(beats-99)
//https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/
public class MaxNumberConsecutiveValues {


    /*
    You are given an integer array coins of length n which represents the n coins that you own.
    The value of the ith coin is coins[i].
    You can make some value x if you can choose some of your n coins such that their values sum up to x.
    Return the maximum number of consecutive integer values that you can make with your coins starting from and including 0.
    Note that you may have multiple coins of the same value.
     */

    private int solution(int[] coins) {
        Arrays.sort(coins);
        int total = 0;
        for (int c : coins) {
            if (c <= total + 1) total += c;
            else break;
        }
        //adding 1 for empty sum i.e. without collecting any coins 'zero'
        return total + 1;
    }


    @Test
    public void test1() {
        int[] coins = {1, 3};
        System.out.println(solution(coins));
        //output  2
        /*
        Explanation: You can make the following values:
        - 0: take []
        - 1: take [1]
        You can make 2 consecutive integer values starting from 0.
         */
    }

    @Test
    public void test2() {
        int[] coins = {1, 1, 1, 4};
        System.out.println(solution(coins));
        //Output 8
        /*
        Explanation: You can make the following values:
        - 0: take []
        - 1: take [1]
        - 2: take [1,1]
        - 3: take [1,1,1]
        - 4: take [4]
        - 5: take [4,1]
        - 6: take [4,1,1]
        - 7: take [4,1,1,1]
        You can make 8 consecutive integer values starting from 0.
         */
    }

    @Test
    public void test3() {
        int[] coins = {1, 4, 10, 3, 1};
        System.out.println(solution(coins));
        //output 20
    }

}
