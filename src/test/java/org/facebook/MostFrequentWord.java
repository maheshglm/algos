package org.facebook;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentWord {

    private String solution(String[] strings) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : strings) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        String frequentWord = "";
        int count = Integer.MIN_VALUE;

        for (String key : map.keySet()) {
            if (count < map.get(key)) {
                count = map.get(key);
                frequentWord = key;
            }
        }

        return frequentWord;
    }


    @Test
    public void test1() {
        String[] input = {"Algorithms", "String", "Integer", "Integer",
                "Algorithms", "String", "Integer",
                "Algorithms", "String", "Algorithms"};

        System.out.println(solution(input));

    }

}
