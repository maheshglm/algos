package org.coding;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/discuss/interview-question/1237034/roblox-karat-initial-screening-course-pair-course-schedule
public class Karat17 {

    /*
        You are a developer for a university.
        Your current project is to develop a system for students to find courses they share with friends.
        The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.
        Write a function that takes in a collection of (student ID number, course name) pairs and returns, for every pair of students,
        a collection of all courses they share.
     */
    private Map<String, List<String>> solution1(String[][] coursePairs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < coursePairs.length - 1; i++) {
            for (int j = i + 1; j < coursePairs.length; j++) {
                String id1 = coursePairs[i][0];
                String id2 = coursePairs[j][0];

                if (!id1.equals(id2)) {
                    String key = id1.compareTo(id2) < 0 ? id1 + "," + id2 : id2 + "," + id1;
                    if (!map.containsKey(key)) {
                        map.put(key, new ArrayList<>());
                    }
                    String course1 = coursePairs[i][1];
                    String course2 = coursePairs[j][1];
                    if (course1.equals(course2)) {
                        List<String> list = map.get(key);
                        list.add(course1);
                        map.put(key, list);
                    }
                }
            }
        }
        return map;
    }


    private Map<String, String> solution(String[][] coursePairs) {
        Map<String, List<String>> coursesMap = new HashMap<>();

        for (String[] coursePair : coursePairs) {
            List<String> courses = coursesMap.getOrDefault(coursePair[0], new ArrayList<>());
            courses.add(coursePair[1]);
            coursesMap.put(coursePair[0], courses);
        }

        //58 : Linear Algebra, Mechanics, Economics, Software Design"
        //17 : Software Design, Linear Algebra, Political Science

        String[] ids = coursesMap.keySet().toArray(new String[1]);

        Map<String, String> result = new HashMap<>();

        for (int i = 0; i < ids.length; i++) {
            for (int j = i + 1; j < ids.length; j++) {
                List<String> list1 = coursesMap.get(ids[i]);
                List<String> list2 = coursesMap.get(ids[j]);

                Set<String> set = getCommonCourses(list1, list2);
                result.put(ids[i] + "," + ids[j], set.toString());
            }
        }
        return result;
    }

    private Set<String> getCommonCourses(List<String> list1, List<String> list2) {
        Set<String> result = new HashSet<>();
        for (String each : list1) {
            if (list2.contains(each)) {
                result.add(each);
            }
        }
        return result;
    }


    @Test
    public void test1() {
        String[][] student_course_pairs_1 = {
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
                {"58", "Software Design"},
        };

        System.out.println(solution(student_course_pairs_1));
        System.out.println(solution1(student_course_pairs_1));

        /*
        {
            "58,17": ["Software Design", "Linear Algebra"]
            "58,94": ["Economics"]
            "58,25": ["Economics"]
            "94,25": ["Economics"]
            "17,94": []
            "17,25": []
            }
         */

    }

}

