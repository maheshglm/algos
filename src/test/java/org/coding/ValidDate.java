package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidDate {


    private boolean solution(int[] nums) {
        if (nums.length != 3) return false;

        int month = 0;
        int year = 0;
        int day = 0;

        for (int n : nums) {
            if (isValidYear(n)) {
                year = n;
            } else if (month == 0 && isValidMonth(n)) {
                month = n;
            } else if (isValidDay(n)) {
                day = n;
            } else {
                return false;
            }
        }
        return isValidDate(day, month, year);
    }

    private boolean isValidDay(int day) {
        return day >= 1 && day <= 31;
    }

    private boolean isValidMonth(int month) {
        return month >= 1 && month <= 12;
    }

    private boolean isValidYear(int year) {
        return year >= 1800 && year <= 9999;
    }

    private boolean isValidDate(int date, int month, int year) {
        //below r not required as we are already doing day and month validations
        //if (date < 1 || date > 31) return false;
        //if (month < 1 || month > 12) return false;

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


    private boolean isLeapYear(int year) {
        // Return true if year is
        // a multiple of 4 and not
        // multiple of 100.
        // OR year is multiple of 400.
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    @Test
    public void test1() {
        int[] nums = {2000, 10, 10};

        System.out.println(solution(nums));//true

//        System.out.println(isValidDate(1, 1, 2004));
//        System.out.println(isValidDate(1, 13, 2004));
//        System.out.println(isValidDate(-1, 1, 2004));
//        System.out.println(isValidDate(31, 2, 2004));

    }

    @Test
    public void test2() {
        int[] nums = {1, 32, 1990};
        //false
        System.out.println(solution(nums));
    }

    @Test
    public void test3() {
        int[] nums = {2, 2000, 30};
        System.out.println(solution(nums));
        //false
    }

    @Test
    public void test31() {
        int[] nums = {2, 2000, 29};
        System.out.println(solution(nums));
        //true
    }

    @Test
    public void test32() {
        int[] nums = {2, 2001, 29};
        System.out.println(solution(nums));
        //false
    }

    @Test
    public void test4() {
        int[] nums = {2, 4, 2001};
        System.out.println(solution(nums));
        //true
    }

    @Test
    public void test41() {
        int[] nums = {2, 2, 2001};
        System.out.println(solution(nums));
        //true
    }

}
