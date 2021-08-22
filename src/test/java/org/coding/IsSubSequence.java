package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/is-subsequence/
public class IsSubSequence {

    private boolean solution(String s, String t) {
        if (s.length() == 0) return true;
        int i = 0;
        int j = 0;
        while (i < t.length()) {
            if (j < s.length() && t.charAt(i) == s.charAt(j)) {
                j++;
            }
            i++;
        }
        //if j overshoted means all characters are matched
        return j == s.length();
    }

    @Test
    public void test1() {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(solution(s, t)); //true
    }

    @Test
    public void test2() {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(solution(s, t)); //false
    }

}
