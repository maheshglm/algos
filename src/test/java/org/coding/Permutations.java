package org.coding;

import com.google.common.base.Strings;
import org.LinkedList;
import org.junit.Test;

import java.util.*;

public class Permutations {


    //better understandable especially the flow of recursion
    public static void permute(String full) {
        if (Strings.isNullOrEmpty(full)) {
            System.out.println("You need to provide string having length > 0.");
            return;
        }
        permute(full, "");
    }

    public static void permute(String remaining, String prefix) {
        if (remaining.length() == 0) {
            System.out.println(prefix);
        }

        for (int i = 0; i < remaining.length(); i++) {
            String p = prefix + remaining.charAt(i);
            String r = remaining.substring(0, i) + remaining.substring(i + 1);
            permute(r, p);
        }
    }

    /*
    below solution works in case of duplicates in String
    so, we no need to print duplicate permutations.
     */
    private void solution(String s) {
        if (Strings.isNullOrEmpty(s)) {
            System.out.println("cannot generate");
            return;
        }

        Set<String> result = new HashSet<>();
        dfs(s, result, "");
        System.out.println(result);
    }

    private void dfs(String remaining, Set<String> result, String prefix) {
        if (remaining.length() == 0) {
            result.add(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String p = prefix + remaining.charAt(i);
            String r = remaining.substring(0, i) + remaining.substring(i + 1);
            dfs(r, result, p);
        }
    }


    //https://leetcode.com/problems/permutations/
    //https://www.youtube.com/watch?v=s7AvT7cGdSo
    private List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int num : nums) {
            if (temp.contains(num)) continue;
            temp.add(num);
            backtracking(nums, result, temp);
            temp.remove(temp.size() - 1);
        }

    }

    /*
    num = 1
    temp <- [1]
        ------> num = 1
                num = 2
                temp <- [1, 2]
                        -------> num = 1
                                 num = 2
                                 num = 3
                                 temp <- [1, 2, 3] - add [1,2,3] return;
                                 temp <- [1, 2]
                temp <- [1]
                num = 3
                temp <- [1,3]
                            ----> num = 1
                                  num = 2
                                  temp <- [1, 3, 2] - add [1, 3, 2] return
                                  temp <- [1, 3]
                temp <- [1]
      temp[]
      num = 2
      temp[2]




     */


    @Test
    public void test1() {
        String s = "ABC";
        //permute(s);
        solution(s);
        /*
            String s1 = "test";
            s1.length();
            String[] sl = {"s1", "s2"};
            System.out.println(sl.length);

            List<String> sll = new ArrayList<>(Arrays.asList(sl));
            System.out.println(sll.size());
         */

    }

    @Test
    public void test2() {
        String s = "ABCD";
        //permute(s);
        solution(s);
    }

    @Test
    public void test3() {
        String s = "ABCB";
        permute(s);
        solution(s);
    }


    @Test
    public void test4() {
        int[] nums = {1, 2, 3};
        System.out.println(solution1(nums));
    }
}
