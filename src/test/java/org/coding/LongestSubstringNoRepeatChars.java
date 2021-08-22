package org.coding;

import org.junit.Test;

import java.util.HashSet;

public class LongestSubstringNoRepeatChars {

    private int solution(String s) {
        int windowEnd = 0;
        int windowStart = 0;
        int maxLen = Integer.MIN_VALUE;

        HashSet<Character> set = new HashSet<>();

        while (windowEnd < s.length()) {
            char right = s.charAt(windowEnd);
            if (set.contains(right)) {
                set.remove(s.charAt(windowStart));
                windowStart++;
            } else {
                set.add(right);
                maxLen = Math.max(maxLen, set.size());
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
