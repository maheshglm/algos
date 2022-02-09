package org.coding.Graphs;

import org.junit.Test;

import java.util.*;

//https://www.youtube.com/watch?v=EgI5nU9etnU
public class CourseSchedule {

    private boolean solution(int numCourses, int[][] courses) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        //In DFS as we are removing keys which are independent, map not contains these courses.
        // so its not required to initialze independent courses in the adjList
//        //set all courses to empty List
//        for (int i = 0; i < numCourses; i++) {
//            adjList.put(i, new ArrayList<>());
//        }

        //build adjList course as key and Prerequisites as List of values
        for (int[] course : courses) {
            int dependent = course[0];
            int prereq = course[1];

            List<Integer> list = adjList.getOrDefault(dependent, new ArrayList<>());
            list.add(prereq);
            adjList.put(dependent, list);
        }

        //loop in dfs for all courses
        for (int currCourse = 0; currCourse < numCourses; currCourse++) {
            if (!dfs(currCourse, adjList, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int currCourse, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        //if course is already visited - return false
        if (visited.contains(currCourse)) return false;
        //if prerequisite is empty - return true
        if (!adjList.containsKey(currCourse)) return true;

        visited.add(currCourse);

        for (int course : adjList.get(currCourse)) {
            if (!dfs(course, adjList, visited)) {
                return false;
            }
        }

        visited.remove(currCourse);
        adjList.remove(currCourse);
        return true;
    }


    @Test
    public void test1() {
        int[][] courses = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}};
        int n = 5;
        System.out.println(solution(n, courses));//true
    }

    @Test
    public void test2() {
        int[][] courses = {{0, 1}, {1, 0}};
        int n = 2;
        System.out.println(solution(n, courses)); //false
    }

    @Test
    public void test3() {
        int[][] courses = {{0, 1}};
        int n = 2;
        System.out.println(solution(n, courses)); //true
    }
}
