package org.coding.LinkedLists;

import org.LinkedList;
import org.junit.Test;

public class LengthOfLinkedList {

    //Iterative
    private int solution(LinkedList.ListNode head) {
        int count = 0;
        if (head == null) {
            return count;
        }
        LinkedList.ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }

    //recursion
    private int solution1(LinkedList.ListNode head) {
        if (head == null) {
            return 0;
        }
        return solution1(head.next) + 1;
    }


    @Test
    public void test1() {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.println(solution(list.head));
        System.out.println(solution1(list.head));


    }
}
