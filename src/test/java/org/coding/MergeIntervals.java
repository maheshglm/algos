package org.coding;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://www.youtube.com/watch?v=qKczfGUrFY4&t=22s
public class MergeIntervals {

    //Time complexity
    //O(nlogn) -
    //space -   O(logN) sorting itself takes logN space

    public int[][] solution(int[][] intervals) {
        if (intervals.length <= 0) {
            return intervals;
        }

        //Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> result = new ArrayList<>();
        int[] current_interval = intervals[0];

        result.add(current_interval);

        for (int i = 1; i < intervals.length; i++) {
            int currEnd = current_interval[1];
            int nextBegin = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (nextBegin <= currEnd) {
                current_interval[1] = Math.max(currEnd, nextEnd);
            } else {
                result.add(intervals[i]);
                current_interval = intervals[i];
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    @Test
    public void test1() {
        int[][] intervals = {{15, 18}, {1, 3}, {8, 10}, {2, 6},};

        System.out.println(Arrays.deepToString(intervals));
        System.out.println(Arrays.deepToString(solution(intervals)));

        //output [[1, 6], [8, 10], [15, 18]]
    }
}


