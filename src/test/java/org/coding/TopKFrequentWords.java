package org.coding;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-elements/solution/
//https://leetcode.com/problems/top-k-frequent-words/solution/
//https://www.youtube.com/watch?v=cupg2TGIkyM&t=30s
public class TopKFrequentWords {

    /*Time Complexity: O(Nlogk), where N is the length of words.
    We count the frequency of each word in O(N) time,
    then we add N words to the heap, each in O(logk) time.
    Finally, we pop from the heap up to k times.
    As k < N, this is O(Nlogk) in total*/
    //space O(N)
    private List<String> solution(List<String> words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        //sort the strings by less frequencies (as we are polling excess words and add remaining)
        //if frequencies same, then
        Queue<String> pq = new PriorityQueue<>((word1, word2) -> {
            int frequency1 = map.get(word1);
            int frequency2 = map.get(word2);
            //greater alphabetical order comes first
            if (frequency1 == frequency2) return word2.compareTo(word1);
            //lesser frequencies
            return frequency1 - frequency2;
        });

        //No need to all elements into heap
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry.getKey());
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.reverse(result);

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
