package org.coding.Graphs;

import java.util.*;

//https://www.youtube.com/watch?v=EgI5nU9etnU
public class CourseSchedule {


    private boolean solution(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        //build adjList prerequisite course dependent courses
        for (int[] prerequisite : prerequisites) {
            int dependent = prerequisite[0];
            int prereq = prerequisite[1];

            if (adjList.containsKey(prereq)) {
                adjList.get(prereq).add(dependent);
            } else {
                List<Integer> courses = new ArrayList<>();
                courses.add(dependent);
                adjList.put(prereq, courses);
            }
        }

        //loop in dfs for all courses
        for (int currCourse = 0; currCourse < numCourses; currCourse++) {
            if (!isPossibleToCompleteCourse(currCourse, adjList, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPossibleToCompleteCourse(int currCourse, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        //if course is already visited - return false
        if (visited.contains(currCourse)) return false;
        //if prerequisite is empty - return true
        if (!adjList.containsKey(currCourse)) return true;

        visited.add(currCourse);

        for (int course : adjList.get(currCourse)) {
            if (!isPossibleToCompleteCourse(course, adjList, visited)) {
                return false;
            }
        }
        visited.remove(currCourse);
        adjList.remove(currCourse);
        return true;
    }

}
