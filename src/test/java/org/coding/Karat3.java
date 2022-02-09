package org.coding;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/discuss/interview-question/1379389/Wayfair-Karat
public class Karat3 {

    /*
        We are working on a security system for a badged-access room in our company's building.
        We want to find employees who badged into our secured room unusually often. We have an unordered list of names and entry times over a single day.
        Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".
        Write a function that finds anyone who badged into the room three or more times in a one-hour period.
        Your function should return each of the employees who fit that criteria, plus the times that they badged in during the one-hour period.
        If there are multiple one-hour periods where this was true for an employee, just return the first one.
    */

    private Map<String, List<Integer>> solution(String[][] logs) {
        //Arrays.sort(logs, (a,b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));//descending order
        Arrays.sort(logs, Comparator.comparingInt(a -> Integer.parseInt(a[1])));

        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        for (String[] log : logs) {
            String name = log[0];
            int time = Integer.parseInt(log[1]);

            PriorityQueue<Integer> values = map.getOrDefault(name,
                    new PriorityQueue<>(Integer::compare));

            if (values.isEmpty()) {
                values.add(time);
            } else if (time - values.peek() <= 100) {
                values.add(time);
            } else if (time - values.peek() > 100 && values.size() < 3) {
                while (!values.isEmpty() && time - values.peek() > 100) {
                    values.poll();
                }
                values.add(time);
            }
            map.put(name, values);
        }

        Map<String, List<Integer>> result = new HashMap<>();

        for (Map.Entry<String, PriorityQueue<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > 2) {
                result.put(entry.getKey(), new ArrayList<>(entry.getValue()));
            }
        }
        return result;
    }


    @Test
    public void test1() {
        String[][] logs = {
                {"Paul", "1355"},
                {"Jennifer", "1910"},
                {"John", "835"},
                {"John", "830"},
                {"Paul", "1315"},
                {"John", "1615"},
                {"John", "1640"},
                {"Paul", "1405"},
                {"John", "855"},
                {"John", "930"},
                {"John", "915"},
                {"John", "730"},
                {"John", "940"},
                {"Jennifer", "1335"},
                {"Jennifer", "730"},
                {"John", "1630"},
                {"Jennifer", "5"}};

        System.out.println(solution(logs));

        /*
        John: 830 835 855 915 930
        Paul: 1315 1355 1405
         */

    }

    @Test
    public void test2() {
        String[][] logs = {
                {"John", "835"},
                {"John", "830"},
                {"John", "1615"},
                {"John", "1640"},
                {"John", "855"},
                {"John", "930"},
                {"John", "915"},
                {"John", "730"},
                {"John", "940"},
                {"John", "1630"}};

        System.out.println(solution(logs));

        /*
        John: 830 835 855 915 930
         */

    }

}
