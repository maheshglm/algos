package org.facebook.LinkedLists;

import org.LinkedList;
import org.LinkedList.ListNode;
import org.junit.Test;

//https://www.youtube.com/watch?v=wk4QsvwQwdQ
public class CheckPalindrome {

    private boolean solution(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (slow.data != fast.data)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    @Test
    public void test1() {
        LinkedList<Integer> list = new LinkedList<>();
        ListNode<Integer> head = list.insert(1);
        list.insert(2);
        list.insert(2);
        list.insert(1);

        System.out.println(solution(head)); //true


    }

    @Test
    public void test2() {
        LinkedList<Integer> list = new LinkedList<>();
        ListNode<Integer> head = list.insert(1);
        list.insert(2);
        list.insert(1);
        list.insert(1);

        System.out.println(solution(head)); //false


    }
}
