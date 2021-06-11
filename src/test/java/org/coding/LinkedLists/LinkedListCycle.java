package org.coding.LinkedLists;


import org.LinkedList;
import org.junit.Test;

//https://www.youtube.com/watch?v=6OrZ4wAy4uE&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=22
public class LinkedListCycle {
    
    private boolean solution(LinkedList.ListNode head) {
        if (head == null)
            return false;

        LinkedList.ListNode slow = head;
        LinkedList.ListNode fast = head.next;
        while (slow != fast) {

            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    @Test
    public void test1() {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList.ListNode<Integer> head = list1.insert(3);
        list1.insert(2);
        list1.insert(0);
        list1.insert(-4);


    }

}
