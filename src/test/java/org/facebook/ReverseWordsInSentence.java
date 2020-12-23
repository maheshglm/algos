package org.facebook;

import org.junit.Test;

import java.util.regex.Pattern;

public class ReverseWordsInSentence {

    private String solution(String s) {
        String[] words = s.split("\\W+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }

    @Test
    public void test1() {
        String s = "Java is Great";
        System.out.println(solution(s)); //Great is Java
    }

    @Test
    public void test2() {
        String s = "Great is Java";
        System.out.println(solution(s)); //Java is Great
    }

    @Test
    public void test3() {
        String s = "-123e4";
        System.out.println(Double.parseDouble(s));

        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?('e')?([-+])?(\\d+)");


    }
}
