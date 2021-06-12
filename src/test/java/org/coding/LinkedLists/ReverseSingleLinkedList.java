package org.coding.LinkedLists;


import org.LinkedList;
import org.LinkedList.ListNode;
import org.junit.Test;

//https://www.youtube.com/watch?v=N_Y12-5oa-w&list=PLJzWER-4CS8h0LTNS_xliZFqdcnp_2uW-&index=47
public class ReverseSingleLinkedList {

    //Iterative approach space complexity O(1)
    public ListNode solution(ListNode head) {

        ListNode prev = null;
        while (head != null) {
            //step1: break the bond between curr and next nodes
            ListNode next = head.next;
            head.next = prev;

            //step2: create a new prev node now
            prev = head;

            //step3: create a new curr node and
            head = next;
        }
        return prev;
    }

    //recursive approach - space complexity O(N) to store call stack memory
    public ListNode solution1(ListNode head) {
        return recursive(head, null);
    }

    private ListNode recursive(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }

        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
        return recursive(head, newHead);
    }

    @Test
    public void test1() {

        LinkedList<Integer> list = new LinkedList<>();

        list.head = list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        //1 -> 2 -> 3 -> 4 -> 5 -> NULL

        list.print();

        ListNode curr = solution1(list.head);

        list.print(curr);


    }
}
