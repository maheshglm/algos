package org.coding;

import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/723408/Sliding-Window-with-explanation-and-very-readable-with-comments
//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/518863/Python-3-%3A-Elegant-with-explanation
//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
public class SubStringsWithAll3Chars {


    /*
    a a a b c c
    | | | | | |
    0 1 2 3 4 5

    For i = 0, last = [0, -1, -1] and min(last) = -1

    For i = 1, last = [1, -1, -1] and min(last) = -1

    For i = 2, last = [2, -1, -1] and min(last) = -1

    For i = 3, last = [2, 3, -1] and min(last) = -1

    For i = 4, last = [2, 3, 4] and min(last) = 2.

    So, this adds 2 + 1 = 3 substrings to the final result.
    The substrings are abc, aabc and aaabc
    For i = 5, last = [2, 3, 5] and min(last) = 2

    So, this adds 2 + 1 = 3 substrings to the final result
    The susbtrings are abcc, aabcc and aaabcc
    Final result = 6
     */

    //this solution takes more time
    private int solution1(String s) {
        int[] lastIndices = new int[]{-1, -1, -1};
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            lastIndices[s.charAt(i) - 'a'] = i;
            result += Arrays.stream(lastIndices).min().getAsInt() + 1;
        }
        return result;
    }

    /*
    Given a string s consisting only of characters a, b and c.
    Return the number of substrings containing at least one occurrence of all these characters a, b and c.
     */
    private int solution(String s) {
        int left = 0;
        int right = 0;

        int[] count = new int[3];

        int result = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            count[ch - 'a']++;

            while (left <= right && count[0] >= 1 && count[1] >= 1 && count[2] >= 1) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            //each idx after closing will be equal to the number of substrings after this idx
            result += left;
            right++;
        }

        return result;

    }


    @Test
    public void test1() {
        String s = "abcabc";
        System.out.println(solution(s));
        System.out.println(solution1(s));
        //Output 10
        /*
        Explanation: The substrings containing at least one occurrence of the characters a, b and c are
        "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
         */
    }

    @Test
    public void test2() {
        String s = "aaacb";
        System.out.println(solution(s));
        System.out.println(solution1(s));
        //3
        /*
        Explanation: The substrings containing at least one occurrence of the characters a, b and c are
        "aaacb", "aacb" and "acb".
         */
    }

    @Test
    public void test3() {
        String s = "abc";
        System.out.println(solution(s));
        System.out.println(solution1(s));
        //1
    }

    @Test
    public void test4() {
        String s = "aaabbccabc";
        System.out.println(solution(s));
        System.out.println(solution1(s));
        //1
    }

    @Test
    public void test5() {
        String s = "abcabc";
        System.out.println(solution(s));
        System.out.println(solution1(s));
        //10
    }

}
