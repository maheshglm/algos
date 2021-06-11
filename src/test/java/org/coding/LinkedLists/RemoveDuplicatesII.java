package org.coding.LinkedLists;

import org.LinkedList;
import org.LinkedList.ListNode;
import org.junit.Test;

//https://www.youtube.com/watch?v=-jHoA0e-IJ0&t=2s
//https://www.youtube.com/watch?v=rcKmKBmC2NY
//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicatesII {

    private ListNode solution(ListNode head) {
        return head;
    }

    @Test
    public void test1() {
        LinkedList<Integer> list1 = new LinkedList<>();

        LinkedList.ListNode<Integer> head = list1.insert(1);
        list1.insert(1);
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);

        //output - 2 3

        solution(head);

        list1.print(solution(head));

    }

    @Test
    public void test2() {
        LinkedList<Integer> list1 = new LinkedList<>();

        LinkedList.ListNode<Integer> head = list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(3);
        list1.insert(4);
        list1.insert(4);
        list1.insert(5);

        //output - 1 2 5

        solution(head);

        list1.print();

    }
}
