package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://www.youtube.com/watch?v=Ua0GhsJSlWM
//https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequence {

    //dynamic programming
    //splitting into sub problems
    //ex: abcde and ace, first letter is common, there we got a subsequence
    //now, problem can be divided into result till i + result after i
    //i.e. now we need to find subsequence in bcde and ce

    //recursively break problems into sub problems
    public int solution1(String text1, String text2) {
        return recursiveHelper(text1, text2, 0, 0);
    }

    //2 conditions
    //1) if first char matches abcde ace,
    //2) if first char does not match, abcde bbe => Max((bcde, bbe), (abcde, be))
    private int recursiveHelper(String text1, String text2, int i, int j) {

        //base condition, when i or j == to str length
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        int count;
        if (text1.charAt(i) == text2.charAt(j)) {
            count = 1 + recursiveHelper(text1, text2, i + 1, j + 1);
        } else {
            int result1 = recursiveHelper(text1, text2, i, j + 1);
            int result2 = recursiveHelper(text1, text2, i + 1, j);
            count = Math.max(result1, result2);
        }
        return count;
    }

    //recursive with memo as only recursive solution will give TLE with large inputs
    //memo is because we might end up calculating same subproblems in recursive way
    //I can store ij combination with count in a map or an array
    public int solution2(String text1, String text2) {
        return memoHelper(text1, text2, 0, 0, new HashMap<>());
    }

    private int memoHelper(String text1, String text2, int i, int j, Map<String, Integer> memo) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        if (memo.containsKey(i + "," + j)) {
            return memo.get(i + "," + j);
        }

        int count;
        if (text1.charAt(i) == text2.charAt(j)) {
            count = 1 + memoHelper(text1, text2, i + 1, j + 1, memo);
        } else {
            int result1 = memoHelper(text1, text2, i, j + 1, memo);
            int result2 = memoHelper(text1, text2, i + 1, j, memo);
            count = Math.max(result1, result2);
        }

        memo.put(i + "," + j, count);
        return count;
    }


    //O(MN) M - length 1st string, N - length of 2nd string
    //M * N possible sub problems
    //space O(MN)
    //memo solution with array
    public int solution3(String text1, String text2) {
        Integer[][] memo = new Integer[text1.length() + 1][text2.length() + 1];
        return memoHelper1(text1, text2, 0, 0, memo);
    }

    private int memoHelper1(String text1, String text2, int i, int j, Integer[][] memo) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int count = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            count = 1 + memoHelper1(text1, text2, i + 1, j + 1, memo);
        } else {
            int result1 = memoHelper1(text1, text2, i, j + 1, memo);
            int result2 = memoHelper1(text1, text2, i + 1, j, memo);
            count = Math.max(result1, result2);
        }

        memo[i][j] = count;
        return count;
    }

    /*
    Remembering too that each subproblem is represented as a pair of indexes,
    and that there are text1.length() * text2.length() such possible subproblems,
    we can iterate through the subproblems, starting from the smallest ones, and storing the answer for each.
    When we get to the larger subproblems, the smaller ones that they depend on will already have been solved.
    The best way to do this is to use a 2D array.
     */
    //2 case as handled above
    //1st letter is same in both strings - this is always diagonal (down & right cell)
    //or different - for this 2 things, right cell and down cell (i+1, j) (i, j+1)
    //time and space complexity are same as memo O(M*N)
    public int solution4(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        //iterate up from last column and last row
        for (int col = text2.length() - 1; col >= 0; col--) {
            for (int row = text1.length() - 1; row >= 0; row--) {
                if (text1.charAt(row) == text2.charAt(col)) {
                    dp[row][col] = 1 + dp[row + 1][col + 1];
                } else {
                    dp[row][col] = Math.max(dp[row + 1][col], dp[row][col + 1]);
                }
            }
        }
        return dp[0][0];
    }

    //with optimized space as we can reuse columns after computation
    //and we can use 1D array
    //space is O(min(M, N))
    public int solution5(String text1, String text2) {

        // If text1 doesn't reference the shortest string, swap them.
        if (text2.length() < text1.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        // The previous column starts with all 0's and like before is 1
        // more than the length of the first word.
        // the lengthier word
        int[] previous = new int[text1.length() + 1];
        int[] current = new int[text1.length() + 1];

        //its like to calculate 4th (current) column, we need 5th (previous) column
        //to calculate 3rd (current) column we need to only 4th column (previous)
        //we ll calculate current from previous after computation,
        //the current will become the previous for next column

        //iterate up from last column and last row
        for (int col = text2.length() - 1; col >= 0; col--) {
            for (int row = text1.length() - 1; row >= 0; row--) {
                if (text1.charAt(row) == text2.charAt(col)) {
                    current[row] = 1 + previous[row + 1];
                } else {
                    current[row] = Math.max(previous[row], current[row + 1]);
                }
            }
            //swap previous and current
            int[] temp = previous;
            previous = current;
            current = temp;
        }
        return previous[0];
    }


    @Test
    public void test1() {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(solution1(text1, text2));
        System.out.println(solution2(text1, text2));
        System.out.println(solution3(text1, text2));
        System.out.println(solution4(text1, text2));
        System.out.println(solution5(text1, text2));
        //3
        //Explanation: The longest common subsequence is "ace" and its length is 3.
    }

    @Test
    public void test2() {
        String text1 = "abc";
        String text2 = "abc";
        System.out.println(solution1(text1, text2));
        System.out.println(solution2(text1, text2));
        System.out.println(solution3(text1, text2));
        System.out.println(solution4(text1, text2));
        System.out.println(solution5(text1, text2));
        //3
    }


    @Test
    public void test3() {
        String text1 = "abc";
        String text2 = "def";
        System.out.println(solution1(text1, text2));
        System.out.println(solution2(text1, text2));
        System.out.println(solution3(text1, text2));
        System.out.println(solution4(text1, text2));
        System.out.println(solution5(text1, text2));
        //0
    }


    @Test
    public void test4() {
        String text1 = "bl";
        String text2 = "ybl";
        System.out.println(solution1(text1, text2));
        System.out.println(solution2(text1, text2));
        System.out.println(solution3(text1, text2));
        System.out.println(solution4(text1, text2));
        System.out.println(solution5(text1, text2));
        //1
    }

    @Test
    public void test5() {
        String text1 = "pmjghexybyrgzczy";
        String text2 = "hafcdqbgncrcbihkd";
        //System.out.println(solution1(text1, text2)); TLE in leet code
        System.out.println(solution2(text1, text2)); //401 ms in leet code still higher
        System.out.println(solution2(text1, text2)); //19 ms in leet code
        System.out.println(solution4(text1, text2)); //10 ms
        System.out.println(solution5(text1, text2));
        //4
    }

    @Test
    public void test6() {
        String text1 = "food";
        String text2 = "money";
        System.out.println(solution1(text1, text2));
        System.out.println(solution2(text1, text2));
        System.out.println(solution3(text1, text2));
        System.out.println(solution4(text1, text2));
        System.out.println(solution5(text1, text2));
        //1
    }

}
