package org.coding;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PermutationInString {


    //efficient approach
    private boolean solution1(String small, String big) {
        if (big == null && small == null) return true;
        if (big == null || small == null || big.length() < small.length()) return false;

        int[] charsCount = new int[26];
        for (int i = 0; i < small.length(); i++) {
            charsCount[small.charAt(i) - 'a']++;
        }

        int windowStart = 0;
        int windowEnd = 0;
        int count = 0;

        int[] tempCount = new int[26];

        while (windowEnd < big.length()) {
            tempCount[big.charAt(windowEnd++) - 'a']++;
            count++;
            if (count % small.length() == 0) {
                if (Arrays.equals(charsCount, tempCount)) {
                    return true;
                }
                tempCount[big.charAt(windowStart++) - 'a']--;
                count--;
            }
        }
        return false;
    }

    private boolean solution(String small, String big) {
        if (small == null && big == null) return true;
        if (small == null || big == null || small.length() > big.length()) return false;

        for (int i = 0; i <= big.length() - small.length(); i++) {
            if (isPermutation(small, big.substring(i, i + small.length()))) {
                return true;
            }
        }
        return false;
    }

    //this is faster than map
    private boolean isPermutation(String s1, String s2) {
        int[] char_count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char_count[s1.charAt(i) - 'a']++;
            char_count[s2.charAt(i) - 'a']--;
        }

        for (int count : char_count) {
            if (count != 0) return false;
        }
        return true;
    }

    @Test
    public void test1() {
        String small = "ab";
        String big = "eidbaooo";
        Assert.assertTrue(solution(small, big));
        Assert.assertTrue(solution1(small, big));
    }

    @Test
    public void test2() {
        String small = "ab";
        String big = "eidoaooo";
        Assert.assertFalse(solution(small, big));
        Assert.assertFalse(solution1(small, big));
    }

    @Test
    public void test3() {
        String small = "adc";
        String big = "dcda";
        Assert.assertTrue(solution(small, big));
        Assert.assertTrue(solution1(small, big));
    }

    @Test
    public void test4() {
        String small = "abcdxabcde";
        String big = "abcdeabcdx";
        Assert.assertTrue(solution(small, big));
        Assert.assertTrue(solution1(small, big));
    }

}
