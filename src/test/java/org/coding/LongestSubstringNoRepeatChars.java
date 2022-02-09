package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstringNoRepeatChars {

    private int solution1(String s) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(map.get(c) + 1, left);
            }
            maxLen = Math.max(maxLen, right - left + 1);
            map.put(c, right);
            right++;
        }
        return maxLen;
    }

    //this is successful but takes more time
    private int solution(String s) {
        int windowEnd = 0;
        int windowStart = 0;
        int maxLen = 0;

        HashSet<Character> set = new HashSet<>();

        while (windowEnd < s.length()) {
            if (set.contains(s.charAt(windowEnd))) {
                set.remove(s.charAt(windowStart++));
            } else {
                set.add(s.charAt(windowEnd++));
                maxLen = Math.max(maxLen, set.size());
            }
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

    @Test
    public void test4() {
        String s = "aab";
        //output = 2 -> ab
        System.out.println(solution(s));
    }
}
