package org.facebook;

import org.junit.Test;

import java.util.Random;

//https://algorithms.tutorialhorizon.com/get-a-random-character-from-the-given-string-java-program/
public class RandomChar {

    private Character solution(String s) {

        if (s == null) {
            throw new IllegalArgumentException("Please pass valid string");
        }

        char c = s.charAt(new Random().nextInt(s.length()));
        while (c == ' ' || c == '\0') {
            c = s.charAt(new Random().nextInt(s.length()));
        }
        return c;

    }

    @Test
    public void test1() {
        String s = "algorithms @ tutorial horizon";
        System.out.println(solution(s));
        System.out.println(solution(s));
        System.out.println(solution(s));
        System.out.println(solution(s));
        System.out.println(solution(s));
        System.out.println(solution(s));
        System.out.println(solution(s));
    }

    @Test
    public void test2() {
        String s = "abcd";
        System.out.println(solution(s));
        System.out.println(solution(s));
        System.out.println(solution(s));
        System.out.println(solution(s));
        System.out.println(solution(s));
        System.out.println(solution(s));
    }
}
