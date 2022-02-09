package org.coding;

import org.junit.Test;

//https://www.youtube.com/watch?v=AO1wlMJoxBk&t=956s
//https://www.youtube.com/watch?v=Lj90FqNCIJE&list=PLSIpQf0NbcClDpWE58Y-oSJro_W3LO8Nb
public class LongestCommonSubstring {

    private int solution(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        if (s1.length() == 0 || s2.length() == 0) return 0;

        //return helper(s1, s2, 0, 0, 0);
        Integer[][] memo = new Integer[s1.length() + 1][s2.length() + 1];
        return helper(s1, s2, 0, 0, 0, memo);
    }

    private int helper(String s1, String s2, int i, int j, int maxLen) {
        if (i == s1.length() || j == s2.length()) {
            return maxLen;
        }

        int temp = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            maxLen = helper(s1, s2, i + 1, j + 1, maxLen + 1);
        }

        temp = Math.max(helper(s1, s2, i + 1, j, 0),
                helper(s1, s2, i, j + 1, 0));

        return Math.max(maxLen, temp);
    }

    //2D memo does not work for all cases, bcoz there are 3 variables changes
    //i, j and maxLen.
    //So hashmap with custom key yieds correct result
    private int helper(String s1, String s2, int i, int j, int maxLen, Integer[][] memo) {
        if (i == s1.length() || j == s2.length()) {
            return maxLen;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int temp = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            maxLen = helper(s1, s2, i + 1, j + 1, maxLen + 1, memo);
        }

        temp = Math.max(helper(s1, s2, i + 1, j, 0, memo),
                helper(s1, s2, i, j + 1, 0, memo));

        memo[i][j] = Math.max(maxLen, temp);
        return memo[i][j];
    }


    //https://www.youtube.com/watch?v=Lj90FqNCIJE&list=PLSIpQf0NbcClDpWE58Y-oSJro_W3LO8Nb
    //Bottom up approach
    //O(MN)
    //space O(MN)
    private int solution1(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int result = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }


    @Test
    public void test1() {
        String s1 = "ABAB";
        String s2 = "BABA";

        System.out.println(solution(s1, s2));
        System.out.println(solution1(s1, s2));

        //output = ABA = 3
    }

    @Test
    public void test2() {
        String s1 = "JAVAAID";
        String s2 = "JAVAID";

        System.out.println(solution(s1, s2));
        System.out.println(solution1(s1, s2));

        //output = JAVA = 4
    }

}
