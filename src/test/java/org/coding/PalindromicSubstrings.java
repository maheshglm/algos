package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/palindromic-substrings/
//https://www.youtube.com/watch?v=4RACzI5-du8
public class PalindromicSubstrings {

    //calculating substrings - concept is odd and even
    //odd number palindrome from each char we go left and right with 2 pointers and check if left and right are same
    //even number palindrome from each 2 char we go left and right with 2 pointers and check if left and right are same

    //O(N^2)
    private int solution(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;

            //this checks odd number of palindromes like
            //when i = 0, left = 0, right = 0, String s = "aaab"
            //a == a, palindrome add result++, left-- causes goes outbound we skip it
            //when i = 1,
            //left = 1, right = 1
            //s[1] == s[1] => a == a, palindrome add result++, left-- causes goes outbound we break the loop
            //left-- and right++ => left = 0 and right = 2
            //s[0] == s[2] => a == a => result++;
            //left-- and right++ => left = -1 and right = 3, goes outbound, we break the loop
            //when i = 2
            //left = right = 2
            //s[2] == s[2] => result++, left-- and right++
            //left = 1 and right 3
            //s[1] == s[3] => left-- and right++, goes outbound, we break the loop
            //when i = 3
            //left = right = 3
            //s[3] = s[3] = result++;
            result += countPalindromes(s, left, right);

            //This loop calculated palindromes of even length
            //when i = 0, left = 0, right = 1
            //s[0] == s[1], true, result++, left-- and right++, goes outbound, we break the loop
            //when i = 1, left = 1, right = 2
            //s[1] == s[2], true, result++, left-- and right++
            //s[0] == s[3], false, left-- and right++, break
            //when i = 2, left = 2, right = 3
            //s[2] == s[3], false, left-- and right++, outbound, break the loop
            left = i;
            right = i + 1;
            result += countPalindromes(s, left, right);

        }

        return result;
    }


    private int countPalindromes(String s, int left, int right) {
        int result = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            result++;
            left--;
            right++;
        }
        return result;
    }


    @Test
    public void test1() {
        String s = "abc";
        System.out.println(solution(s));
        //3
        //Explanation: Three palindromic strings: "a", "b", "c".
    }

    @Test
    public void test2() {
        String s = "aaa";
        System.out.println(solution(s));
        //6
        //Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
    }

    @Test
    public void test3() {
        String s = "aaab";
        System.out.println(solution(s));
        //7
    }

    @Test
    public void test4() {
        String s = "aabb";
        System.out.println(solution(s));
        //6
    }


}
