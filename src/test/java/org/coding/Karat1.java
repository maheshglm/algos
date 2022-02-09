package org.coding;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/discuss/interview-experience/1143589/indeed-sdet-karat-interview-question
public class Karat1 {

// We are working on a security system for a badged-access room in our company's building.
// Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:
// 1. All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit.
//    (All employees are required to leave the room before the log ends.)
// 2. All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter.
//    (The room is empty when the log begins.)
// Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.

    public List<Set<String>> solution(List<List<String>> log) {
        Set<String> noExit = new HashSet<>();
        Set<String> noEnter = new HashSet<>();

        Map<String, Boolean> latest = new HashMap<>();

        for (List<String> each : log) {
            boolean status = latest.getOrDefault(each.get(0), false);

            if (each.get(1).equals("enter")) {
                if (status) {
                    noExit.add(each.get(0));
                }
                latest.put(each.get(0), true);
            } else {
                if (!status) {
                    noEnter.add(each.get(0));
                }
                latest.put(each.get(0), false);
            }
        }

        //noExit for whoever has only entered i.e. status = true
        for (String key : latest.keySet()) {
            if (latest.get(key)) {
                noExit.add(key);
            }
        }
        return Arrays.asList(noExit, noEnter);
    }


    @Test
    public void test1() {
        List<List<String>> log = new LinkedList<>();
        log.add(Arrays.asList("Paul", "enter"));
        log.add(Arrays.asList("Paul", "exit"));
        log.add(Arrays.asList("Paul", "exit"));
        log.add(Arrays.asList("Paul", "enter"));
        log.add(Arrays.asList("Martha", "enter"));
        log.add(Arrays.asList("Martha", "exit"));

        System.out.println(solution(log));

        //["Paul"], ["Paul"]
    }

    @Test
    public void test2() {
        List<List<String>> log = new LinkedList<>();
        log.add(Arrays.asList("Paul", "enter"));
        log.add(Arrays.asList("Paul", "exit"));
        log.add(Arrays.asList("Paul", "exit"));

        System.out.println(solution(log));

        //[""], ["Paul"]
    }

    @Test
    public void test3() {
        List<List<String>> log = new LinkedList<>();
        log.add(Arrays.asList("Paul", "enter"));
        log.add(Arrays.asList("Paul", "enter"));
        log.add(Arrays.asList("Paul", "exit"));

        System.out.println(solution(log));

        //["Paul"], [""]
    }

}
