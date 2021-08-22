package org.coding;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://www.youtube.com/watch?v=K7B9ZTKoRpQ
//https://leetcode.com/problems/insert-interval/discuss/21602/Short-and-straight-forward-Java-solution
//Insert Interval
public class MergeIntervalsII {

    //time O(N)
    //space O(N) to keep output
    private int[][] solution(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        //Add all intervals which are occurring before new interval
        //if every interval end time is less than new interval time,
        //i.e. ideally after one interval ends then only new one starts
        //keep adding to the result
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        //what if current interval overlap happened with new interval
        //merge all overlap intervals
        //as long as current start time is less then new interval end time
        //calculate the interval start and end time runtime instead of adding
        //i.e. merging all intervals falls in range
        //ex: if new interval is (4 , 8) -- all intervals which has starting time less than 8
        //fall under overlapping category. But if the interval starts from (10, 12), then loop exits.
        while (i < n && intervals[i][0] <= newInterval[1]) {
            //for start time of new interval it should be minimum between 2 intervals
            //for end time of new interval it should be maximum between 2 intervals
            //curr (3, 5) new is (4,8)
            //new new start is min (3, 4) = 3
            //new new end is max(5, 8) = 8
            //curr (6, 7) new is (3,8)
            //new new start is min(3, 6) = 3
            //new new end is max(7, 8) = 9
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        //at the end of loop newInterval variable contains overlapping sequence of start , end times
        result.add(newInterval);

        while (i < n) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][2]);
    }

    @Test
    public void test1() {

    }

}
