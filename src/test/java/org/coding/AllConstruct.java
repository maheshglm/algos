package org.coding;

import org.junit.Test;

import java.util.*;

//https://www.youtube.com/watch?v=oBt53YbR9Kk&t=2328s
//https://www.youtube.com/watch?v=oBt53YbR9Kk&t=10050s
public class AllConstruct {

    /*
       Function should return 2D array of all the ways the 'target'
       can be constructed by concatenating elements of the 'wordBank' array
       Reuse elements is allowed.
       Hint: for empty target string answer is true as with no words we can make empty target
    */

    //
    //base condition is empty list of list
    //M length of target string N number of words
    //height of trees is M
    //O(N ^ M) different combinations
    //space O(M) - height of recursion tree
    public List<List<String>> solution(String target, String[] wordBank) {

        if ("".equals(target))
            return Arrays.asList(new ArrayList<>());

        List<List<String>> result = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String remaining = target.substring(word.length());
                List<List<String>> suffixWays = solution(remaining, wordBank);
                //adding each word from suffix ways to existing list
                //below will execute at the end of word tree
                //i.e. p -> ur -> p -> le (last)
                //since the base condition is returning [[]] array
                //below loop will add the word which has caused the full string match
                //[[purp, le], [p, ur, p, le]]
                //0 index is because while adding the word back to existing list, we must add at 0
                //ex: now [[le]] -> along with 'purp' will return to parent word 'purple'
                //to make list readable we are adding at 0 index [ [purp, le ]]
                //otherwise the list would be [ le, purp ]
                for (List<String> list : suffixWays) {
                    list.add(0, word);
                }
                result.addAll(suffixWays);
            }
        }
        return result;
    }

    public List<List<String>> solution2(String target, String[] wordBank, Map<String, List<List<String>>> memo) {
        if ("".equals(target))
            return Arrays.asList(new ArrayList<>());

        //if (memo.containsKey(target)) return memo.get(target);

        List<List<String>> result = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String remaining = target.substring(word.length());
                List<List<String>> suffixWays = solution2(remaining, wordBank, memo);
                //adding each word from suffix ways to existing list
                //below will execute at the end of word tree
                //i.e. p -> ur -> p -> le (last)
                //since the base condition is returning [[]] array
                //below loop will add the word which has caused the full string match
                //[[purp, le], [p, ur, p, le]]
                //0 index is because while adding the word back to existing list, we must add at 0
                //ex: now [[le]] -> along with 'purp' will return to parent word 'purple'
                //to make list readable we are adding at 0 index [ [purp, le ]]
                //otherwise the list would be [ le, purp ]
                for (List<String> list : suffixWays) {
                    list.add(0, word);
                }
                result.addAll(suffixWays);
            }
        }
        //memo.put(target, new ArrayList<>(result));
        return result;
    }

    @Test
    public void test1() {
        String target = "purple";
        String[] wordBank = {"purp", "p", "ur", "le", "purpl"};
        System.out.println(solution(target, wordBank));
        //[[purp, le], [p, ur, p, le]]
    }

    @Test
    public void test2() {
        String target = "purple";
        String[] wordBank = {"purp", "p", "ur", "le", "purpl"};

        Map<String, List<List<String>>> memo = new HashMap<>();

        System.out.println(solution2(target, wordBank, memo));
        //[[purp, le], [p, ur, p, le]]
    }

}
