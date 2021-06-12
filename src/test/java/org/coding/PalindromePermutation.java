package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    private boolean solution1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                count++;
            }
        }
        return count <= 1;
    }


    @Test
    public void test1() {
        System.out.println(solution1("code")); //false
        System.out.println(solution1("aab")); //true
        System.out.println(solution1("carerac")); //true

    }


}
