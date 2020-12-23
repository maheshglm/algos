package org.facebook.LinkedLists;

import org.LinkedList;
import org.LinkedList.ListNode;
import org.junit.Test;

//https://www.youtube.com/watch?v=TsdAEkB76_0
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesI {

    private ListNode solution(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
                count++;
            } else {
                curr = curr.next;
            }
        }
        System.out.println(count);
        return head;
    }

    private ListNode solution2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        head.next = solution2(head.next);
        return head.data == head.next.data ? head.next : head;
    }

    @Test
    public void test1() {
        LinkedList<Integer> list1 = new LinkedList<>();
        ListNode<Integer> head = list1.insert(0);

        list1.insert(0);
        list1.insert(1);
        list1.insert(1);
        list1.insert(1);
        list1.insert(2);
        list1.insert(2);
        list1.insert(3);
        list1.insert(3);
        list1.insert(4);


        list1.print();

        //Output = 0 1 2 3 4
        solution(head);
        list1.print();

        //list1.print(solution2(head)); //0 1 2 3 4


    }


    @Test
    public void test2() {
        LinkedList<Integer> list1 = new LinkedList<>();
        ListNode<Integer> head = list1.insert(1);
        list1.insert(1);
        list1.insert(2);


        list1.print(); //1 1 2

        //Output = 1 2

        solution(head);
        list1.print();

        //list1.print(solution2(head));


    }

    @Test
    public void test3() {
        LinkedList<Integer> list1 = new LinkedList<>();
        ListNode<Integer> head = list1.insert(1);
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(3);

        list1.print(); //1 1 2 3 3

        //Output = 1 2 3
        //solution(head);
        //list1.print();

        list1.print(solution2(head));


    }
}
