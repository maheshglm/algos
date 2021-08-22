package org.coding;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/problems/shortest-way-to-form-string/
//https://www.youtube.com/watch?v=evesA3gr9BE
public class ShortestWayToString {

    //O(N^2) can be O(MN)
    private int solution(String source, String target) {
        int count = 1;
        int i = 0;
        for (char c : target.toCharArray()) {
            i = source.indexOf(c, i);//index of is liner complexity
            if (i == -1) {
                count += 1;
                i = source.indexOf(c);
                if (i == -1) {
                    return -1;
                }
            }
            i++;
        }
        return count;
    }

    //https://www.youtube.com/watch?v=zrK3lF6mHBE&t=513s
    private int solution1(String source, String target) {
        //create a complex map of source chars with each occurrence from that index
        char[] s = source.toCharArray();
        int sLen = source.length();

        //Build complex mapping
        int[][] mapping = new int[sLen][26];

        Arrays.fill(mapping[sLen - 1], -1); //-1 means no character

        //last character from position from last index
        mapping[sLen - 1][s[sLen - 1] - 'a'] = sLen - 1;

        for (int i = sLen - 2; i >= 0; i--) {
            mapping[i] = Arrays.copyOf(mapping[i + 1], 26);
            mapping[i][s[i] - 'a'] = i;
        }

        // 0 = {int[26]@1108} [0, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
        // 1 = {int[26]@1106} [3, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
        // 2 = {int[26]@1104} [3, 4, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
        // 3 = {int[26]@1102} [3, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
        // 4 = {int[26]@1100} [6, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
        // 5 = {int[26]@1098} [6, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
        // 6 = {int[26]@1096} [6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]

        int i = 0;
        int count = 1;

        for (char c : target.toCharArray()) {
            //if char is not available in first row, then it will never be available
            int ch = c - 'a';
            if (mapping[0][ch] == -1) return -1;

            if (i == sLen || mapping[i][ch] == -1) {
                count++;
                i = 0;
            }
            i = mapping[i][ch] + 1;
        }
        return count;


    }

    @Test
    public void test5() {
        String source = "abcabba";
        String target = "aabacb";
        System.out.println(solution(source, target));
        System.out.println(solution1(source, target));
        //2 aaba cb
    }

    @Test
    public void test0() {
        String source = "abcd";
        String target = "aabacb";
        System.out.println(solution(source, target));
        //4 a ab ac b
    }

    @Test
    public void test1() {
        String source = "abc";
        String target = "abcbc";
        System.out.println(solution(source, target));
        //Output 2
        /*
        The target "abcbc" can be formed by "abc" and "bc",
        which are subsequences of source "abc"
         */
    }

    @Test
    public void test2() {
        String source = "abc";
        String target = "acdbc";
        System.out.println(solution(source, target));
        //Output -1
        /*
        The target string cannot be constructed
        from the subsequences of source string due to the character "d" in target string.
         */
    }

    @Test
    public void test3() {
        String source = "xyz";
        String target = "xzyxz";
        System.out.println(solution(source, target));
        //Output 3
        /*
        Explanation: The target string can be constructed as follows "xz" + "y" + "xz".
         */
    }


}
