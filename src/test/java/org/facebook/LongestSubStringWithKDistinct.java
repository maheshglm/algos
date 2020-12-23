package org.facebook;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=MK-NZ4hN7rs
public class LongestSubStringWithKDistinct {

    public int solution(String s, int k) {
        int windowStart = 0;
        int windowEnd = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        String subString = "";

        while (windowEnd < s.length()) {
            char right = s.charAt(windowEnd);
            map.put(right, map.getOrDefault(right, 0) + 1);
            while (map.size() > k) {
                char left = s.charAt(windowStart);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                windowStart++;
            }

            //in case want to print the result string
            if (maxLength < windowEnd - windowStart + 1) {
                maxLength = windowEnd - windowStart + 1;
                subString = s.substring(windowStart, windowEnd + 1);
            }

            //maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            windowEnd++;
        }
        System.out.println(subString);
        return maxLength;
    }


    @Test
    public void test1() {
        String s = "AAAHHIBC";
        System.out.println(solution(s, 2)); //AAAHH
    }

    @Test
    public void test2() {
        String s = "aabbaacdeeeeddded";
        System.out.println(solution(s, 3)); //cdeeeeddded
    }

    @Test
    public void test3() {
        String s = "abcddefabc";
        System.out.println(solution(s, 4)); //abcdd
    }

}
