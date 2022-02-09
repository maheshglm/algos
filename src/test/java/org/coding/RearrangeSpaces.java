package org.coding;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/rearrange-spaces-between-words/
public class RearrangeSpaces {

    private String solution(String text) {
        int spaceCount = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }

        if (spaceCount == 0) return text;

        String[] words = text.trim().split("\\W+");
        int wordCount = words.length;

        int gap = words.length == 1 ? 0 : spaceCount / (wordCount - 1);

        StringBuilder gapWord = new StringBuilder();
        for (int i = 0; i < gap; i++) {
            gapWord.append(" ");
        }

        int trailingSpaces = spaceCount - gap * (wordCount - 1);

        StringBuilder trailingWord = new StringBuilder();
        for (int i = 0; i < trailingSpaces; i++) {
            trailingWord.append(" ");
        }

        StringBuilder result = new StringBuilder();
        int cnt = 0;
        for (String s : words) {
            result.append(s);
            cnt++;
            if (cnt < words.length) {
                result.append(gapWord);
            }
        }
        return result.toString() + trailingWord;
    }


    private String solution1(String text) {
        int totalSpaces = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                totalSpaces++;
            }
        }

        String[] words = text.trim().split("\\W+");
        int totalWords = words.length;

        if (totalSpaces == 0 && totalWords == 1) return text;

        int countBetweenEach = totalWords == 1 ? 0 : totalSpaces / (totalWords - 1);
        int remainingSpaces = totalWords == 1 ? totalSpaces : totalSpaces % (totalWords - 1);

        StringBuilder sb = new StringBuilder();
        String space = " ".repeat(countBetweenEach);
        String trailingSpace = " ".repeat(remainingSpaces);

        for (int i = 0; i < totalWords; i++) {
            sb.append(words[i]);
            if (i < totalWords - 1) {
                sb.append(space);
            }
        }
        return sb.append(trailingSpace).toString();
    }

    @Test
    public void test1() {
        String text = "  this   is  a sentence ";
        System.out.println(solution(text));
        System.out.println(solution1(text));
        //output: this   is   a   sentence
        /*
        Explanation: There are a total of 9 spaces and 4 words.
        We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
         */
    }

    @Test
    public void test2() {
        Assert.assertEquals("this", solution1("this"));
        Assert.assertEquals("this  ", solution1("  this"));

    }

}
