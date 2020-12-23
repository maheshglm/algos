package org.facebook;

import org.junit.Test;

//https://algorithms.tutorialhorizon.com/find-largest-and-smallest-word-in-a-given-string/
public class LargestNSmallestWord {


    private void solution(String s) {
        String[] arr = s.split("\\W+");
        if (arr.length <= 1) {
            System.out.println("smallest " + arr[0]);
            System.out.println("largest " + arr[0]);
            return;
        }

        String result = "";
        int smallestLength = Integer.MAX_VALUE;
        for (String word : arr) {
            if (smallestLength > word.length()) {
                smallestLength = word.length();
                result = word;
            }
        }

        System.out.println("smallest " + result);

        int largestLength = Integer.MIN_VALUE;
        for (String word : arr) {
            if (largestLength < word.length()) {
                largestLength = word.length();
                result = word;
            }
        }
        System.out.println("largest " + result);

    }

    @Test
    public void test1() {
        String s = "test";
        solution(s);
    }

    @Test
    public void test2() {
        String s = "This problem is solved at the Algorithms tutorial horizon";
        solution(s);
    }

}
