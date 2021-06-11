package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FirstNonRepeatedChar {

    private char solution(String s) {
        List<Character> nonRepeated = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            if (nonRepeated.contains(letter)) {
                nonRepeated.remove((Character) letter);
            } else {
                nonRepeated.add(letter);
            }
        }

        return nonRepeated.get(0);
    }

    @Test
    public void test1() {
        String s = "hello";
        System.out.println(solution(s)); //h

        s = "swiss";
        System.out.println(solution(s)); //w
    }

}
