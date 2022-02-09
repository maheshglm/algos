package org.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-average-pass-ratio/
public class MaxAvgPassRatio {

    private double solution1(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            double d0 = (double) (a[0] + 1) / (a[1] + 1) - (double) a[0] / a[1];
            double d1 = (double) (b[0] + 1) / (b[1] + 1) - (double) b[0] / b[1];
            return d1 > d0 ? 1 : -1;
        });

        double sum = 0.0;
        Collections.addAll(pq, classes);

        while (extraStudents != 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] == curr[1]) sum += 1;
            else {
                curr[0]++;
                curr[1]++;
                extraStudents--;
                pq.add(curr);
            }
        }

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            sum += (double) curr[0] / curr[1];
        }
        return sum / classes.length;
    }

    //This solution gives result if all extra students can be assigned to a single class, but
    //if all the extra students can be assigned to different classes to maximise profit, below solution does not work.
    private double solution(int[][] classes, int extraStudents) {
        double result = 0L;
        double maxHike = Double.MIN_VALUE;
        //find where to add
        int index = 0;
        int i = 0;
        for (int[] c : classes) {
            double currAvg = (double) c[0] / c[1];
            double newAvg = (double) (c[0] + extraStudents) / (c[1] + extraStudents);
            if (maxHike < newAvg - currAvg) {
                index = i;
                maxHike = newAvg - currAvg;
            }
            i++;
        }

        //calculate max avg
        for (int j = 0; j < classes.length; j++) {
            if (j == index) {
                result += (double) (classes[j][0] + extraStudents) / (classes[j][1] + extraStudents);
            } else {
                double v = (double) classes[j][0] / classes[j][1];
                result = result + v;
            }
        }
        return result / classes.length;
    }

    @Test
    public void test1() {
        int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents = 2;

        //System.out.println(solution(classes, extraStudents)); //0.783333
        System.out.println(solution1(classes, extraStudents)); //0.783333
        //System.out.println(solution2(classes, extraStudents)); //0.783333
    }

    @Test
    public void test2() {
        int[][] classes = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        int extraStudents = 4;

        //System.out.println(solution(classes, extraStudents)); //invalid
        System.out.println(solution1(classes, extraStudents)); //0.53485
    }
}

