package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestLengthOfChar {

    private int solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                int startIndex = map.get(key);
                max = Math.max(max, i - startIndex);
            } else {
                map.put(key, i);
            }
        }
        return max;
    }

    @Test
    public void test1() {
        String s = "ada";
        System.out.println(solution(s)); //output = 2
    }

    @Test
    public void test2() {
        String s = "asdfsadf";
        System.out.println(solution(s)); //output = 5
    }
}
