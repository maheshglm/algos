package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagrams {


    //This approach is time consuming because every iteration I am calculating length of small string.
    private List<Integer> solution(String big, String small) {
        List<Integer> indices = new ArrayList<>();

        if (big == null && small == null) return Collections.singletonList(0);
        if (big == null || small == null || big.length() < small.length()) return indices;

        for (int i = 0; i <= big.length() - small.length(); i++) {
            String substring = big.substring(i, i + small.length());
            if (isAnagram(small, substring)) {
                indices.add(i);
            }
        }
        return indices;
    }

    private boolean isAnagram(String s1, String s2) {
        int[] charsCount = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charsCount[s1.charAt(i) - 'a']++;
            charsCount[s2.charAt(i) - 'a']--;
        }

        for (int count : charsCount) {
            if (count != 0) return false;
        }
        return true;
    }

    //efficient approach
    private List<Integer> solution2(String big, String small) {
        List<Integer> indices = new ArrayList<>();
        if (big == null && small == null) return Collections.singletonList(0);
        if (big == null || small == null || big.length() < small.length()) return indices;

        int[] charsCount = new int[26];
        for (int i = 0; i < small.length(); i++) {
            charsCount[small.charAt(i) - 'a']++;
        }

        int windowStart = 0;
        int windowEnd = 0;
        int count = 0; //for every 3 chars of big string we need to check, is it anagram or not

        int[] tempCount = new int[26];

        while (windowEnd < big.length()) {
            tempCount[big.charAt(windowEnd++) - 'a']++;
            count++;
            if (count % small.length() == 0) {
                if (compareArrays(charsCount, tempCount)) {
                    indices.add(windowStart);
                }
                tempCount[big.charAt(windowStart++) - 'a']--;
                count--;
            }
        }
        return indices;
    }

    //we can use Arrays.equals in place of below method
    private boolean compareArrays(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test0() {
        String small = "ab";
        String big = "eidbaooo";
        //output = [3]
        System.out.println(solution2(big, small));
    }

    @Test
    public void test1() {
        String small = "abc";
        String big = "cbaebabacd";
        //Output - [0,6]
        //System.out.println(solution(big, small));
        System.out.println(solution2(big, small));
    }

    @Test
    public void test2() {
        String s = "abab";
        String p = "ab";
        //Output - [0,1,2]
        System.out.println(solution(s, p));
        System.out.println(solution2(s, p));
    }

}
