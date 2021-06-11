package org.coding;

import org.junit.Test;

//https://www.youtube.com/watch?v=DK5OKKbF6GI
public class LongestPalindromeSubstring {

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }


    int resultStart = 0;
    int resultLength = 0;

    private String solution2(String s) {
        if (s == null) {
            return null;
        }

        if (s.length() <= 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            extendRange(s, i, i);
            extendRange(s, i, i + 1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    private void extendRange(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (resultLength < right - 1 - left) {
            resultLength = right - 1 - left;
            resultStart = left + 1;
        }
    }


    //O(n^3) = n^2 for 2 loops and n for checking palindrome or not
    private static String solution1(String input) {
        int maxLen = 0;
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                String substring = input.substring(i, j + 1);
                int currentLength = j + 1 - i;
                if (isPalindrome(substring) && currentLength > maxLen) {
                    maxLen = currentLength;
                    result = substring;
                }
            }
        }
        return result;
    }


    @Test
    public void test1() {
        String s = "babad";
        System.out.println(solution2(s));//bab
    }

    @Test
    public void test2() {
        String s = "cbbd";
        System.out.println(solution2(s)); //bb
    }

    @Test
    public void test3() {
        String s = "racecar";
        System.out.println(solution2(s)); //racecar
    }
}
