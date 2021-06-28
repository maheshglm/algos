package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RM1BDv71V60
//https://medium.com/@fabianterh/how-to-solve-the-knapsack-problem-with-dynamic-programming-eb88c706d3cf
public class Knapsack01 {

    //0-1 knapsack - either include an item or exclude
    //bruteforce
    private int solution(int[] profits, int[] weights, int capacity) {
        //return memoizationWithArray(profits, weights, capacity, 0, new Integer[profits.length][capacity + 1]);
        //return memoization(profits, weights, capacity, 0, new HashMap<>());
        //return recursive1(profits, weights, capacity, 0);
        return bottomUpDP(profits, weights, capacity);

    }

    private int recursive1(int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }

        //include element
        int profit1 = 0;
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] +
                    recursive1(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
        }

        //excluded element
        int profit2 = recursive1(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit2, profit1);
    }

    /*
    N - number of items
    C - knapsack capacity
    Time complexity - O(N * C )
    Space - O(N*C + N) => O(N*C)
     */
    private int memoization(int[] profits, int[] weights, int capacity, int currentIndex, Map<String, Integer> memo) {
        if (memo.containsKey(capacity + "," + currentIndex)) return memo.get(capacity + "," + currentIndex);

        //base case
        if (capacity <= 0 || currentIndex >= profits.length) return 0;

        //include element
        int profit1 = 0;
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] +
                    memoization(profits, weights, capacity - weights[currentIndex], currentIndex + 1, memo);
        }

        //excluded element
        int profit2 = memoization(profits, weights, capacity, currentIndex + 1, memo);

        int max = Math.max(profit2, profit1);
        memo.put(capacity + "," + currentIndex, max);
        return max;
    }


    //Memoization with DP Array
    private int memoizationWithArray(int[] profits, int[] weights, int capacity, int currentIndex, Integer[][] dp) {

        //base case
        if (capacity <= 0 || currentIndex >= profits.length) return 0;

        //while using dp array, below validation should be after base case to avoid array out of index exception
        if (dp[currentIndex][capacity] != null) return dp[currentIndex][capacity];

        //include element
        int profit1 = 0;
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] +
                    memoizationWithArray(profits, weights, capacity - weights[currentIndex], currentIndex + 1, dp);
        }

        //excluded element
        int profit2 = memoizationWithArray(profits, weights, capacity, currentIndex + 1, dp);

        int max = Math.max(profit2, profit1);
        dp[currentIndex][capacity] = max;
        return max;
    }


    //dp[i][c] = max(dp[i-1][c] + profits[i] + dp[i-1][c-weights[i]])

    private int bottomUpDP(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length) return 0;

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        // populate the capacity=0 columns, with '0' capacity we have '0' profit
        //which is basically filling 1 column with all '0' as if capacity itself zero
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        // if we have only one weight, we will take it if it is not more than the capacity
        for (int c = 0; c < capacity + 1; c++) {
            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        // process all sub-arrays for all the capacities
        for (int i = 1; i < n; i++) {
            for (int c = 1; c < capacity + 1; c++) {
                int profit1 = 0, profit2 = 0;
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                }
                profit2 = dp[i - 1][c];

                dp[i][c] = Math.max(profit1, profit2);

            }
        }
        return dp[n - 1][capacity];
    }


    @Test
    public void test1() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 7;
        System.out.println(solution(profits, weights, capacity));//22
    }

    @Test
    public void test2() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 6;
        System.out.println(solution(profits, weights, capacity));//17
    }


}
