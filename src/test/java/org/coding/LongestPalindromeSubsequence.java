package org.coding;

import org.junit.Test;


//https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
//https://leetcode.com/problems/longest-palindromic-subsequence/
public class LongestPalindromeSubsequence {


    //Case 1:
    //If the ends of a string are the same i.e s(i) == s[j],
    // then we already know we have a palindromic subsequence of length 2,
    // so we can recursively call a fn() and pass on the remainder of the substring s(1+1, j-1)
    // which will give us the length of the longest pali. substring from i+1 -> j-1 and add 2 to it
    // (since s[i] == s[j] is 2 characters already)
    //
    //Case 2:
    //if the ends of the string are not same, then we cannot discount both of these characters at once,
    // we can omit either one of then and recursively call our function to give us the length of the
    // longest palindromic subsequence and take the max of these.
    //
    //Eg:        "x c c  a  a  c  c  m "
    //index       0 1 2  3  4  5  6  7
    //
    //Let F(n) be a function that calculates the lenght of the longest palindromic substring within indices i and j
    //The recursive tree will look like
    //
//							                      f(0, 7)
//							                    /         \
//			                               f(0,6)	       f(1, 7)
//		                                /      \             /    \
//                                  f(0,5)	 f(1, 6)	  f(1, 6)  f(2,7)
    //
    //Here we cna see that normal recursion will have overlapping problems f(1,6)
    //The TC for such a naive recursion is exponential i.e 2 ^ n ( branches ^ depth)
    //
    //We can make this polynomial by using memoization. Thus we use Dynamic Programming to solve this problem.

    //recursive with memo
    private int solution(String s) {
        if (s == null || s.length() == 0) return 0;
        Integer[][] memo = new Integer[s.length()][s.length()];
        return helper(s, 0, s.length() - 1, memo);
    }

    private int helper(String s, int left, int right, Integer[][] memo) {
        if (left == right) return 1;
        if (left > right) return 0;

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        int max;
        if (s.charAt(left) == s.charAt(right)) {
            max = 2 + helper(s, left + 1, right - 1, memo);
        } else {
            max = Math.max(
                    helper(s, left + 1, right, memo),
                    helper(s, left, right - 1, memo)
            );
        }
        memo[left][right] = max;
        return max;
    }

    //dp
    //dp[i][j]: the longest palindromic subsequence's length of substring(i, j),
    //here i, j represent left, right indexes in the string
    //State transition:
    //dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
    //otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
    //Initialization: dp[i][i] = 1

    //https://www.youtube.com/watch?v=_nCsPn7_OgI
    private int solution1(String s) {
        int[][] dp = new int[s.length()][s.length()];
        //which means for each char, max subsequence len is 1
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        //now we go taking lengths from 2 to s.length()
        //like 2 char length, 3 char length....s char length
        for (int len = 2; len <= s.length(); len++) {
            //ex: bbbab, when len =2, i can travel upto 3rd index length i.e. 5 - 3 + 1 = 3
            for (int i = 0; i < s.length() - len + 1; i++) {
                //for each i, j = len + i - 1
                //ex:
                //i = 0, len =2 -> j = 2+0-1 = 1
                //i = 1, len =2 -> j = 2+1-1 = 2
                //i = 3, len =4 -> j = 4 + 3 -1 = 6, like we take len steps for each i
                int j = i + len - 1;

                boolean b = s.charAt(i) == s.charAt(j);
                if (len == 2 && b) {
                    dp[i][j] = 2;
                } else if (b) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        //result is at 0th row and last column
        return dp[0][s.length() - 1];
    }


    //another dp solution which I feel quite easy
    private int solution2(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }


    @Test
    public void test1() {
        String s = "bbbab";
        System.out.println(solution(s));
        System.out.println(solution2(s));
        //4
        //Explanation: One possible longest palindromic subsequence is "bbbb".
    }

    @Test
    public void test2() {
        String s = "cbbd";
        System.out.println(solution(s));
        System.out.println(solution2(s));
        //2
        //Explanation: One possible longest palindromic subsequence is "bb".
    }
}
