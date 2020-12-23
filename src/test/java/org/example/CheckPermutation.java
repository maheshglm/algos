package org.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    String sort(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return Arrays.toString(a);
    }

    public boolean solution1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return sort(s1).equals(sort(s2));
    }

    public boolean solution2(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        return map.entrySet().stream()
                .filter(x -> x.getValue() != 0)
                .map(Map.Entry::getKey).count() == 0;
    }

    public boolean solution3(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] letters = new int[128];
        for (char c : s1.toCharArray()) {
            letters[c]++;
        }
        for (char c : s2.toCharArray()) {
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        String s1 = "God";
        String s2 = "dog";
        boolean b = solution3(s1, s2);
        System.out.println(b);

    }
}
