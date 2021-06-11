package org.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortStringsLexo {


    //normal order
    private List<String> solution1(List<String> list) {
        Collections.sort(list);
        return list;
    }

    //reverse sort
    private List<String> solution2(List<String> list) {
        //list.sort(Comparator.reverseOrder());
        list.sort((((o1, o2) -> o2.compareTo(o1))));
        return list;
    }

    //normal order - numeric
    private List<Integer> solution3(List<Integer> list) {
        Collections.sort(list);
        return list;
    }

    //normal order - numeric
    private List<Integer> solution4(List<Integer> list) {
        //list.sort((((o1, o2) -> o2.compareTo(o1)))); this also works
        //list.sort(Comparator.reverseOrder()); this also works
        list.sort((o1, o2) -> o2 - o1);
        return list;
    }


    @Test
    public void test1() {
        List<String> list = Arrays.asList("Hello", "Mahesh", "Am", "I", "Hi");
        //Output -> [Am, Hello, Hi, I, Mahesh]
        System.out.println(solution1(list));

        //Output -> [Mahesh, I, Hi, Hello, Am]
        System.out.println(solution2(list));
    }

    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(5, 1, 10, 3, 20, 77);
        //Output -> [1, 3, 5, 10, 20, 77]
        System.out.println(solution3(list));

        //output -> [77, 20, 10, 5, 3, 1]
        System.out.println(solution4(list));
    }
}
