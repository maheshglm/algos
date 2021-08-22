package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
//https://leetcode.com/problems/palindrome-partitioning/
//https://www.youtube.com/watch?v=3jvWodd7ht0
public class PalindromePartitioning {

    /*
    Given a string s, partition s such that every substring of the partition is a palindrome.
    Return all possible palindrome partitioning of s.

    A palindrome string is a string that reads the same backward as forward.
     */

    public List<List<String>> solution(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s == null) return result;
        dfs(s, result, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(String s, List<List<String>> result, List<String> temp, int index) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                temp.add(s.substring(index, i + 1));
                dfs(s, result, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        String s = "aac";
        System.out.println(solution(s));
        //[[a, a, c], [aa, c]]
    }

    @Test
    public void test2() {
        String s = "";
        System.out.println(solution(s));
        //[[]]
    }

    @Test
    public void test3() {
        String s = "a";
        System.out.println(solution(s));
        //[[a]]
    }

    @Test
    public void test4() {
        String s = "aaa";
        System.out.println(solution(s));
        //[[a, a, a], [a, aa], [aa, a], [aaa]]
    }

    @Test
    public void test5() {
        String s = null;
        System.out.println(solution(s));
        //[]
    }

    @Test
    public void test6(){
        String s = "Banana";
        System.out.println(solution(s));

    }


}
