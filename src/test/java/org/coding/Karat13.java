package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/discuss/interview-experience/535848/Indeed-Telephonic-or-Senior-SDE-or-Hyderabad-or-March-2020-or-Passed-but-position-closed
public class Karat13 {

    /*
    Question 1 : Word wrapping.
    List wrapWords(String[] words, int lineLimit)

    Sample example1:
    words = {"It”, "is”, "a”, "calm”, "and”, "quiet”, "day”}
    lineLimit = 10

    Output=
    It-is-a
    calm-and
    quiet-day

    Spaces to be replaced with – for readability
     */

    private List<String> solution(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            int j = i + 1;
            int lineLen = words[i].length();
            while (j < n && lineLen + words[j].length() + (j - i - 1) < maxWidth) {
                lineLen += words[j].length();
                j++;
            }

            int diff = maxWidth - lineLen;
            int numberOfWords = j - i;

            if (numberOfWords == 1 || j >= n) {
                leftJustify(words, diff, i, j, result);
            } else {
                middleJustify(words, diff, i, j, result);
            }
            i = j;
        }
        return result;
    }

    public void leftJustify(String[] words, int diff, int i, int j, List<String> result) {
        int rightSpaces = diff - (j - i - 1);

        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; k++) {
            sb.append("-");
            sb.append(words[k]);
        }
        sb.append("-".repeat(rightSpaces));
        result.add(sb.toString());
    }


    public void middleJustify(String[] words, int diff, int i, int j, List<String> result) {
        int spaces = diff / (j - i - 1);
        int extraSpaces = diff - spaces; //diff % (j-i-1)

        String space = "-".repeat(spaces);

        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; k++) {
            sb.append(space);
            if (extraSpaces-- > 0) {
                sb.append("-");
            }
            sb.append(words[k]);
        }
        result.add(sb.toString());
    }


    @Test
    public void test1() {
        String[] words = {"It", "is", "an", "easy", "and", "cool", "question"};
        int maxWidth = 10;
        System.out.println(solution(words, maxWidth));

        /*
        It--is--an
        easy---and
        cool------
        question--
         */
    }

    @Test
    public void test2() {
        String[] words = {"It", "is", "a", "calm", "and", "quiet", "day"};
        int maxWidth = 10;
        System.out.println(solution(words, maxWidth));

        /*
        It---is--a
        calm---and
        quiet-day-
         */
    }


    @Test
    public void test3() {
        String[] words = {"It", "is", "an", "easy", "and", "cool", "question"};
        int maxWidth = 15;
        System.out.println(solution(words, maxWidth));
        /*
        It--is--an-easy
        and--------cool
        question-------
         */

    }
}
