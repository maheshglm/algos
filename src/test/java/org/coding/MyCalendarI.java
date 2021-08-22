package org.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/my-calendar-i/
public class MyCalendarI {


    //Brute force approach

    //O(N^2)
    List<int[]> bookings;

    public MyCalendarI() {
        bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] booking : bookings) {
            if (start < booking[1] && end > booking[0]) {
                return false;
            }
        }
        bookings.add(new int[]{start, end});
        return true;
    }


    //O(N)

//    TreeMap<Integer, Integer> calendar;
//
//    public MyCalendarI() {
//        calendar = new TreeMap<>();
//    }
//
//    //Time O(NlogN) where NN is the number of events booked. For each new event,
//    //we search that the event is legal in O(logN) time, then insert it in O(1)O(1) time
//    public boolean book(int start, int end) {
//        Map.Entry<Integer, Integer> floor = calendar.floorEntry(start);
//        Map.Entry<Integer, Integer> ceiling = calendar.ceilingEntry(start);
//
//        if ((floor == null || start >= floor.getValue()) &&
//                (ceiling == null || end <= ceiling.getKey())) {
//            calendar.put(start, end);
//            return true;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        MyCalendarI calendar = new MyCalendarI();
        System.out.println(calendar.book(10, 20)); //True
        System.out.println(calendar.book(15, 25)); //false
        System.out.println(calendar.book(20, 30)); //true

        calendar = new MyCalendarI();

        System.out.println(calendar.book(47, 50)); //True
        System.out.println(calendar.book(33, 41)); //true
        System.out.println(calendar.book(39, 45)); //false
        System.out.println(calendar.book(33, 42)); //false
        System.out.println(calendar.book(25, 32)); //true
        System.out.println(calendar.book(26, 35)); //false
        System.out.println(calendar.book(19, 25)); //true
        System.out.println(calendar.book(3, 8)); //true
        System.out.println(calendar.book(8, 13)); //true
        System.out.println(calendar.book(18, 27)); //false

    }
}
