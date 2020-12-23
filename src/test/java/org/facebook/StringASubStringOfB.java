package org.facebook;

import org.junit.Test;

//https://algorithms.tutorialhorizon.com/minimum-number-of-times-string-a-is-repeated-to-such-that-b-is-substring-of-a/
public class StringASubStringOfB {

    private int solution(String s1, String s2) {
        StringBuilder repeatedS1 = new StringBuilder(s1);
        int count = 0;
        int minTimesLoop = s2.length() / s1.length();
        int loopCounter = 0;

        while (loopCounter < minTimesLoop) {
            repeatedS1.append(s1);
            count++;

            if (repeatedS1.toString().contains(s2)) {
                return count;
            }
            loopCounter++;
        }
        return -1;
    }

    @Test
    public void test1() {
        String s1 = "abcd";
        String s2 = "cdabcdab";
        System.out.println(solution(s1, s2));//Output 2
    }

    @Test
    public void test2() {
        String s1 = "abcde";
        String s2 = "cdeabcdeabf";
        System.out.println(solution(s1, s2)); //Output -1
    }
}
