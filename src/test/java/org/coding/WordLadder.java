package org.coding;

import org.junit.Test;

import java.util.*;

//https://www.youtube.com/watch?v=PeyYhb8lJJU
//https://www.youtube.com/watch?v=M9cVl4d0v04
public class WordLadder {

    //IN PROGRESS
    private int solution1(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> dict = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < beginWord.length(); i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> transformations = dict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                dict.put(newWord, transformations);
            }
        });
        return 1;
    }

    private int solution(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String currWord = q.poll();
                if (endWord.equals(currWord))
                    return level + 1;

                char[] newWord = currWord.toCharArray();

                for (int j = 0; j < newWord.length; j++) {
                    char temp = newWord[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        newWord[j] = ch;
                        String s = String.valueOf(newWord);
                        if (set.contains(s)) {
                            q.offer(s);
                            set.remove(s);
                        }
                    }
                    newWord[j] = temp;
                }
            }
            level++;
        }
        return 0;
    }

    @Test
    public void test1() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(solution(beginWord, endWord, wordList));
        System.out.println(solution1(beginWord, endWord, wordList));
        //Output 5
        /*
        Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog",
        which is 5 words long.
         */
    }

    @Test
    public void test2() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
        //Output 0
        /*
        Explanation: The endWord "cog" is not in wordList,
        therefore there is no valid transformation sequence
        */

    }

    @Test
    public void test3() {
        String beginWord = "a";
        String endWord = "c";
        List<String> wordList = Arrays.asList("a", "b", "c");
        System.out.println(solution(beginWord, endWord, wordList));
        //Output 2


    }

}
