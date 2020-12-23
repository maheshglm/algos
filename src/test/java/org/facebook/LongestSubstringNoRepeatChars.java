package org.facebook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringNoRepeatChars {

    private int solution(String s) {
        int windowEnd = 0;
        int windowStart = 0;
        int maxLen = Integer.MIN_VALUE;

        List<Character> list = new ArrayList<>();

        while (windowEnd < s.length()) {
            char right = s.charAt(windowEnd);

            if (list.contains(right)) {
                list.remove((Character) s.charAt(windowStart));
                windowStart++;
            } else {
                list.add(right);
                maxLen = Math.max(maxLen, list.size());
            }

            windowEnd++;
        }
        return maxLen;
    }

    @Test
    public void test1() {
        String s = "abcabcab";
        //output = 3 -> abc
        System.out.println(solution(s));
    }

    @Test
    public void test2() {
        String s = "bbbbb";
        //output = 1 -> b
        System.out.println(solution(s));
    }

    @Test
    public void test3() {
        String s = "pwwkew";
        //output = 3 -> wke
        System.out.println(solution(s));
    }
}
