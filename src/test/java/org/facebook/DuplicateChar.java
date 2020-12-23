package org.facebook;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://www.java67.com/2014/03/how-to-find-duplicate-characters-in-String-Java-program.html
public class DuplicateChar {

    private void solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }

        System.out.println();
    }

    @Test
    public void test1() {
        String s1 = "Programming";
        String s2 = "Combination";
        String s3 = "Java";

        solution(s1);
        solution(s2);
        solution(s3);
    }
}
