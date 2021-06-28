package org.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

//https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3jEPRo5PDvx
public class CanPartition {

    /*
    Given a set of positive numbers,
    find if we can partition it into two subsets such that the sum of elements in both the subsets is equal.
     */

    public boolean solution(int[] arr) {
        int sum = Arrays.stream(arr).sum();

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if (sum % 2 != 0) return false;

        //return recursive(arr, sum / 2, 0);
        return withMemo(arr, sum / 2, 0, new HashMap<>());
    }

    //Time complexity is 2^n (exponential)
    //space complexity is O(n)
    private boolean recursive(int[] arr, int halfSum, int index) {
        if (halfSum == 0) return true;
        if (arr.length == 0 || index >= arr.length) return false;

        if (arr[index] <= halfSum) {
            if (recursive(arr, halfSum - arr[index], index + 1)) {
                return true;
            }
        }
        return recursive(arr, halfSum, index + 1);
    }

    //Time & space - O(N * S) - n - total number in array and S total sum of elements
    private boolean withMemo(int[] arr, int halfSum, int index, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(halfSum)) return memo.get(halfSum);
        if (halfSum == 0) return true;
        if (arr.length == 0 || index >= arr.length) return false;

        if (arr[index] <= halfSum) {
            if (withMemo(arr, halfSum - arr[index], index + 1, memo)) {
                memo.put(halfSum, true);
                System.out.print(arr[index] + " ");
                return true;
            }
        }
        boolean result = withMemo(arr, halfSum, index + 1, memo);
        memo.put(halfSum, result);
        return result;
    }

    /*
    This means, dp[i][s] will be ‘true’ if we can make sum ‘s’ from the first ‘i’ numbers.

    So, for each number at index ‘i’ (0 <= i < num.length) and sum ‘s’ (0 <= s <= S/2), we have two options:

    Exclude the number.

    In this case, we will see if we can get ‘s’ from the subset excluding this number: dp[i-1][s]

    Include the number

    if its value is not more than ‘s’.
    In this case, we will see if we can find a subset to get the remaining sum: dp[i-1][s-num[i]]

     */
    private boolean solution1(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0) return false;

        sum /= 2;
        boolean[][] dp = new boolean[arr.length][sum + 1];

        // populate the sum=0 column, as we can always have '0' sum without including any element
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }

        // with only one number, we can form a subset only when the required sum is equal to its value
        for (int s = 1; s < sum + 1; s++) {
            if (arr[0] == s) {
                dp[0][s] = true;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 4};
        //True {1,4} and {2, 3}
        System.out.println(solution(arr));//true
    }

    @Test
    public void test2() {
        int[] arr = {1, 1, 3, 4, 7};
        //True {1,3,4}, {1,7}
        System.out.println(solution(arr));//true

    }

    @Test
    public void test3() {
        int[] arr = {2, 3, 4, 6};
        //False
        System.out.println(solution(arr));//false

    }
}
