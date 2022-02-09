package org.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-string-chain/
//https://www.youtube.com/watch?v=zqe_zIkyVGQ
public class LongestStringChain {

    //Sort the words by word's length. (also can apply bucket sort)
    //For each word, loop on all possible previous word with 1 letter missing.
    //If we have seen this previous word, update the longest chain for the current word.
    //Finally return the longest word chain.

    //Time O(NlogN) for sorting,
    //Time O(NSS) for the for loop, where the second S refers to the string generation and S <= 16.
    //Space O(NS)

    //Time - O(NLongN + N * L * L)
    //space - O(N) for map
    private int solution(String[] words) {
        int result = 0;

        //O(NLogN) for sorting - N words
        //Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        Arrays.sort(words, Comparator.comparingInt(String::length));

        Map<String, Integer> memo = new HashMap<>();

        //N words
        for (String word : words) {
            memo.put(word, 1);
            //L length of word
            for (int i = 0; i < word.length(); i++) {
                StringBuilder current = new StringBuilder(word);
                //Time - L length of word for delete char
                final String nextWord = current.deleteCharAt(i).toString();
                if (memo.containsKey(nextWord)) {
                    memo.put(word, memo.get(nextWord) + 1);
                }
            }
            result = Math.max(result, memo.get(word));
        }
        return result;
    }


    @Test
    public void test1() {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println(solution(words));
        //Output: 4
        //Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
    }

    @Test
    public void test2() {
        String[] words = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        System.out.println(solution(words));
        //Output: 5
        //Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"]

    }

    @Test
    public void test3() {
        String[] words = {"abcd", "dbqca"};
        System.out.println(solution(words));
        //Output: 1
        //Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
        //["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed
    }

}
