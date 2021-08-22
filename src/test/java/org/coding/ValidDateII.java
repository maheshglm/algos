package org.coding;

import org.junit.Test;

import java.util.List;

//https://leetcode.com/discuss/interview-question/400968/Google-or-Phone-Screen-or-Valid-Date-Permutation
public class ValidDateII {


//    //format for date is year, month, date
//    private List<List<Integer>> solution(int[] nums) {
//
//    }
//

    private boolean isLeapYear(int year) {
        // Return true if year is
        // a multiple of 4 and not
        // multiple of 100.
        // OR year is multiple of 400.
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    private boolean isValidDate(int year, int month, int date) {
        if (date < 1 || date > 31) return false;
        if (month < 1 || month > 12) return false;

        if (month == 2) {
            if (isLeapYear(year)) {
                return date <= 29;
            } else {
                return date <= 28;
            }
        }

        if (month == 4 || month == 6 || month == 9 || month == 12) {
            return date <= 30;
        }
        return true;
    }


    @Test
    public void test1() {
        int[] nums = {2, 5, 29};
        //Output: [[2, 5, 29], [29, 2, 5], [29, 5, 2] [5, 2, 29]


    }
}
