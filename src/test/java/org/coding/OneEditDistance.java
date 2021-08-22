package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/one-edit-distance/solution/
public class OneEditDistance {

    /*
    Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.
    A string s is said to be one distance apart from a string t if you can:

    Insert exactly one character into s to get t.
    Delete exactly one character from s to get t.
    Replace exactly one character of s with a different character to get t.
     */

    //https://leetcode.com/problems/one-edit-distance/discuss/50098/My-CLEAR-JAVA-solution-with-explanation
    /*
     * There're 3 possibilities to satisfy one edit distance apart:
     *
     * 1) Replace 1 char:
          s: a B c
          t: a D c
     * 2) Delete 1 char from s:
          s: a D  b c
          t: a    b c
     * 3) Delete 1 char from t
          s: a   b c
          t: a D b c
     */
    private boolean solution(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        //// Ensure that s is shorter than t.
        if (lenS > lenT) {
            //inverse and return the result
            return solution(t, s);
        }

        //both strings has to be 1 char away
        //if both are differ by lets say 2 chars, we cannot get true
        if (lenT - lenS > 1) return false;

        for (int i = 0; i < lenS; i++) {
            if (s.charAt(i) != s.charAt(i)) {
                if (lenS == lenT) {
                    //abxcd
                    //abycd
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    //abcd
                    //abycd
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }

        // If there is no diffs on ns distance
        // the strings are one edit away only if
        // t has one more character.
        // strings are 1 away distance ("ab" "abc")
        return lenS + 1 == lenT;
    }


    @Test
    public void test1() {
        String s = "ab";
        String t = "acb";
        System.out.println(solution(s, t));
        //true
        //Explanation: We can insert 'c' into s to get t.
    }

    @Test
    public void test2() {
        String s = "";
        String t = "";
        System.out.println(solution(s, t));
        //false
        //Explanation: We cannot get t from s by only one step.

    }

    @Test
    public void test3() {
        String s = "a";
        String t = "";
        System.out.println(solution(s, t));
        //true
    }

    @Test
    public void test4() {
        String s = "";
        String t = "A";
        System.out.println(solution(s, t));
        //true
    }

    @Test
    public void test5() {
        String s = "abc";
        String t = "acb";
        System.out.println(solution(s, t));
        //true
    }


}
