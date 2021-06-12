package org.coding;

import org.junit.Test;

//https://www.youtube.com/watch?v=YcJTyrG3bZs
//https://leetcode.com/problems/decode-ways/
//https://www.youtube.com/watch?v=cQX3yHS0cLo
//https://www.youtube.com/watch?v=qli-JCrSwuk&t=16s
//https://www.youtube.com/watch?v=97fVUMvaX3k
//https://www.youtube.com/watch?v=W4rYz-kd-cY&t=313s
public class DecodeWays {


    private int solution1(String s) {
        int[] dp = new int[s.length() + 1];
        return helper(s, s.length() - 1, dp);
    }

    private int helper(String s, int index, int[] dp) {

        if (index == 0) {
            if (s.charAt(index) == '0') {
                dp[index] = 0;
            } else {
                dp[index] = 1;
            }
            return dp[index];
        }

        if (index == -1) return 1;

        if (dp[index] != 0) return dp[index];

        if (s.charAt(index) == '0') {
            if (s.charAt(index - 1) == '1' || s.charAt(index - 1) == '2') {
                dp[index] = 1;
            } else {
                dp[index] = 0;
            }
            return dp[index];
        }

        int ways = 0;
        if (s.charAt(index - 1) == '1' || (s.charAt(index - 1) == '2' && s.charAt(index) - '0' <= 6)) {
            ways = helper(s, index - 1, dp) + helper(s, index - 2, dp);
        } else {
            ways = helper(s, index - 2, dp);
        }
        dp[index] = ways;
        return ways;
    }


    //This is 2^n ways,
    private int solution(String s) {
        return helper(s, s.length() - 1);
    }

    private int helper(String s, int index) {

        if (index == 0) {
            if (s.charAt(index) == '0') {
                return 0;
            } else {
                return 1;
            }
        }

        if (index == -1) {
            return 1;
        }

        if (s.charAt(index) - '0' == 0) {
            if (s.charAt(index - 1) - '0' == 1 || s.charAt(index - 1) - '0' == 2) {
                return helper(s, index - 2);
            } else {
                return 0;
            }
        }

        int ways = 0;
        if (s.charAt(index - 1) - '0' == 1 || (s.charAt(index - 1) - '0' == 2 && s.charAt(index) - '0' < 7)) {
            ways = helper(s, index - 1) + helper(s, index - 2);
        } else {
            ways = helper(s, index - 1);
        }
        return ways;
    }


    @Test
    public void test1() {
        String s = "12";
        System.out.println(solution(s));
        System.out.println(solution1(s));
        //output: 2  "12" could be decoded as "AB" (1 2) or "L" (12).
    }

    @Test
    public void test2() {
        String s = "226";
        System.out.println(solution(s));
        //System.out.println(solution1(s));

        //output: 3  "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
    }

    @Test
    public void test3() {
        String s = "0";
        System.out.println(solution(s));
        //System.out.println(solution1(s));

        //output: There is no character that is mapped to a number starting with 0.
        //The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
        //Hence, there are no valid ways to decode this since all digits need to be mapped.
    }

    @Test
    public void test4() {
        String s = "06";
        System.out.println(solution(s));
        System.out.println(solution1(s));

        //0 : "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").

    }
}