package org.coding;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/problems/text-justification/
//https://www.youtube.com/watch?v=GqXlEbFVTXY&t=66s
public class TextJustification {

    private List<String> solution1(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int i = 0;
        int n = words.length;

        while (i < n) {
            int j = i + 1;
            int lineLen = words[i].length();
            //j - i - 1 -- no. of sections that we are going to apply spaces
            //like j = 3, i = 0. i.e. 3 words and 2 sections (3-0-1)
            while (j < n && lineLen + words[j].length() + (j - i - 1) < maxWidth) {
                lineLen += words[j].length();
                j++;
            }

            int diffSpaces = maxWidth - lineLen;
            int numberOfWords = j - i;

            if (numberOfWords == 1 || j >= n) {
                leftJustify(words, diffSpaces, i, j, result);
            } else {
                middleJustify(words, diffSpaces, i, j, result);
            }
            i = j;
        }
        return result;
    }

    private void leftJustify(String[] words, int diff, int i, int j, List<String> result) {
        int spacesRight = diff - (j - i - 1);

        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; k++) {
            sb.append(" ").append(words[k]);
        }

        sb.append(" ".repeat(spacesRight));

        result.add(sb.toString());
    }

    private void middleJustify(String[] words, int diff, int i, int j, List<String> result) {
        int spaces = diff / (j - i - 1);
        int extraSpaces = diff % (j - i - 1);

        String space = " ".repeat(spaces);

        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; k++) {
            sb.append(space);
            if (extraSpaces-- > 0) {
                sb.append(" ");
            }
            sb.append(words[k]);
        }
        result.add(sb.toString());
    }


    //This solution is not 100% correct only for middle justify
    private List<String> solution(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < words.length) {
            List<String> temp = new ArrayList<>();
            int len = words[i].length() + 1;
            temp.add(words[i]);
            while (len <= maxWidth && j < words.length - 1) {
                len += words[j + 1].length() + 1;
                if (len <= maxWidth) {
                    temp.add(words[j + 1]);
                    j++;
                }
            }

            if (temp.size() == 1 || j == words.length - 1) {
                leftJustify(temp.toArray(new String[1]), maxWidth, result);
            } else {
                middleJustify(temp.toArray(new String[1]), maxWidth, result);
            }
            i = j + 1;
            j = i;
        }
        return result;
    }

    private void leftJustify(String[] words, int maxWidth, List<String> result) {
        int totalLen = 0;
        for (String w : words) {
            totalLen += w.length();
        }
        int diff = maxWidth - totalLen;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) {
                sb.append(" ");
                diff--;
            }
        }

        String spaceAtEnd = " ".repeat(diff);
        sb.append(spaceAtEnd);
        result.add(sb.toString());
    }

    private void middleJustify(String[] words, int maxWidth, List<String> result) {
        int totalLen = 0;
        for (String w : words) {
            totalLen += w.length();
        }
        int diff = maxWidth - totalLen;
        int spaceEach = diff / (words.length - 1);
        int additionalSpace = diff % (words.length - 1);

        String gapEach = " ".repeat(spaceEach);
        String additionalGap = " ".repeat(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) {
                sb.append(gapEach);
                if (additionalSpace > 0) {
                    sb.append(additionalGap);
                    additionalSpace--;
                }
            }
        }
        result.add(sb.toString());
    }


    @Test
    public void test1() {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        System.out.println(solution(words, maxWidth));
        System.out.println(solution1(words, maxWidth));

        /*
            Output:
            [
               "This    is    an",
               "example  of text",
               "justification.  "
            ]
        */
    }

    @Test
    public void test2() {
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;
        System.out.println(solution(words, maxWidth));
        System.out.println(solution1(words, maxWidth));
        /*
            Output:
            [
              "What   must   be",
              "acknowledgment  ",
              "shall be        "
            ]
            Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
            Note that the second line is also left-justified becase it contains only one word.
         */
    }


    @Test
    public void test3() {
        String[] words = {"Science", "is", "what", "we", "understand", "well", "enough",
                "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth = 20;
        System.out.println(solution(words, maxWidth));
        System.out.println(solution1(words, maxWidth));
        /*
        Output:
            [
              "Science  is  what we",
              "understand      well",
              "enough to explain to",
              "a  computer.  Art is",
              "everything  else  we",
              "do                  "
            ]
        */
    }

}
