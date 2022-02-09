package org.coding;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/discuss/interview-question/647667/Roblox-Karat-Interview/551684
public class Karat18 {

    /*
        You're developing a system for scheduling advising meetings with students in a Computer Science program.
        Each meeting should be scheduled when a student has completed 50% of their academic program.
        Each course at our university has at most one prerequisite that must be taken first.
        No two courses share a prerequisite. There is only one path through the program.
        Write a function that takes a list of (prerequisite, course) pairs,
        and returns the name of the course that the student will be taking when they are halfway through their program.
        (If a track has an even number of courses, and therefore has two "middle" courses, you should return the first one.)
     */

    private String solution(String[][] prereqCourses) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> courses = new HashSet<>();

        //build an map with prereq -> courses
        //set of all courses
        for (String[] pair : prereqCourses) {
            String prereq = pair[0];
            String course = pair[1];
            List<String> list = map.getOrDefault(prereq, new ArrayList<>());
            list.add(course);
            map.put(prereq, list);
            courses.add(course);
        }

        Set<String> prerqs = map.keySet();

        //a course from prerequisites which is not there in courses is the base course.
        String baseCourse = "";
        for (String prereq : prerqs) {
            if (!courses.contains(prereq)) {
                baseCourse = prereq;
                break;
            }
        }

        int count = 0;
        List<String> order = new ArrayList<>();
        order.add(baseCourse);

        while (count < courses.size()) {
            baseCourse = map.get(baseCourse).get(0);
            order.add(baseCourse);
            count++;
        }

        int mid = order.size() / 2;
        if (order.size() % 2 == 0) {
            mid -= 1;
        }

        return order.get(mid);
    }


    @Test
    public void test1() {
        String[][] prereq_courses1 = {
                {"Foundations of Computer Science", "Operating Systems"},
                {"Data Structures", "Algorithms"},
                {"Computer Networks", "Computer Architecture"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Computer Architecture", "Data Structures"},
                {"Software Design", "Computer Networks"}
        };

        System.out.println(solution(prereq_courses1));

        /*
        Software Design
        Computer Networks
        Computer Architecture
        Data Structures
        Algorithms
        Foundations of Computer Science
        Operating Systems
         */

        //"Data Structures"
    }


    @Test
    public void test2() {
        String[][] prereqs_courses2 = {
                {"Data Structures", "Algorithms"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Foundations of Computer Science", "Logic"}
        };
        System.out.println(solution(prereqs_courses2));
        //Algorithms
    }

    @Test
    public void test3() {
        String[][] prereqs_courses2 = {
                {"Data Structures", "Algorithms"}
        };
        System.out.println(solution(prereqs_courses2));
        //"Data Structures"
    }
}
