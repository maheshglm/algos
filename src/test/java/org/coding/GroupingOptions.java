package org.coding;

import org.junit.Test;

//https://www.geeksforgeeks.org/count-the-number-of-ways-to-divide-n-in-k-groups-incrementally/
public class GroupingOptions {

    //recursion
    private int solution(int people, int groups) {
        return recursion(people, groups, 0, 1);
    }

    private int recursion(int people, int groups, int position, int previousValue) {


        int count = 0;

        for (int i = previousValue; i <= people; i++) {
            int temp = recursion(people - 1, groups, position + 1, previousValue);
            count += temp;
        }

        return count;
    }


    @Test
    public void test1() {
        int people = 8;
        int groups = 4;

        //5
        //[1, 1, 1, 5], [1, 1, 2, 4], [1, 1, 3, 3], [1, 2, 2, 3], [2, 2, 2, 2]

    }
}
