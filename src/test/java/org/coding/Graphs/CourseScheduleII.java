package org.coding.Graphs;

import org.junit.Test;

import java.util.*;

//https://www.youtube.com/watch?v=Akt3glAwyfY
public class CourseScheduleII {

    private List<Integer> solution(int numCourses, int[][] prereqCourses) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        List<Integer> result = new ArrayList<>();

        for (int[] prereq : prereqCourses) {
            int course = prereq[0];
            int pre = prereq[1];

            List<Integer> prereqs = map.getOrDefault(course, new ArrayList<>());
            prereqs.add(pre);
            map.put(course, prereqs);
        }

        return result;
    }


    @Test
    public void test0() {
        int n = 6;
        int[][] prereqs = {
                {0, 1},
                {0, 2},
                {1, 3},
                {3, 2},
                {4, 0},
                {5, 0}
        };

    }


    @Test
    public void test1() {
        int n = 4;
        int[][] prereqs = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        //[0,2,1,3]
        /*
        Explanation: There are a total of 4 courses to take.
        To take course 3 you should have finished both courses 1 and 2.
        Both courses 1 and 2 should be taken after you finished course 0.
        So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
         */
    }

    @Test
    public void test2() {
        int n = 2;
        int[][] prereqs = {{1, 0}};
        //[0, 1]
        //Explanation: There are a total of 2 courses to take.
        //To take course 1 you should have finished course 0.
        //So the correct course order is [0,1].
    }

    @Test
    public void test3() {
        int n = 1;
        int[][] prereqs = {{}};
        //[0]
    }
}
