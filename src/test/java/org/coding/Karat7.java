package org.coding;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//https://leetcode.com/discuss/interview-question/801225/Indeed-Karat-Interview
public class Karat7 {

    private List<Integer> solution(String[][] sequence, String errorStr) {
        List<Integer> result = new ArrayList<>();
        if (sequence == null || sequence.length == 0) return result;

        Map<String, StringBuilder> map = new HashMap<>();

        for (String[] each : sequence) {
            StringBuilder sb = map.getOrDefault(each[1], new StringBuilder());
            sb.append(each[0]);
            map.put(each[1], sb);
        }

        for (Map.Entry<String, StringBuilder> entry : map.entrySet()) {
            if (isSubSequence(entry.getValue().toString(), errorStr)) {
                result.add(Integer.parseInt(entry.getKey()));
            }
        }
        return result;
    }

    private boolean isSubSequence(String str1, String str2) {
        if (str1.length() < str2.length()) return false;

        int j = 0;
        int i = 0;
        while (i < str1.length()) {
            if (j < str2.length() && str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == str2.length();
    }


    @Test
    public void test1() {
        String[][] sequence = {
                {"A", "1"},
                {"B", "1"},
                {"B", "2"},
                {"C", "1"},
                {"C", "2"},
                {"C", "3"},
                {"A", "2"},
                {"A", "3"},
                {"A", "2"},
                {"B", "2"},
                {"C", "2"},
        };

        List<Integer> result = solution(sequence, "ABC");

        List<Integer> expected = Arrays.asList(2, 1);

        Assert.assertTrue(result.size() == expected.size()
                && expected.containsAll(result));
    }

    @Test
    public void test2() {
        String[][] sequence = {
                {"A", "1"},
                {"B", "1"},
                {"B", "2"},
                {"C", "1"},
                {"C", "2"},
                {"C", "3"},
                {"A", "2"},
                {"A", "3"},
                {"A", "2"},
                {"B", "2"},
                {"C", "2"},
        };

        List<Integer> result = solution(sequence, "CA");

        List<Integer> expected = Arrays.asList(2, 3);

        Assert.assertTrue(result.size() == expected.size()
                && expected.containsAll(result));
    }

    @Test
    public void test3() {
        String[][] sequence = {
                {"A", "1"},
                {"A", "1"},
                {"A", "1"},
                {"B", "1"},
                {"B", "2"},
                {"C", "2"},
                {"C", "2"},
                {"C", "3"},
                {"A", "2"},
                {"A", "3"},
                {"A", "2"},
                {"B", "2"},
                {"C", "2"},
        };

        List<Integer> result = solution(sequence, "BAC");

        List<Integer> expected = Collections.singletonList(2);

        Assert.assertTrue(result.size() == expected.size()
                && expected.containsAll(result));
    }
}

