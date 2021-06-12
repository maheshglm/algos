package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.youtube.com/watch?v=s9-MZZKLpmI&list=PL5b07qlmA3P6UWAVm6rnJXpWAB3Vnj59B&index=147
public class MinPathSum {

    private int solution(List<List<Integer>> triangle) {
        //define dp with last row
        List<Integer> dp = new ArrayList<>(triangle.get(triangle.size() - 1));

        //loop thru all rows from bottom like 3rd row, 2nd row and 1st row
        for (int i = triangle.size() - 2; i >= 0; i--) {
            //iterate all elements of each list
            for (int j = 0; j <= i; j++) {
                int minOfPreviousRow = Math.min(dp.get(j), dp.get(j + 1));
                int currRowValue = triangle.get(i).get(j);
                dp.set(j, minOfPreviousRow + currRowValue);
            }
        }
        return dp.get(0);
    }


    @Test
    public void test1() {
        List<Integer> list1 = Collections.singletonList(2);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<Integer> list3 = Arrays.asList(6, 5, 7);
        List<Integer> list4 = Arrays.asList(4, 1, 8, 3);

        List<List<Integer>> triangle = Arrays.asList(list1, list2, list3, list4);

        System.out.println(solution(triangle)); // 11
    }

    @Test
    public void test2() {
        List<Integer> list1 = Collections.singletonList(-1);
        List<Integer> list2 = Arrays.asList(0, 0);
        List<Integer> list3 = Arrays.asList(0, 1, 0);
        List<Integer> list4 = Arrays.asList(0, 0, 0, 0);

        List<List<Integer>> triangle = Arrays.asList(list1, list2, list3, list4);

        System.out.println(solution(triangle)); // -1
    }

}
