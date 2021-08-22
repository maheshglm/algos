package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CharactersFrequency {

    //Assume non repeating sequence
    private String solution(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (c != ' ' && c != '\n' && c != '\0') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey())
                    .append(entry.getValue());
        }
        return sb.toString();
    }

    //What if there is repeating char sequence like test2
    private String solution1(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        char temp = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && s.charAt(i) != '\n') {
                if (s.charAt(i) != temp) {
                    sb.append(temp).append(map.get(temp));
                    map.remove(temp);
                }
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                temp = s.charAt(i);
            }
        }
        return sb.append(temp).append(map.get(temp)).toString();
    }

    @Test
    public void test1() {
        String s = "aabbcdde";
        //Output = a2b2c1d2e1
        System.out.println(solution(s));
    }

    @Test
    public void test2() {
        String s = "abab";
        //Output = a1b1a1b1
        System.out.println(solution(s));
        System.out.println(solution1(s));
    }

    @Test
    public void test3() {
        String s = "aabbcddeaae";
        //Output = a2b2c1d2e1a2e1
        System.out.println(solution1(s));
    }

    @Test
    public void test4() {
        String s = "jdsjdhd\n" +
                "jsbj\n" +
                "jsdbd\n";
        //Output = a2b2c1d2e1a2e1
        System.out.println(solution1(s));
    }
}
