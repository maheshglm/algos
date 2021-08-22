package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/delete-operation-for-two-strings/
public class MinDeletionsStringEquals {

    //shortcut to calculate this is LCS = LeastCommonSequence(text1, text2)
    //min deletions = text1.length() + text2.length - 2*LCS

    private int solution(String text1, String text2) {
        return text1.length() + text2.length() - 2 * leastCommonSubsequence(text1, text2);
    }

    private int leastCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int row = text1.length() - 1; row >= 0; row--) {
            for (int col = text2.length() - 1; col >= 0; col--) {
                if (text1.charAt(row) == text2.charAt(col)) {
                    dp[row][col] = 1 + dp[row + 1][col + 1];
                } else {
                    dp[row][col] = Math.max(dp[row][col + 1], dp[row + 1][col]);
                }
            }
        }
        return dp[0][0];
    }

    private int solution1(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


    private int solution2(String text1, String text2) {
        return helper(text1, text2, 0, 0);
    }

    private int helper(String text1, String text2, int i, int j) {
        //When i == len(A) or j == len(B), one of the strings is empty,
        //so the answer is just the sum of the remaining lengths

        if (i == text1.length() || j == text2.length()) {
            return text1.length() + text2.length() - i - j;
        }

        int ans;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = helper(text1, text2, i + 1, j + 1);
        } else {
            ans = 1 + Math.min(helper(text1, text2, i, j + 1), helper(text1, text2, i + 1, j));
        }

        return ans;

    }


    @Test
    public void test1() {
        String text1 = "sea";
        String text2 = "eat";
        System.out.println(solution(text1, text2));
        System.out.println(solution1(text1, text2));
        System.out.println(solution2(text1, text2));
        //Output: 2
        //Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
    }

    @Test
    public void test2() {
        String text1 = "leetcode";
        String text2 = "etco";
        System.out.println(solution(text1, text2));
        System.out.println(solution1(text1, text2));
        System.out.println(solution2(text1, text2));
        //Output: 4
        //Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
    }

}
