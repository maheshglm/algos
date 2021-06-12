package org.coding;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-elements/solution/
//https://leetcode.com/problems/top-k-frequent-words/solution/
//https://www.youtube.com/watch?v=cupg2TGIkyM&t=30s
public class TopKFrequentWords {

    /*Time Complexity: O(N log{k})O(Nlogk), where NN is the length of words.
    We count the frequency of each word in O(N)O(N) time, then we add NN words to the heap,
    each in O(log {k})O(logk) time.
    Finally, we pop from the heap up to kk times.
    As k \leq Nk≤N, this is O(N \log{k})O(Nlogk) in total*/
    private List<String> solution(List<String> words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Queue<String> pq = new PriorityQueue<>((word1, word2) -> {
            int frequency1 = map.get(word1);
            int frequency2 = map.get(word2);
            if (frequency1 == frequency2) return word1.compareTo(word2);
            return frequency2 - frequency1;
        });

        List<String> result = new ArrayList<>();

        for(String s : map.keySet()){
            pq.add(s);
        }

        while (k-- > 0) {
            result.add(pq.poll());
        }
        return result;
    }

    @Test
    public void test1() {
        List<String> input = Arrays.asList("i", "love", "leetcode", "i", "love", "coding");
        int k = 2;
        List<String> output = Arrays.asList("i", "love");
        System.out.println(solution(input, k));
    }

    @Test
    public void test2() {
        List<String> input = Arrays.asList("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is");
        int k = 4;
        List<String> output = Arrays.asList("the", "is", "sunny", "day");
        System.out.println(solution(input, k));
    }

}
