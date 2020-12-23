package org.facebook;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FindNonDuplicateNumber {

    //This uses additional map
    private static int solution(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map.entrySet().stream()
                .filter(entry -> entry.getValue().equals(1))
                .map(Map.Entry::getKey).findFirst().get();
    }

    // What if we use XOR ? The basic idea of using XOR operation is a^c^c =a,
    // which means two xor operations with the same number will eliminate the number by becoming zero
    // and we will be left with a single number which does not have duplicate.
    private static int solution1(int[] arr) {
        int xor = 0;
        for (int a : arr) {
            xor = xor ^ a;
        }
        return xor;
    }

    @Test
    public void test1() {
        int[] a = {2, 2, 1};
        Assert.assertEquals(1, solution1(a));
    }

    @Test
    public void test2() {
        int[] a = {4, 1, 2, 2, 1};
        Assert.assertEquals(4, solution1(a));
    }
}
