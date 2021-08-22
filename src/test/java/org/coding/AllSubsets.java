package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=LdtQAYdYLcE
//https://www.youtube.com/watch?v=bGC2fNALbNU
//https://www.youtube.com/watch?v=CfqNrA6Jf_I&list=PL5b07qlmA3P6UWAVm6rnJXpWAB3Vnj59B&index=114
//https://www.youtube.com/watch?v=u0e29JIdxZU
public class AllSubsets {

    //https://leetcode.com/problems/subsets/solution/
    //result can be passed in backtracking functions as 4th argument
    //but added as a global variable just to limit the number of args to backtracking
    private List<List<Character>> result = new ArrayList<>();

    //for each element we have 2 choices, either we include element or don't include.
    //
    /*
            Recursion Tree
                         []
               1 /                \
               [1]                []
             2/    \             /     \
         [1, 2]     [1]         [2]     []
        3 /  \      /   \       /  \     | \
    [1,2,3] [1,2] [1, 3] [1]  [2, 3] [2] [] [3]
     */

    //using recursion
    private List<List<Character>> solution(char[] nums) {
        if (nums == null || nums.length == 0) return result;
        generateSubsets(nums, 0, new ArrayList<>());
        return result;
    }

    public void generateSubsets(char[] nums, int index, List<Character> subset) {
        //since subsets contains an empty set, at first we need to add this
        result.add(new ArrayList<>(subset));//deep copy
        for (int i = index; i < nums.length; i++) {
            //include element
            subset.add(nums[i]);
            generateSubsets(nums, i + 1, subset);
            //not to include the element
            subset.remove(subset.size() - 1);
        }
    }

    //O(N * 2^N) - time
    //
    //Using iteration
    public List<List<Character>> solution1(char[] nums) {
        List<List<Character>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        List<Character> tempList;
        List<Character> newList;

        result.add(new ArrayList<>());

        //it follows cascading process
        //like:
        // []        0   1
        // [] [] --> [] [A]
        // [] [A] --> [] [A] [B] [AB]
        // [] [A] [B] [AB] --> [] [A] [B] [AB] [C] [AC] [BC] [ABC]
        for (char n : nums) {
            int resultSize = result.size();
            for (int i = 0; i < resultSize; i++) {
                //take list from last ith index
                tempList = result.get(i);
                //add the temp list back to result as deep copy
                result.add(new ArrayList<>(tempList));

                //take newly added list
                newList = result.get(result.size() - 1);
                //add n for each list
                newList.add(n);
            }
        }
        return result;
    }


    @Test
    public void test1() {
        char[] nums = {'A', 'B', 'C'};
        System.out.println(solution(nums));
        //[[], [A], [A, B], [A, B, C], [A, C], [B], [B, C], [C]]
        System.out.println(solution1(nums));
        //[[], [A], [B], [A, B], [C], [A, C], [B, C], [A, B, C]]
    }


}
