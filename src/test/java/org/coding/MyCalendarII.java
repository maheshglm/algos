package org.coding;

import java.util.*;

//https://leetcode.com/problems/my-calendar-ii/
public class MyCalendarII {


    //Bruteforce
    /*
    Evidently, two events [s1, e1) and [s2, e2) do not conflict if and only if one of them starts after the other one ends:
    either e1 <= s2 OR e2 <= s1. By De Morgan's laws, this means the events conflict when s1 < e2 AND s2 < e1.
     */
    List<int[]> bookings;
    List<int[]> overlaps;

    public MyCalendarII() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    //while booking instead of returning false if overlap happens, but we ll add to overlap list
    //so if the next interval is falling in overlaps itself, then 2 bookings crossed, we return false.
    public boolean book(int start, int end) {
        for (int[] overlap : overlaps) {
            if (start < overlap[1] && end > overlap[0])
                return false;
        }

        for (int[] booking : bookings) {
            if (start < booking[1] && end > booking[0]) {
                overlaps.add(new int[]{Math.max(start, booking[0]), Math.min(end, booking[1])});
            }
        }
        bookings.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendarII obj = new MyCalendarII();
        obj.book(10, 20); //true
        obj.book(50, 60); //true
        obj.book(10, 40); //true
        obj.book(5, 15); //false
        obj.book(5, 10); //true
        obj.book(25, 55); //true


    }
}
