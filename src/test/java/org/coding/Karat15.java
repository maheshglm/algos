package org.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/discuss/interview-question/992306/indeed-karat-phone-screen-find-embedded-words-i-ii
public class Karat15 {

    /*
        You are running a classroom and suspect that some of your students are passing around
        the answers to multiple choice questions disguised as random strings.
        Your task is to write a function that, given a list of words and a string,
        finds and returns the word in the list that is scrambled up inside the string, if any exists.
        There will be at most one matching word. The letters don't need to be contiguous.
     */

    private String solution(String s, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (String word : words) {
            Map<Character, Integer> copyMap = new HashMap<>(map);
            int matchCount = 0;
            for (char c : word.toCharArray()) {
                if (!copyMap.containsKey(c) || copyMap.get(c) <= 0) {
                    break;
                } else {
                    matchCount++;
                    copyMap.put(c, map.get(c) - 1);
                }
            }
            if (matchCount == word.length()) {
                return word;
            }
        }

        return "None";
    }

    @Test
    public void test1() {
        String[] words = {"cat", "baby", "dog", "bird", "car", "ax"};
        String s = "tcabnihjs";
        System.out.println(solution(s, words));
        //cat
    }

    @Test
    public void test2() {
        String[] words = {"cat", "baby", "dog", "bird", "car", "ax"};
        String s = "tbcanihjs";
        System.out.println(solution(s, words));
        //cat
    }

    @Test
    public void test3() {
        String[] words = {"cat", "baby", "dog", "bird", "car", "ax"};
        String s = "baykkjl";
        System.out.println(solution(s, words));
        //None
    }

    @Test
    public void test4() {
        String[] words = {"cat", "baby", "dog", "bird", "car", "ax"};
        String s = "bbabylkkj";
        System.out.println(solution(s, words));
        //baby
    }

    @Test
    public void test5() {
        String[] words = {"cat", "baby", "dog", "bird", "car", "ax"};
        String s = "ccc";
        System.out.println(solution(s, words));
        //None
    }

    @Test
    public void test6() {
        String[] words = {"cat", "baby", "dog", "bird", "car", "ax"};
        String s = "nbird";
        System.out.println(solution(s, words));
        //bird
    }
}
