package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://www.youtube.com/watch?v=Vch3pFgmKD8
//https://leetcode.com/problems/number-of-matching-subsequences/
public class MatchingSubsequences {

    class Item {
        String word;
        int index;

        public Item(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }

    private int solution1(String s, String[] words) {
        Queue<Item>[] dict = new Queue[26];

        for (int i = 0; i < dict.length; i++) {
            dict[i] = new LinkedList<>();
        }

        for (String word : words) {
            if (word.length() > 0) {
                dict[word.charAt(0) - 'a'].add(new Item(word, 0));
            }
        }

        int count = 0;
        for (char c : s.toCharArray()) {
            Queue<Item> q = dict[c - 'a'];
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Item top = q.poll();
                top.index++;
                if (top.index == top.word.length()) {
                    count++;
                } else {
                    dict[top.word.charAt(top.index) - 'a'].add(top);
                }
            }
        }
        return count;


    }

    private int solution(String s, String[] words) {
        if (s.length() == 0) return 0;
        int count = 0;

        Map<Character, Queue<String>> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.putIfAbsent(c, new LinkedList<>());
        }

        for (String word : words) {
            char startChar = word.charAt(0);
            if (map.containsKey(startChar)) {
                map.get(startChar).offer(word);
            }
        }

        for (char c : s.toCharArray()) {
            Queue<String> list = map.get(c);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String remainingWord = list.poll().substring(1);
                if (remainingWord.length() == 0) {
                    count++;
                } else {
                    char startChar = remainingWord.charAt(0);
                    if (map.containsKey(startChar)) {
                        map.get(startChar).offer(remainingWord);
                    }
                }
            }
        }
        return count;
    }

    @Test
    public void test1() {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(solution(s, words));
        System.out.println(solution1(s, words));
        //output 3
        /*
        Explanation:
        There are three strings in words that are a subsequence of s: "a", "acd", "ace".
         */
    }

    @Test
    public void test2() {
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        System.out.println(solution(s, words));
        System.out.println(solution1(s, words));
        //output 2
        /*
        Explanation:
        There are three strings in words that are a subsequence of s: "a", "acd", "ace".
         */
    }

}
