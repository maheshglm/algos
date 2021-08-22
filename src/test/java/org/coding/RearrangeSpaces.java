package org.coding;

import com.google.common.base.Strings;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/rearrange-spaces-between-words/
public class RearrangeSpaces {

    private String solution(String text) {
        int spaceCount = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') spaceCount++;
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


    @Test
    public void test1() {
        String text = "  this   is  a sentence ";
        System.out.println(solution(text));
        //output: this   is   a   sentence
        /*
        Explanation: There are a total of 9 spaces and 4 words.
        We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
         */
    }

}
