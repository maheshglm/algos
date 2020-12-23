package org.facebook;

import org.junit.Test;

//https://www.youtube.com/watch?v=eGf-26OTI-A
//https://www.youtube.com/watch?v=ySTQCRya6B0
//https://leetcode.com/problems/task-scheduler/
public class TaskScheduler {

    //Greedy approach

    private int solution(char[] tasks, int n) {
        return 1;
    }

    @Test
    public void test1() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

//        Output: 8
//        Explanation:
//        A -> B -> idle -> A -> B -> idle -> A -> B
//        There is at least 2 units of time between any two same tasks.
    }

    @Test
    public void test2() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 0;

//        Output: 6
//        Explanation: On this case any permutation of size 6 would work since n = 0.
//                ['A','A','A','B','B','B']
//                ['A','B','A','B','A','B']
//                ['B','B','B','A','A','A']
    }

    @Test
    public void test3() {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 2;

//        Output: 16
//        Explanation:
//        One possible solution is
//        A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
    }

}
