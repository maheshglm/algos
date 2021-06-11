package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=LdtQAYdYLcE
//https://www.youtube.com/watch?v=bGC2fNALbNU
//https://www.youtube.com/watch?v=CfqNrA6Jf_I&list=PL5b07qlmA3P6UWAVm6rnJXpWAB3Vnj59B&index=114
public class AllSubsets {

    private List<List<Character>> solution(char[] nums) {
        List<List<Character>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    public void generateSubsets(int index, char[] nums, List<Character> subset, List<List<Character>> result) {
        result.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            generateSubsets(i + 1, nums, subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    //Using iteration
    public List<List<Character>> solution1(char[] nums) {

        List<List<Character>> result = new ArrayList();

        if (nums == null || nums.length == 0) return result;

        List<Character> tempList;
        List<Character> newList;

        result.add(new ArrayList());
        for (char n : nums) {
            int resultSize = result.size();
            for (int j = 0; j < resultSize; j++) {
                tempList = new ArrayList(result.get(j));
                result.add(tempList);
                newList = result.get(result.size() - 1);
                newList.add(n);
            }
        }
        return result;
    }


    @Test
    public void test1() {
        char[] nums = {'A', 'B', 'C'};
        System.out.println(solution(nums));
        System.out.println(solution1(nums));
    }


}
