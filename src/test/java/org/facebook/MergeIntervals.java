package org.facebook;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=qKczfGUrFY4&t=22s
public class MergeIntervals {

    public int[][] solution(int[][] intervals) {
        if (intervals.length <= 0) {
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> result = new ArrayList<>();

        int[] current_interval = intervals[0];

        result.add(current_interval);

        for (int[] interval : intervals) {
            int current_end = current_interval[1];
            int next_begin = interval[0];
            int next_end = interval[1];

            if (current_end >= next_begin) {
                current_interval[1] = Math.max(current_end, next_end);
            } else {
                result.add(interval);
                current_interval = interval;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    @Test
    public void test1() {
        int[][] intervals = {{15, 18}, {1, 3}, {8, 10}, {2, 6},};

        System.out.println(Arrays.deepToString(intervals));

        System.out.println(Arrays.deepToString(solution(intervals)));

    }
}


