package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/slowest-key/
public class SlowestKey {


    private char solution2(String keysPressed, int[] releaseTimes) {
        int longPress = releaseTimes[0];
        char slowestKey = keysPressed.charAt(0);
        for (int i = 1; i < keysPressed.length(); i++) {
            int currDuration = releaseTimes[i] - releaseTimes[i - 1];
            char currKey = keysPressed.charAt(i);
            if (currDuration > longPress) {
                longPress = currDuration;
                slowestKey = currKey;
            } else if (currDuration == longPress && currKey > slowestKey) {
                slowestKey = currKey;
            }
        }
        return slowestKey;
    }

    private char solution1(String keysPressed, int[] releaseTimes) {
        int[] duration = new int[26];
        int prevTime = 0;
        for (int i = 0; i < keysPressed.length(); i++) {
            char currKey = keysPressed.charAt(i);
            int time = releaseTimes[i];
            duration[currKey - 'a'] = Math.max(duration[currKey - 'a'], time - prevTime);
            prevTime = time;
        }

        int slowestIndex = 0;
        int maxDuration = Integer.MIN_VALUE;
        for (int i = 0; i < duration.length; i++) {
            int value = duration[i];
            if (value >= maxDuration) {
                maxDuration = value;
                slowestIndex = i;
            }
        }
        return (char) (slowestIndex + 'a');
    }

    private char solution(String keysPressed, int[] releaseTimes) {
        Map<Character, Integer> map = new HashMap<>();

        map.put(keysPressed.charAt(0), releaseTimes[0]);
        for (int i = 1; i < keysPressed.length(); i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            char currKey = keysPressed.charAt(i);

            int currVal = map.getOrDefault(currKey, 0);
            map.put(currKey, Math.max(duration, currVal));
        }

        int longestDuration = 0;
        char slowKey = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            if (value > longestDuration) {
                longestDuration = value;
                slowKey = key;
            } else if (value == longestDuration && key > slowKey) {
                slowKey = key;
            }
        }

        return slowKey;
    }


    @Test
    public void test1() {
        String keysPressed = "cbcd";
        int[] releaseTimes = {9, 29, 49, 50};
        //System.out.println(solution(keysPressed, releaseTimes));
        //System.out.println(solution1(keysPressed, releaseTimes));
        System.out.println(solution2(keysPressed, releaseTimes));
        //c
    }

    @Test
    public void test2() {
        String keysPressed = "spuda";
        int[] releaseTimes = {12, 23, 36, 46, 62};
        //System.out.println(solution(keysPressed, releaseTimes));
        //System.out.println(solution1(keysPressed, releaseTimes));
        System.out.println(solution2(keysPressed, releaseTimes));
        //a
    }
}
