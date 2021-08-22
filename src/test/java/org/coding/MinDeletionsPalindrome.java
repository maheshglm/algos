package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/valid-palindrome-ii/
public class MinDeletionsPalindrome {

    //Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

    private boolean solution(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return helper(s, i + 1, j) || helper(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean helper(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    @Test
    public void test1() {
        String s = "aba";
        //output = true
        System.out.println(solution(s));
    }

    @Test
    public void test2() {
        String s = "abca";
        //output = true by deleting c char
        System.out.println(solution(s));
    }

    @Test
    public void test4() {
        String s = "raceacar";
        //output = true by deleting a char
        System.out.println(solution(s));
    }

    @Test
    public void test3() {
        String s = "tebbem";
        //output = false
        System.out.println(solution(s));
    }
}
