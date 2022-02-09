package org.coding;

import org.junit.Test;

import java.util.Arrays;

//https://www.youtube.com/watch?v=YMKpDBmDJQE
//https://www.youtube.com/watch?v=xoFLYRp8xTY&list=PL5b07qlmA3P6UWAVm6rnJXpWAB3Vnj59B&index=4
public class ShortestDistanceToChar {

    private int[] solution(String s, char c) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        int n = s.length();
        int c_position = -n;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                c_position = i;
            }
            result[i] = i - c_position;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                c_position = i;
            }
            result[i] = Math.min(result[i], Math.abs(c_position - i));
        }
        return result;
    }


    @Test
    public void test1() {
        String s = "loveleetcode";
        char c = 'e';

        System.out.println(Arrays.toString(solution(s, c)));
        //output = [3 2 1 0 1 0 0 1 2 2 1 0]
    }

    @Test
    public void test2() {
        String s = "loveleet";
        char c = 'e';

        System.out.println(Arrays.toString(solution(s, c)));
        //output = [3 2 1 0 1 0 0 1]
    }

}
