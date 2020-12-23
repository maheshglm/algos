package org.facebook;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AnagramsCheck {


    public boolean solution3(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        StringBuilder sb = new StringBuilder(s2);

        for (char c : s1.toCharArray()) {
            int index = sb.toString().indexOf(c);
            if (index != -1) {
                sb.deleteCharAt(index);
            } else {
                return false;
            }
        }
        return sb.toString().isEmpty();
    }

    //This is using HashMap but clean solution will handle Unicode characters as well.
    private boolean solution2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) != 0) return false;
        }
        return true;
    }

    //This is using HashMap, will handle unicode characters as well.
    private boolean solution(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        //what if both strings are equal - no need to check entire loops,
        // by default they are anagrams by itself
        if (s1.equals(s2)) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    //Using char Array
    //char[] array is of size 26 is because only lower case is allowed
    private boolean solution1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] charCount = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i) - 'a']++;
            charCount[s2.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test1() {
        String s1 = "abcd";
        String s2 = "cdba";
        System.out.println(solution(s1, s2)); //true
        System.out.println(solution1(s1, s2)); //true
        System.out.println(solution3(s1, s2)); //true
    }

    @Test
    public void test2() {
        String s1 = "anagram";
        String s2 = "nagaram";
        System.out.println(solution(s1, s2)); //true
        System.out.println(solution1(s1, s2)); //true
        System.out.println(solution3(s1, s2)); //true
    }

    @Test
    public void test3() {
        String s1 = "rat";
        String s2 = "car";
        System.out.println(solution(s1, s2)); //false
        System.out.println(solution1(s1, s2)); //false
        System.out.println(solution3(s1, s2)); //false
    }

    @Test
    public void test4() {
        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";
        System.out.println(solution(s1, s2)); //true
        System.out.println(solution1(s1, s2)); //true
        System.out.println(solution3(s1, s2)); //true
    }
}
