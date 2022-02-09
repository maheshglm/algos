package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/discuss/interview-experience/535848/Indeed-Telephonic-or-Senior-SDE-or-Hyderabad-or-March-2020-or-Passed-but-position-closed
public class Karat14 {

    //Simple version of Karat13
    //instead of hard limit, this problem is abt soft limit
    //no need to append extra spaces to make it line len as asked.
    private List<String> solution(String[] words, int width) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;
        while (i < n) {
            int j = i + 1;
            int lineLen = words[i].length();
            while (j < n && lineLen + words[j].length() + (j - i - 1) < width) {
                lineLen += words[j].length();
                j++;
            }
            result.add(justify(words, i, j));
            i = j;
        }
        return result;
    }

    private String justify(String[] words, int i, int j) {
        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; k++) {
            sb.append("-");
            sb.append(words[k]);
        }
        return sb.toString();
    }


    @Test
    public void test1() {
        String[] words = {"It", "is", "an", "easy", "and", "cool", "question"};
        int maxWidth = 10;
        System.out.println(solution(words, maxWidth));

        /*
        It is an
        easy and
        cool
        question
         */
    }

    @Test
    public void test2() {
        String[] words = {"It", "is", "a", "calm", "and", "quiet", "day"};
        int maxWidth = 10;
        System.out.println(solution(words, maxWidth));

        /*
        It is a
        calm and
        quiet day
         */
    }


    @Test
    public void test3() {
        String[] words = {"It", "is", "an", "easy", "and", "cool", "question"};
        int maxWidth = 15;
        System.out.println(solution(words, maxWidth));
        /*
        It is an easy
        and cool
        question
         */

    }

}
